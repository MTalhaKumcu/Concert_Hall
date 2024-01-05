package com.solvd.service;

import com.solvd.model.StaffRoles;
import com.solvd.persistence.dao.StaffRolesDAO;

import java.util.List;

public class StaffRolesService {
    public StaffRoles getStaffRoleByID(int StaffRolesID) {
        return staffRolesDAO.getStaffRoleByID(StaffRolesID);
    }

    public List<StaffRoles> getAllStaffRoles() {
        return staffRolesDAO.getAllStaffRoles();
    }

    public void addStaffRole(StaffRoles staffRoles) {
        staffRolesDAO.addStaffRole(staffRoles);
    }

    public void updateStaffRole(StaffRoles staffRoles) {
        staffRolesDAO.updateStaffRole(staffRoles);
    }

    public void deleteStaffRole(int staffRolesID) {
        staffRolesDAO.deleteStaffRole(staffRolesID);
    }

    public StaffRolesService(StaffRolesDAO staffRolesDAO) {
        this.staffRolesDAO = staffRolesDAO;
    }

    private final StaffRolesDAO staffRolesDAO;
}
