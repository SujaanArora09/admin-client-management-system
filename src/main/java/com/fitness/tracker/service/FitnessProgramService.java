package com.fitness.tracker.service;

import com.fitness.tracker.dao.FitnessProgramDAO;
import com.fitness.tracker.model.FitnessProgram;

import java.sql.SQLException;

public class FitnessProgramService {
    private FitnessProgramDAO fitnessProgramDAO = new FitnessProgramDAO();

    public void createProgram(FitnessProgram program) throws SQLException {
        fitnessProgramDAO.createProgram(program);
    }
}
