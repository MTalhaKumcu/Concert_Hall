package com.solvd.model;

import java.util.Objects;

public class Staffs {
    private int staffID ;
   // private int staffArtistID;
    private String firstName;
    private String lastName;
    private String position;

    public Staffs(int staffID, String firstName, String lastName, String position) {
        this.staffID = staffID;
   //     this.staffArtistID = staffArtistID;
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

  /*  public int getStaffArtistID() {
        return staffArtistID;
    }

    public void setStaffArtistID(int artistID) {
        this.staffArtistID = artistID;
    }
*/
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
    public String toString() {
        return "StaffsDAO{" +
                "staffID=" + staffID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staffs staffs = (Staffs) o;
        return staffID == staffs.staffID && Objects.equals(firstName, staffs.firstName) && Objects.equals(lastName, staffs.lastName) && Objects.equals(position, staffs.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffID, firstName, lastName, position);
    }
}
