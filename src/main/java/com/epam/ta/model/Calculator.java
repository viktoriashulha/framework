package com.epam.ta.model;

import java.util.Objects;

public class Calculator {

    private String numberOfInstances;
    private String VMClass;
    private String instanceType;
    private String numberOfGPUs;
    private String gpuType;
    private String localSSD;
    private String region;
    private String commitmentUsage;

    public Calculator(String numberOfInstances, String instanceType, String numberOfGPUs, String gpuType, String localSSD, String region, String commitmentUsage) {
        this.numberOfInstances = numberOfInstances;
        this.instanceType = instanceType;
        this.numberOfGPUs = numberOfGPUs;
        this.gpuType = gpuType;
        this.localSSD = localSSD;
        this.region = region;
        this.commitmentUsage = commitmentUsage;
    }

    public Calculator(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(getNumberOfInstances(), that.getNumberOfInstances()) &&
                Objects.equals(getInstanceType(), that.getInstanceType()) &&
                Objects.equals(getNumberOfGPUs(), that.getNumberOfGPUs()) &&
                Objects.equals(getGpuType(), that.getGpuType()) &&
                Objects.equals(getLocalSSD(), that.getLocalSSD()) &&
                Objects.equals(getRegion(), that.getRegion()) &&
                Objects.equals(getCommitmentUsage(), that.getCommitmentUsage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfInstances(), getInstanceType(), getNumberOfGPUs(), getGpuType(), getLocalSSD(), getRegion(), getCommitmentUsage());
    }

    public String getVMClass() {
        return VMClass;
    }

    public void setVMClass(String VMClass) {
        this.VMClass = VMClass;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getCommitmentUsage() {
        return commitmentUsage;
    }

    public void setCommitmentUsage(String commitmentUsage) {
        this.commitmentUsage = commitmentUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

}
