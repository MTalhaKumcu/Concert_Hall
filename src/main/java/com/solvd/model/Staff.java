package com.solvd.model;

import java.util.Objects;

public class Staff {
    private int staffID ;
    private Staff staffArtistID;
    private String firstName;
    private String lastName;
    private String position;

    public Staff(int staffID, Staff staffArtistID, String firstName, String lastName, String position) {
        this.staffID = staffID;
        this.staffArtistID = staffArtistID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public Staff getStaffArtistID() {
        return staffArtistID;
    }

    public void setStaffArtistID(Staff staffArtistID) {
        this.staffArtistID = staffArtistID;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return staffID == staff.staffID && Objects.equals(staffArtistID, staff.staffArtistID) && Objects.equals(firstName, staff.firstName) && Objects.equals(lastName, staff.lastName) && Objects.equals(position, staff.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffID, staffArtistID, firstName, lastName, position);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffID=" + staffID +
                ", staffArtistID=" + staffArtistID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
