package com.fitness.tracker.utils;

public class InputValidator {

    public static boolean isValidAge(int age) {
        return age > 0 && age <= 120;
    }

    public static boolean isValidWeight(float weight) {
        return weight > 0;
    }

    public static boolean isValidHeight(float height) {
        return height > 0;
    }

    public static boolean isValidBmi(float bmi) {
        return bmi > 0;
    }
}
