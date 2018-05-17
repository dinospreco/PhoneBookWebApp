package com.phonebook.dao;

import com.phonebook.model.PhoneNumber;

import java.util.ArrayList;

public interface PhoneNumberDAO {

    boolean addPhoneNumber(PhoneNumber phoneNumber);
    boolean deletePhoneNumber(PhoneNumber phoneNumber);
    boolean updatePhoneNumber(PhoneNumber phoneNumber);

    PhoneNumber getPhoneNumberById(int numberId);
    ArrayList<PhoneNumber> getAllContactNumbers(int contactId);

}
