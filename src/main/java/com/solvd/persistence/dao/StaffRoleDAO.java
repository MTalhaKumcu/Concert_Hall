package com.solvd.persistence.dao;

import com.solvd.model.StaffRole;

import java.util.List;

public interface StaffRoleDAO {
    StaffRole getStaffRoleByID(int StaffRolesID);
    List<StaffRole> getAllStaffRoles();
    void addStaffRole(StaffRole staffRole);
    void updateStaffRole(StaffRole staffRole);
    void deleteStaffRole(int staffRolesID);
}
