package com.epam.ta.service;

import com.epam.ta.model.Calculator;

public class CalculatorCreator {

    public static final String VMCLASS = "vmclass";
    public static final String INSTANCE_TYPE = "instanceType";
    public static final String REGION = "region";
    public static final String LOCAL_SSD = "localSSD";
    public static final String COMMITMENT_TERM = "commitmentTerm";
    public static final String COST = "cost";
    public static final String GPU_TYPE = "GPUType";
    public static final String NUMBER_OF_INSTANCES = "numberOfInstanes";
    public static final String NUMBER_OF_GPU = "numberOfGPU";

    public static Calculator createEstimateFromProperty() {
        return new Calculator(TestDataReader.getTestData(VMCLASS),
                TestDataReader.getTestData(REGION),
                TestDataReader.getTestData(COMMITMENT_TERM), TestDataReader.getTestData(COST),
                TestDataReader.getTestData(LOCAL_SSD),
                TestDataReader.getTestData(INSTANCE_TYPE), TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(NUMBER_OF_GPU), TestDataReader.getTestData(NUMBER_OF_INSTANCES));
    }

}
