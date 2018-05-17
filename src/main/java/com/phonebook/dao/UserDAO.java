package com.phonebook.dao;

import com.phonebook.model.User;

import java.util.HashMap;

public interface UserDAO {

    boolean addUser(User user);
    boolean deleteUser(User user);
    boolean updateUser(User user);

    User getUserById(int id);
    User getUserByEmail(String email);

}
