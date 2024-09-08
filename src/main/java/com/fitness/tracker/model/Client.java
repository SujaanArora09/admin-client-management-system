package com.fitness.tracker.model;

public class Client {
    private int clientId;
    private String username;
    private String password;
    private int age;
    private double weight;
    private double height;
    private double bmi;

    public Client(int clientId, String username, String password, int age, double weight, double height) {
        this.clientId = clientId;
        this.username = username;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.bmi = calculateBMI();
    }

    private double calculateBMI() {
        return this.weight / (this.height * this.height);
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
}
