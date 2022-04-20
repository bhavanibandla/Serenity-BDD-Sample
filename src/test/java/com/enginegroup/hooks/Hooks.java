package com.enginegroup.hooks;

import io.cucumber.java.*;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Executing before scenario for : " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("Executing after scenario for : " + scenario.getName());
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("In Before step...");
            //TODO: Need to capture the Step which is going to execute
            //Need some kind of implementation like step.getName()

    }

    @AfterStep
    public void afterStep() {

    }

}
