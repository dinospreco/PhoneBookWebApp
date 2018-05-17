package com.phonebook.dao;

import com.phonebook.database.ConnectionManager;
import com.phonebook.model.User;

import java.sql.*;

public class UserDAOImpl implements UserDAO {

    private Connection connection = ConnectionManager.getInstance().getConnection();
    private PreparedStatement preparedStatement;
    private String querry;

    @Override
    public boolean addUser(User user) {
        querry = "INSERT INTO USER(firstName, lastName, email, passhash) VALUES(?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());

            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        querry = "DELETE FROM USER WHERE userId = ?";
        try {
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1, user.getId());

            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        querry = "UPDATE USER SET firstName = ?, lastName = ?, email = ?, passhash = ? WHERE userId = ?";

        try {
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getId());

            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    @Override
    public User getUserById(int id) {

        querry = "SELECT * FROM USER WHERE userId = ?";

        try {
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1,id);

            return executePreparedStatement(preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        querry = "SELECT * FROM USER WHERE email = ?";

        try {
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setString(1,email);

            return executePreparedStatement(preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private User executePreparedStatement(PreparedStatement prepStatement) throws SQLException{

        User user = new User();

        ResultSet resultSet = prepStatement.executeQuery();

        if (resultSet.next()) {
            user.setId(resultSet.getInt("userId"));
            user.setFirstName(resultSet.getString("firstName"));
            user.setLastName(resultSet.getString("lastName"));
            user.setEmail(resultSet.getString("email"));
            return user;
        }
        return null;
    }

}
