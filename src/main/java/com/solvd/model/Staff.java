package com.solvd.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


public class Staff {
    @Getter
    @Setter
    private int staffID;
    private Artist staffArtistID;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String position;

    public Staff(int staffID, String firstName, String lastName, String position) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public Artist getStaffArtistID() {
        return staffArtistID;
    }

    public void setStaffArtistID(Artist staffArtistID) {
        this.staffArtistID = staffArtistID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return staffID == staff.staffID && Objects.equals(firstName, staff.firstName) && Objects.equals(lastName, staff.lastName) && Objects.equals(position, staff.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffID, firstName, lastName, position);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffID=" + staffID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public static class StaffBuilder {
        private int builderStaffID;
        private Artist builderStaffArtistID;
        private String builderFirstName;
        private String builderLastName;
        private String builderPosition;


        public StaffBuilder(int staffID, String builderFirstName, String builderLastName, String position) {
            this.builderStaffID = staffID;
            this.builderFirstName = builderFirstName;
            this.builderLastName = builderLastName;
            this.builderPosition = position;
        }


        public StaffBuilder builderStaffID(int staffID) {
            this.builderStaffID = staffID;
            return this;
        }


        public StaffBuilder builderStaffArtistID(Artist staffArtistID) {
            this.builderStaffArtistID = staffArtistID;
            return this;
        }

        public StaffBuilder builderFirstName(String firstName) {
            this.builderFirstName = firstName;
            return this;
        }


        public StaffBuilder builderLastName(String lastName) {
            this.builderLastName = lastName;
            return this;
        }

        public StaffBuilder builderPosition(String position) {
            this.builderPosition = position;
            return this;
        }

        public static StaffBuilder builder(int staffID, String builderFirstName, String builderLastName, String position) {
            return new StaffBuilder(staffID, builderFirstName, builderLastName, position);
        }

        public Staff build() {
            Staff staff = new Staff(builderStaffID, builderFirstName, builderLastName, builderPosition);
            staff.setStaffID(builderStaffID);
            staff.setFirstName(builderFirstName);
            staff.setLastName(builderLastName);
            staff.setPosition(builderPosition);
            return staff;
        }

    }


}
