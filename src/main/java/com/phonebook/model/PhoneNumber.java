package com.phonebook.model;

import java.util.Objects;

public class PhoneNumber {

    private int numberId;
    private int contactId;
    private String number;
    private NumberType numberType;

    public PhoneNumber() {
    }

    public PhoneNumber(int contactId, String number) {
        this.contactId = contactId;
        this.number = number;
    }

    public PhoneNumber(int contactId, String number, NumberType numberType) {
        this.contactId = contactId;
        this.number = number;
        this.numberType = numberType;
    }

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public NumberType getNumberType() {
        return numberType;
    }

    public void setNumberType(NumberType numberType) {
        this.numberType = numberType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber that = (PhoneNumber) o;
        return getNumberId() == that.getNumberId() &&
                getContactId() == that.getContactId() &&
                Objects.equals(getNumber(), that.getNumber()) &&
                getNumberType() == that.getNumberType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNumberId(), getContactId(), getNumber(), getNumberType());
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "numberId=" + numberId +
                ", contactId=" + contactId +
                ", number='" + number + '\'' +
                ", numberType=" + numberType +
                '}';
    }
}
