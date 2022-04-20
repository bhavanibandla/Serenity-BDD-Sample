package com.enginegroup.webdrivermanager.remotewebdriver;

import net.thucydides.core.webdriver.DriverSource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.enginegroup.accelarators.utils.StepDefUtils.getCurrentScenarioName;

public class LambdaTestSerenityDriver implements DriverSource {
    public static RemoteWebDriver driver;
    public static String username;
    public static String accessKey;
    public static String configFiles_path = "src/test/resources/conf/";
    public static String executionMode = System.getProperty("environment");
    public static String browsers = "chrome,firefox,edge,safari";

    public WebDriver newDriver() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        JSONParser parser = new JSONParser();

        JSONObject config;

        try {
            config = (JSONObject) parser.parse(new FileReader(configFiles_path + getFileNameBasedOnEnvironmentName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        JSONObject envs = (JSONObject) config.get("environments");

        String[] browsersList = browsers.split(",");

        for (String browserName : browsersList) {

            System.out.println("Browser Name picked: " + browserName);
            System.out.println("envs: " + envs);

            if (envs.size() > 1 && envs.size() <= 4) {

                Map<String, String> envCapabilities = (Map<String, String>) envs.get(browserName);
                System.out.println("envCaps for " + browserName + ": " + envCapabilities);

                Iterator it = envCapabilities.entrySet().iterator();

                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
                }

                Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
                it = commonCapabilities.entrySet().iterator();

                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    if (capabilities.getCapability(pair.getKey().toString()) == null) {
                        capabilities.setCapability(pair.getKey().toString(), (pair.getValue().toString().equalsIgnoreCase("true") || (pair.getValue().toString().equalsIgnoreCase("false")) ? Boolean.parseBoolean(pair.getValue().toString()) : pair.getValue().toString()));
                    }
                }

                capabilities.setCapability("name", getCurrentScenarioName());

                username = System.getenv("LT_USERNAME");
                if (username == null) {
                    username = (String) config.get("lt.user");
                }

                accessKey = System.getenv("LT_ACCESS_KEY");
                if (accessKey == null) {
                    accessKey = (String) config.get("lt.key");
                }

                System.out.println("capabilities for " + executionMode + "execution using " + browserName + ": " + capabilities);

                try {
                    driver = new RemoteWebDriver(new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"), capabilities);
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                } catch (Exception exception) {
                    System.out.println(exception);
                }

                if (envs.size() == 4) {
                    System.out.println(executionMode + " execution mode selected so running tests on lambdatest remote grid!");
                }

            } else {
                System.out.println(executionMode + " execution mode selected so running tests on lambdatest remote grid using " + browserName + " browser");
                break;
            }
        }
        return driver;
    }

    public static String getFileNameBasedOnEnvironmentName() {
        String configFileName = null;
        File[] files = new File(configFiles_path).listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().contains(executionMode)) {
                configFileName = file.getName();
            }
        }
        return configFileName;
    }

    public boolean takesScreenshots() {
        return true;
    }
}