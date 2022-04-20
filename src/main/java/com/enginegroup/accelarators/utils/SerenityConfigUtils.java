package com.enginegroup.accelarators.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

public class SerenityConfigUtils {

    private static EnvironmentVariables environmentVariables;

    public static String getEnvBaseUrl(String propertyKey) {
        return EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("environments.default." + propertyKey);
    }
}
