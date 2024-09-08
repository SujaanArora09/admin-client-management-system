package com.fitness.tracker.service;

import com.fitness.tracker.dao.ClientDAO;
import com.fitness.tracker.model.Client;

import java.sql.SQLException;

public class ClientService {
    private ClientDAO clientDAO = new ClientDAO();

    public void registerClient(Client client) throws SQLException {
        clientDAO.registerClient(client);
    }

    public Client loginClient(String username, String password) throws SQLException {
        return clientDAO.loginClient(username, password);
    }
    public void updateClientDetails(int clientId, int age, double weight, double height) throws SQLException {
        clientDAO.updateClientDetails(clientId, age, weight, height);
    }
    public void viewPrograms() throws SQLException {
        clientDAO.viewPrograms();
    }
    public void requestProgram(int clientId, int programId) throws SQLException {
        clientDAO.requestProgram(clientId, programId);
    }
    public void requestStatus(int clientId) throws SQLException {
        clientDAO.viewYourRequests(clientId);
    }
}
