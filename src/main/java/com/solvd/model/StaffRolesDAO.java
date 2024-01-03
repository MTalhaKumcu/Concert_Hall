package com.solvd.model;

import java.util.Objects;

public class StaffRolesDAO {
    private int staffRoleID;
    private int staffID;
    private int roleID;

    public StaffRolesDAO(int staffRoleID, int staffID, int roleID) {
        this.staffRoleID = staffRoleID;
        this.staffID = staffID;
        this.roleID = roleID;
    }

    public int getStaffRoleID() {
        return staffRoleID;
    }

    public void setStaffRoleID(int staffRoleID) {
        this.staffRoleID = staffRoleID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffRolesDAO that = (StaffRolesDAO) o;
        return staffRoleID == that.staffRoleID && staffID == that.staffID && roleID == that.roleID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffRoleID, staffID, roleID);
    }

    @Override
    public String toString() {
        return "StaffRolesDAO{" +
                "staffRoleID=" + staffRoleID +
                ", staffID=" + staffID +
                ", roleID=" + roleID +
                '}';
    }
}
