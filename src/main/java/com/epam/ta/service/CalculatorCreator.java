package com.epam.ta.service;

import com.epam.ta.model.Calculator;

public class CalculatorCreator {

    public static final String TESTDATA_NUMBER_OF_INSTANCES = "testdata.numberOfInstances";
    public static final String TESTDATA_COMMITMENT_TERM = "testdata.commitmentTerm";
    public static final String TESTDATA_COST = "testdata.cost";
   // public static final String TESTDATA_EMAIL= "testdata.email";
    public static final String TESTDATA_LOCAL_SSD = "testdata.localSSD";
    public static final String TESTDATA_VMCLASS = "testdata.vmclass";
    public static final String TESTDATA_REGION = "testdata.region";
    public static final String TESTDATA_INSTANCE_TYPE = "testdata.instanceType";

    public static Calculator withCredentialsFromProperty(){
        return new Calculator(TestDataReader.getTestData(TESTDATA_VMCLASS),
                TestDataReader.getTestData(TESTDATA_REGION),TestDataReader.getTestData(TESTDATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_COMMITMENT_TERM),TestDataReader.getTestData(TESTDATA_COST),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_INSTANCE_TYPE));
    }

}
