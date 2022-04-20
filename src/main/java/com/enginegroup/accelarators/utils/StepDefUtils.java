package com.enginegroup.accelarators.utils;

import io.cucumber.java.Scenario;
import net.thucydides.core.steps.StepEventBus;


public class StepDefUtils {

    public static String getCurrentStepName() {
        if (!StepEventBus.getEventBus().isBaseStepListenerRegistered()) {
            return "Unknown"; // CucumberWithSerenity is required.
        }
        String step = StepEventBus.getEventBus().getCurrentStep().get().getDescription();
        System.out.println("Current Step Description: " + step);
        return step;
    }

    public static String getCurrentScenarioName() {
        if (!StepEventBus.getEventBus().isBaseStepListenerRegistered()) {
            return "Unknown"; // CucumberWithSerenity is required.
        }
         return Scenario.class.getName();
    }
}
