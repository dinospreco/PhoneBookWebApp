package com.phonebook.dao;

import com.phonebook.model.NumberType;
import com.phonebook.model.PhoneNumber;
import com.phonebook.model.User;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();
        PhoneNumberDAO phoneNumberDAO = new PhoneNumberDAOImpl();
        User user = new User();


//        System.out.println(userDAO.getUserById(3).toString());
//        System.out.println(phoneNumberDAO.getPhoneNumberById(1).toString());
//        update();
//        updateNumber();

        printAllNumbersByContactId(2);

//        addNumber();

    }

    public static void printAllNumbersByContactId(int contactId) {
        PhoneNumberDAO phoneNumberDAO = new PhoneNumberDAOImpl();
        ArrayList<PhoneNumber> numbers = phoneNumberDAO.getAllContactNumbers(contactId);

        for(PhoneNumber number : numbers) {
            System.out.println(number.toString());
        }

    }

    public static void updateNumber() {
        PhoneNumberDAO phoneNumberDAO = new PhoneNumberDAOImpl();
        PhoneNumber phoneNumber = new PhoneNumber(3, "+387621646386", NumberType.WORK);
        phoneNumber.setNumberId(7);
        if (phoneNumberDAO.updatePhoneNumber(phoneNumber)) {
            System.out.println("updejto broj");
        }
        else System.out.println("nije updejto broj");

    }

    public static void addNumber() {
        PhoneNumberDAO phoneNumberDAO = new PhoneNumberDAOImpl();
        PhoneNumber phoneNumber = new PhoneNumber(2, "62753440");

        if (phoneNumberDAO.addPhoneNumber(phoneNumber)) {
            System.out.println("Dodo broj");
        }
        else System.out.println("nije dodo broj");

    }

    public static void deleteNumber() {
        PhoneNumberDAO phoneNumberDAO = new PhoneNumberDAOImpl();
        PhoneNumber phoneNumber = new PhoneNumber(3, "012f56789", NumberType.WORK);
        phoneNumber.setNumberId(10);

        if (phoneNumberDAO.deletePhoneNumber(phoneNumber)) {
            System.out.println("Izbriso broj");
        }
        else System.out.println("nije Izbriso broj");

    }
}