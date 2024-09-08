package com.fitness.tracker.dao;

import com.fitness.tracker.config.DatabaseConfig;
import com.fitness.tracker.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {
    public void registerClient(Client client) throws SQLException {
        String sql = "INSERT INTO Client (username, password, age, weight, height) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, client.getUsername());
            preparedStatement.setString(2, client.getPassword());
            preparedStatement.setInt(3, client.getAge());
            preparedStatement.setDouble(4, client.getWeight());
            preparedStatement.setDouble(5, client.getHeight());

            preparedStatement.executeUpdate();
        }
    }

    public Client loginClient(String username, String password) throws SQLException {
        String sql = "SELECT * FROM Client WHERE username = ? AND password = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Client(
                        resultSet.getInt("client_id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getInt("age"),
                        resultSet.getDouble("weight"),
                        resultSet.getDouble("height")
                );
            } else {
                throw new RuntimeException("Invalid credentials");
            }
        }
    }
    public void updateClientDetails(int clientId, int age, double weight, double height) throws SQLException {
        String sql = "UPDATE Client SET age = ?, weight = ?, height = ? WHERE client_id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, age);
            preparedStatement.setDouble(2, weight);
            preparedStatement.setDouble(3, height);
            preparedStatement.setInt(4, clientId);

            preparedStatement.executeUpdate();
        }
    }
    public void viewPrograms() throws SQLException {
        String sql = "SELECT * FROM fitnessprogram";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("Program ID: " + resultSet.getInt("program_id"));
                System.out.println("Program Name: " + resultSet.getString("program_name"));
                System.out.println("Age: " + resultSet.getInt("min_age") + (" - ") + resultSet.getInt("max_age"));
                System.out.println("Weight: " + resultSet.getDouble("min_weight") +(" - ") + resultSet.getDouble("max_weight"));
                System.out.println("Height: " + resultSet.getDouble("min_height") + (" - ")+ resultSet.getDouble("max_height"));
                System.out.println("BMI: " + resultSet.getDouble("min_bmi") + (" - ")+ resultSet.getDouble("max_bmi"));
                System.out.println("Price: " + resultSet.getDouble("price"));
                System.out.println("Duration: " + resultSet.getInt("duration_in_weeks") + " weeks");
                System.out.println("------------------------");
            }
        }
    }
    public void requestProgram(int clientId, int programId) throws SQLException {
        String sql = "INSERT INTO programapplication (client_id, program_id, status) VALUES (?, ?, 'Pending')";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, clientId);
            preparedStatement.setInt(2, programId);

            preparedStatement.executeUpdate();
        }
    }
    public void viewYourRequests(int clientId) throws SQLException {
        String sql = "SELECT * FROM programapplication WHERE client_id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, clientId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Request ID: " + resultSet.getInt("application_id"));
                System.out.println("Client ID: " + resultSet.getInt("client_id"));
                System.out.println("Program ID: " + resultSet.getInt("program_id"));
                System.out.println("Status: " + resultSet.getString("status"));
                System.out.println("------------------------");
            }
        }
    }
}
