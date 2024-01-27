package com.solvd.model;

import java.util.Objects;

public class Staff {
    private int staffID;
    private Artist staffArtistID;
    private String firstName;
    private String lastName;
    private String position;

    public Staff(int staffID, String firstName, String lastName, String position) {
        this.staffID = staffID;
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

    public Artist getStaffArtistID() {
        return staffArtistID;
    }

    public void setStaffArtistID(Artist staffArtistID) {
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


        public Staff build() {
            Staff staff = new Staff(builderStaffID, builderFirstName, builderLastName, builderPosition);
            staff.setStaffArtistID(builderStaffArtistID);
            return staff;
        }

    }

    Staff staff = new StaffBuilder(20, "Sergey", "Builder", "Test Manager")
            .builderStaffID(20)
            .builderFirstName("Sergey")
            .builderLastName("Builder")
            .builderPosition("Test Manager")
            .build();

}
