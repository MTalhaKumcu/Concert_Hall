package com.solvd.persistence.dao;

import com.solvd.model.StaffRoles;

import java.util.List;

public interface StaffRoleDAO {
    StaffRoles getStaffRoleByID(int StaffRolesID);
    List<StaffRoles> getAllStaffRoles();
    void addStaffRole(StaffRoles staffRoles);
    void updateStaffRole(StaffRoles staffRoles);
    void deleteStaffRole(int staffRolesID);
}
