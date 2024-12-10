package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.java.utility.JdbcUtilityConnection;

public class Withdraw {

    public static void withdrawAmount() throws ClassNotFoundException, SQLException {
        // Initialize resources
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtilityConnection.getConnection();
            Scanner sc = new Scanner(System.in);

            // Input user details
            System.out.print("Enter Your Name: ");
            String name = sc.next();

            System.out.print("Enter Your ID: ");
            int accountId = sc.nextInt();

            // Validate user by ID and name
            String query = "SELECT userId, balance FROM users1 WHERE name = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, name);

            resultSet = statement.executeQuery();

            boolean validUser = false;
            double balance = 0.0;

            while (resultSet.next()) {
                int dbId = resultSet.getInt("userId");
                balance = resultSet.getDouble("balance");
                if (dbId == accountId) {
                    validUser = true;
                    break;
                }
            }

            if (validUser) {
                System.out.print("Enter Withdrawal Amount: ");
                double withdrawAmount = sc.nextDouble();

                if (balance >= withdrawAmount) {
                    double newBalance = balance - withdrawAmount;

                    // Update balance in the database
                    String updateQuery = "UPDATE users1 SET balance = ? WHERE userId = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                    updateStatement.setDouble(1, newBalance);
                    updateStatement.setInt(2, accountId);

                    int rowsUpdated = updateStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Withdrawal successful!");
                        System.out.println("New Balance: " + newBalance);
                    }
                } else {
                    System.out.println("Insufficient balance.");
                }
            } else {
                System.out.println("Invalid user details.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } finally {
            // Close resources
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }
}
