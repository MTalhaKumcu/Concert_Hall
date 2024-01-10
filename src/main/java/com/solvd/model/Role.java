package com.solvd.model;

import java.util.Objects;

public class Role {

    private int roleID;
    private String roleName;
    private String description;

    public Role(int roleID, String roleName, String description) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.description = description;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleID == role.roleID && Objects.equals(roleName, role.roleName) && Objects.equals(description, role.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleID, roleName, description);
    }

    @Override
    public String toString() {
        return "RolesDAO{" +
                "roleID=" + roleID +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
