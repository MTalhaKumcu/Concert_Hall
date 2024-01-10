package com.solvd.service;

import com.solvd.model.StaffRoles;
import com.solvd.persistence.dao.StaffRoleDAO;

import java.util.List;

public class StaffRoleService {
    public StaffRoles getStaffRoleByID(int StaffRolesID) {
        return staffRoleDAO.getStaffRoleByID(StaffRolesID);
    }

    public List<StaffRoles> getAllStaffRoles() {
        return staffRoleDAO.getAllStaffRoles();
    }

    public void addStaffRole(StaffRoles staffRoles) {
        staffRoleDAO.addStaffRole(staffRoles);
    }

    public void updateStaffRole(StaffRoles staffRoles) {
        staffRoleDAO.updateStaffRole(staffRoles);
    }

    public void deleteStaffRole(int staffRolesID) {
        staffRoleDAO.deleteStaffRole(staffRolesID);
    }

    public StaffRoleService(StaffRoleDAO staffRoleDAO) {
        this.staffRoleDAO = staffRoleDAO;
    }

    private final StaffRoleDAO staffRoleDAO;
}
