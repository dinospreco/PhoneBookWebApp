package com.phonebook.dao;

import com.phonebook.model.Contact;

import java.util.ArrayList;

public interface ContactDAO {

    boolean addContact();
    boolean deleteContact();
    boolean updateContact();

    Contact getContactById();
    ArrayList<Contact> getAllUsersContacts();



}
