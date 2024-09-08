package com.fitness.tracker.model;

public class FitnessProgram {
    private int programId;
    private int coachId;
    private String programName;
    private String description;
    private int minAge;
    private int maxAge;
    private double minWeight;
    private double maxWeight;
    private double minHeight;
    private double maxHeight;
    private double minBmi;
    private double maxBmi;
    private double price;
    private int durationInWeeks;

    public FitnessProgram(int programId, int coachId, String programName, String description, int minAge, int maxAge, double minWeight, double maxWeight, double minHeight, double maxHeight, double minBmi, double maxBmi, double price, int durationInWeeks) {
        this.programId = programId;
        this.coachId = coachId;
        this.programName = programName;
        this.description = description;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.minBmi = minBmi;
        this.maxBmi = maxBmi;
        this.price = price;
        this.durationInWeeks = durationInWeeks;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public double getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(double minWeight) {
        this.minWeight = minWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(double minHeight) {
        this.minHeight = minHeight;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public double getMinBmi() {
        return minBmi;
    }

    public void setMinBmi(double minBmi) {
        this.minBmi = minBmi;
    }

    public double getMaxBmi() {
        return maxBmi;
    }

    public void setMaxBmi(double maxBmi) {
        this.maxBmi = maxBmi;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }
}
