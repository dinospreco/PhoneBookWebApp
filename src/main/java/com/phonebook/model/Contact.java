package com.phonebook.model;

import java.util.ArrayList;
import java.util.Objects;

public class Contact {

    private int contactId;
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String adress;
    private String city;
    private ArrayList<PhoneNumber> numbers;

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ArrayList<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<PhoneNumber> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return getContactId() == contact.getContactId() &&
                getUserId() == contact.getUserId() &&
                Objects.equals(getFirstName(), contact.getFirstName()) &&
                Objects.equals(getLastName(), contact.getLastName()) &&
                Objects.equals(getEmail(), contact.getEmail()) &&
                Objects.equals(getAdress(), contact.getAdress()) &&
                Objects.equals(getCity(), contact.getCity()) &&
                Objects.equals(getNumbers(), contact.getNumbers());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getContactId(), getUserId(), getFirstName(), getLastName(), getEmail(), getAdress(), getCity(), getNumbers());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", adress='" + adress + '\'' +
                ", city='" + city + '\'' +
                ", numbers=" + numbers +
                '}';
    }
}
