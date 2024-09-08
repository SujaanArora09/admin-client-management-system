package com.fitness.tracker.service;

import com.fitness.tracker.dao.CoachDAO;
import com.fitness.tracker.model.Coach;

import java.sql.SQLException;

public class CoachService {
    private CoachDAO coachDAO = new CoachDAO();

    public CoachDAO getCoachDAO() {
        return coachDAO;
    }

    public void registerCoach ( Coach coach) throws SQLException {
        coachDAO.registerCoach(coach);
    }

    public Coach loginCoach(String username, String password) throws SQLException {
        return coachDAO.loginCoach(username, password);
    }
    public void viewPrograms(int coachId) throws SQLException {
        coachDAO.viewPrograms(coachId);
    }
    public void createProgram(int coachId, String name, String description, int min_age, int max_age, double min_weight, double max_weight, double min_height, double max_height, double price, int duration) throws SQLException {
        coachDAO.createProgram(coachId, name,description, min_age, max_age, min_weight, max_weight,min_height,max_height ,price, duration);
    }
    public void viewAllRequests(int coachId) throws SQLException {
        coachDAO.viewAllRequests(coachId);
    }
    public void approveRequest(int coachId, int requestId) throws SQLException {
        coachDAO.approveRequest(coachId, requestId);
    }
}
