package com.enginegroup.runner;

import com.enginegroup.hooks.SerenityTestHooks;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty","timeline:test-output-thread/"},
        features = "src/test/resources/features/ui/HomePage.feature",
        glue = {"com.enginegroup.stepdef", "SerenityTestHooks"})
public class ParallelTestRunner2 extends SerenityTestHooks { }