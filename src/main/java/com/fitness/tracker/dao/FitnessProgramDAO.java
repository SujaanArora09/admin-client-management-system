package com.fitness.tracker.dao;

import com.fitness.tracker.config.DatabaseConfig;
import com.fitness.tracker.model.FitnessProgram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FitnessProgramDAO {
    public void createProgram(FitnessProgram program) throws SQLException {
        String sql = "INSERT INTO FitnessProgram (coach_id, program_name, description, min_age, max_age, min_weight, max_weight, min_height, max_height, min_bmi, max_bmi, price, duration_in_weeks) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, program.getCoachId());
            preparedStatement.setString(2, program.getProgramName());
            preparedStatement.setString(3, program.getDescription());
            preparedStatement.setInt(4, program.getMinAge());
            preparedStatement.setInt(5, program.getMaxAge());
            preparedStatement.setDouble(6, program.getMinWeight());
            preparedStatement.setDouble(7, program.getMaxWeight());
            preparedStatement.setDouble(8, program.getMinHeight());
            preparedStatement.setDouble(9, program.getMaxHeight());
            preparedStatement.setDouble(10, program.getMinBmi());
            preparedStatement.setDouble(11, program.getMaxBmi());
            preparedStatement.setDouble(12, program.getPrice());
            preparedStatement.setInt(13, program.getDurationInWeeks());

            preparedStatement.executeUpdate();
        }
    }
}
