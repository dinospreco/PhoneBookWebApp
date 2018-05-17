package com.phonebook.dao;

import com.phonebook.database.ConnectionManager;
import com.phonebook.model.NumberType;
import com.phonebook.model.PhoneNumber;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhoneNumberDAOImpl implements PhoneNumberDAO {

    private Connection connection = ConnectionManager.getInstance().getConnection();
    private PreparedStatement preparedStatement;
    private String querry;

    @Override
    public boolean addPhoneNumber(PhoneNumber phoneNumber) {
        querry = "INSERT INTO phonenumbers (contactId, number, numberType) VALUES (?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1,phoneNumber.getContactId());
            preparedStatement.setString(2, phoneNumber.getNumber());

            if (phoneNumber.getNumberType() != null) {
                preparedStatement.setString(3, phoneNumber.getNumberType().name());
            }
            else {
                preparedStatement.setString(3, "MOBILE");
            }

            if(preparedStatement.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    @Override
    public boolean deletePhoneNumber(PhoneNumber phoneNumber) {
        querry = "DELETE FROM phonenumbers WHERE numberId = ?";

        try {
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1, phoneNumber.getNumberId());

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
    public boolean updatePhoneNumber(PhoneNumber phoneNumber) {
        querry = "UPDATE phonenumbers SET contactId = ?, number = ?, numberType = ? WHERE numberId = ?";

        try {
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1, phoneNumber.getContactId());
            preparedStatement.setString(2, phoneNumber.getNumber());
            preparedStatement.setString(3, phoneNumber.getNumberType().name());
            preparedStatement.setInt(4, phoneNumber.getNumberId());

            if (preparedStatement.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public PhoneNumber getPhoneNumberById(int numberId) {
        PhoneNumber phoneNumber = new PhoneNumber();
        querry = "SELECT * FROM phonenumbers WHERE numberId = ?";

        try {
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1, numberId);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                phoneNumber.setNumberId(rs.getInt("numberId"));
                phoneNumber.setContactId(rs.getInt("contactId"));
                phoneNumber.setNumber(rs.getString("number"));
                phoneNumber.setNumberType(NumberType.valueOf(rs.getString("numberType")));

                return phoneNumber;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public ArrayList<PhoneNumber> getAllContactNumbers(int contactId) {
        PhoneNumber phoneNumber = new PhoneNumber();
        querry = "SELECT * FROM phonenumbers WHERE contactId = ?";
        ArrayList<PhoneNumber> numbers = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(querry);
            preparedStatement.setInt(1, contactId);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                phoneNumber.setNumberId(rs.getInt("numberId"));
                phoneNumber.setContactId(rs.getInt("contactId"));
                phoneNumber.setNumber(rs.getString("number"));
                phoneNumber.setNumberType(NumberType.valueOf(rs.getString("numberType")));

                numbers.add(phoneNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return numbers;
    }
}
