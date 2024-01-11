package com.solvd.model;

import java.util.Objects;

public class StaffRole {
    private int staffRoleID;
    private Staff staffID;
    private Role roleID;

    public StaffRole(int staffRoleID, Staff staffID, Role roleID) {
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

    public Staff getStaffID() {
        return staffID;
    }

    public void setStaffID(Staff staffID) {
        this.staffID = staffID;
    }

    public Role getRoleID() {
        return roleID;
    }

    public void setRoleID(Role roleID) {
        this.roleID = roleID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffRole staffRole = (StaffRole) o;
        return staffRoleID == staffRole.staffRoleID && Objects.equals(staffID, staffRole.staffID) && Objects.equals(roleID, staffRole.roleID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffRoleID, staffID, roleID);
    }

    @Override
    public String toString() {
        return "StaffRole{" +
                "staffRoleID=" + staffRoleID +
                ", staffID=" + staffID +
                ", roleID=" + roleID +
                '}';
    }
}
