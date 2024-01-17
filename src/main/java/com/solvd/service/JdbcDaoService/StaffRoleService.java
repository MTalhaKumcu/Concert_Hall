package com.solvd.service.JdbcDaoService;

import com.solvd.model.StaffRole;
import com.solvd.persistence.dao.StaffRoleDAO;

import java.util.List;

public class StaffRoleService {
    public StaffRole getStaffRoleByID(int StaffRolesID) {
        return staffRoleDAO.getStaffRoleByID(StaffRolesID);
    }

    public List<StaffRole> getAllStaffRoles() {
        return staffRoleDAO.getAllStaffRoles();
    }

    public void addStaffRole(StaffRole staffRole) {
        staffRoleDAO.addStaffRole(staffRole);
    }

    public void updateStaffRole(StaffRole staffRole) {
        staffRoleDAO.updateStaffRole(staffRole);
    }

    public void deleteStaffRole(int staffRolesID) {
        staffRoleDAO.deleteStaffRole(staffRolesID);
    }

    public StaffRoleService(StaffRoleDAO staffRoleDAO) {
        this.staffRoleDAO = staffRoleDAO;
    }

    private final StaffRoleDAO staffRoleDAO;
}
