package com.epam.ta.model;

import java.util.Objects;

public class Calculator {
    private String VMClass;
    private String instanceType;
    private String region;
    private String localSSD;
    private String commitmentUsage;
    private String cost;
    private String gpuType;
    private String numberOfGPUs;
    private String numberOfInstances;

    public Calculator(String VMClass, String instanceType, String region, String localSSD, String commitmentUsage, String cost, String gpuType, String numberOfInstances, String numberOfGPUs) {
        this.VMClass = VMClass;
        this.instanceType = instanceType;
        this.region = region;
        this.localSSD = localSSD;
        this.commitmentUsage = commitmentUsage;
        this.cost = cost;
        this.gpuType = gpuType;
        this.numberOfInstances = numberOfInstances;
        this.numberOfGPUs = numberOfGPUs;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(getVMClass(), that.getVMClass()) &&
                Objects.equals(getInstanceType(), that.getInstanceType()) &&
                Objects.equals(getRegion(), that.getRegion()) &&
                Objects.equals(getLocalSSD(), that.getLocalSSD()) &&
                Objects.equals(getCommitmentUsage(), that.getCommitmentUsage()) &&
                Objects.equals(getCost(), that.getCost()) &&
                Objects.equals(getGpuType(), that.getGpuType()) &&
                Objects.equals(getNumberOfGPUs(), that.getNumberOfGPUs()) &&
                Objects.equals(getNumberOfInstances(), that.getNumberOfInstances());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVMClass(), getInstanceType(), getRegion(), getLocalSSD(), getCommitmentUsage(), getCost(), getGpuType(), getNumberOfGPUs(), getNumberOfInstances());
    }

    public Calculator() {
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
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
