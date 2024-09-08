package com.fitness.tracker.utils;

public class Utils {

    public static float calculateBMI(float weight, float height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        return weight / (height * height);
    }

    public static String generateUniqueId(String prefix, int length) {
        StringBuilder id = new StringBuilder(prefix);
        while (id.length() < length) {
            id.append((int) (Math.random() * 10));
        }
        return id.toString();
    }
}