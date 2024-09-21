package org.example;

import com.fitness.tracker.model.Client;
import com.fitness.tracker.model.Coach;
import com.fitness.tracker.service.ClientService;
import com.fitness.tracker.service.CoachService;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ClientService clientService = new ClientService();
        CoachService coachService = new CoachService();

        while (true) {
            try {
                System.out.println("Welcome to the Fitness Tracker");
                System.out.println("1. Register as Client");
                System.out.println("2. Register as Coach");
                System.out.println("3. Login as Client");
                System.out.println("4. Login as Coach");
                System.out.println("5. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter username:");
                        String username = scanner.nextLine();
                        System.out.println("Enter password:");
                        String password = scanner.nextLine();
                        System.out.println("Enter age:");
                        int age = scanner.nextInt();
                        System.out.println("Enter weight:");
                        double weight = scanner.nextDouble();
                        System.out.println("Enter height:");
                        double height = scanner.nextDouble();

                        Client client = new Client(0, username, password, age, weight, height);
                        clientService.registerClient(client);
                        break;

                    case 2:
                        System.out.println("Enter username:");
                        String coachUsername = scanner.nextLine();
                        System.out.println("Enter password:");
                        String coachPassword = scanner.nextLine();
                        Coach coach = new Coach(0, coachUsername, coachPassword);
                        coachService.registerCoach(coach);
                        break;

                    case 3:
                        handleClientLogin(clientService, scanner);
                        break;

                    case 4:
                        handleCoachLogin(coachService, scanner);
                        break;

                    case 5:
                        System.out.println("Goodbye!");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please enter the correct choice.");
                scanner.nextLine();
            } catch (SQLException e) {
                System.out.println("An error occurred while accessing the database.");
            }
        }
    }

    private static void handleClientLogin(ClientService clientService, Scanner scanner) throws SQLException {
        boolean loggedIn = false;
        Client loggedInClient = null;

        while (!loggedIn) {
            System.out.println("Enter username:");
            String clientUsername = scanner.nextLine();
            System.out.println("Enter password:");
            String clientPassword = scanner.nextLine();

            try {
                loggedInClient = clientService.loginClient(clientUsername, clientPassword);
                if (loggedInClient != null) {
                    loggedIn = true;
                    showClientMenu(clientService, scanner, loggedInClient);
                } else {
                    System.out.println("Login failed. Invalid credentials.");
                    askRetry(scanner);
                }
            } catch (RuntimeException e) {
                System.out.println("Login failed. Invalid credentials.");
                askRetry(scanner);
            }
        }
    }

    private static void handleCoachLogin(CoachService coachService, Scanner scanner) throws SQLException {
        boolean loggedIn = false;
        Coach loggedInCoach = null;

        while (!loggedIn) {
            System.out.println("Enter username:");
            String coachLoginUsername = scanner.nextLine();
            System.out.println("Enter password:");
            String coachLoginPassword = scanner.nextLine();

            try {
                loggedInCoach = coachService.loginCoach(coachLoginUsername, coachLoginPassword);
                if (loggedInCoach != null) {
                    loggedIn = true;
                    showCoachMenu(coachService, scanner, loggedInCoach);
                } else {
                    System.out.println("Login failed. Invalid credentials.");
                    askRetry(scanner);
                }
            } catch (RuntimeException e) {
                System.out.println("Login failed. Invalid credentials.");
                askRetry(scanner);
            }
        }
    }

    private static void askRetry(Scanner scanner) {
        System.out.println("Would you like to try again? (yes/no):");
        String retry = scanner.nextLine();
        if (retry.equalsIgnoreCase("no")) {
            System.out.println("Returning to the main menu.");
            return;
        }
    }

    private static void showClientMenu(ClientService clientService, Scanner scanner, Client loggedInClient) throws SQLException {
        while (true) {
            try {
                System.out.println("Client Menu:");
                System.out.println("1. Update your details (age, weight, height)");
                System.out.println("2. See list of programs");
                System.out.println("3. Request for a program");
                System.out.println("4. See status of request");
                System.out.println("5. Logout");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter new age:");
                        int age = scanner.nextInt();
                        System.out.println("Enter new weight:");
                        double weight = scanner.nextDouble();
                        System.out.println("Enter new height:");
                        double height = scanner.nextDouble();
                        clientService.updateClientDetails(loggedInClient.getClientId(), age, weight, height);
                        break;

                    case 2:
                        clientService.viewPrograms();
                        break;

                    case 3:
                        clientService.viewPrograms();
                        System.out.println("Enter program ID to request:");
                        int programId = scanner.nextInt();
                        clientService.requestProgram(loggedInClient.getClientId(), programId);
                        break;

                    case 4:
                        clientService.requestStatus(loggedInClient.getClientId());
                        break;

                    case 5:
                        System.out.println("Logging out...");
                        return;

                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine();
            }
        }
    }

    private static void showCoachMenu(CoachService coachService, Scanner scanner, Coach loggedInCoach) throws SQLException {
        while (true) {
            try {
                System.out.println("Coach Menu:");
                System.out.println("1. Create a program");
                System.out.println("2. See list of programs");
                System.out.println("3. See all requests");
                System.out.println("4. Approve requests");
                System.out.println("5. Logout");

                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.println("Enter program name:");
                        String name = scanner.nextLine();
                        System.out.println("Enter program description:");
                        String description = scanner.nextLine();
                        System.out.println("Enter minimum age:");
                        int min_age = scanner.nextInt();
                        System.out.println("Enter maximum age:");
                        int max_age = scanner.nextInt();
                        System.out.println("Enter minimum weight:");
                        int min_weight = scanner.nextInt();
                        System.out.println("Enter maximum weight:");
                        int max_weight = scanner.nextInt();
                        System.out.println("Enter minimum height in (cm):");
                        double min_height = scanner.nextDouble();
                        System.out.println("Enter maximum height in (cm):");
                        double max_height = scanner.nextDouble();
                        System.out.println("Enter price:");
                        double price = scanner.nextDouble();
                        System.out.println("Enter duration in weeks:");
                        int duration = scanner.nextInt();
                        coachService.createProgram(loggedInCoach.getCoachId(), name, description, min_age, max_age, min_weight, max_weight, min_height, max_height, price, duration);
                        break;

                    case 2:
                        coachService.viewPrograms(loggedInCoach.getCoachId());
                        break;

                    case 3:
                        coachService.viewAllRequests(loggedInCoach.getCoachId());
                        break;

                    case 4:
                        System.out.println("Enter request ID to approve:");
                        int requestId = scanner.nextInt();
                        coachService.approveRequest(loggedInCoach.getCoachId(), requestId);
                        break;

                    case 5:
                        System.out.println("Logging out...");
                        return;

                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine();  // Clear invalid input
            }
        }
    }
}
