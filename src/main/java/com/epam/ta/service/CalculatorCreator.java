package com.epam.ta.service;

import com.epam.ta.model.Calculator;

public class CalculatorCreator {

    private static final String NUMBER_OF_INSTANCES = "numberOfInstances";
    private static final String INSTANCE_TYPE = "instanceType";
    private static final String NUMBER_OF_GPU = "numberOfGPU";
    private static final String GPU_TYPE = "GPUType";
    private static final String LOCAL_SSD = "localSSD";
    private static final String REGION = "region";
    private static final String COMMITMENT_TERM = "commitmentTerm";

    public static Calculator createEstimateFromProperty() {
        return new Calculator(TestDataReader.getTestData(NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(INSTANCE_TYPE),
                TestDataReader.getTestData(NUMBER_OF_GPU),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(REGION),
                TestDataReader.getTestData(COMMITMENT_TERM));
    }

}
