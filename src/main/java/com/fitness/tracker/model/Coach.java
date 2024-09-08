package com.fitness.tracker.model;

public class Coach {
    private int coachId;
    private String username;
    private String password;

    public Coach(int coachId, String username, String password) {
        this.coachId = coachId;
        this.username = username;
        this.password = password;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
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
}
