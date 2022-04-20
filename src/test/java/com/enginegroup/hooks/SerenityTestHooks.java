package com.enginegroup.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.cucumber.suiteslicing.SerenityTags;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SerenityTestHooks {

    @Before
    public void before(Scenario scenario) {
        scenario.getName();
    }

    @BeforeEach
    public static void setUp() {
        SerenityTags.create().tagScenarioWithBatchingInfo();
    }

    @AfterEach
    public static void tearDown() {
    }
}