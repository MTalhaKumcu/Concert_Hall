package com.solvd.service;

import com.solvd.model.Roles;
import com.solvd.persistence.dao.RoleDAO;

import java.util.List;

public class RolesService {
    private final RoleDAO roleDAO;

    public RolesService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public Roles getRoleByID(int roleID) {
        return roleDAO.getRoleByID(roleID);
    }

    public List<Roles> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    public void addRole(Roles roles) {
        roleDAO.addRole(roles);
    }

    public void updateRole(Roles roles) {
        roleDAO.updateRole(roles);
    }

    public void deleteRole(int roleID) {
        roleDAO.deleteRole(roleID);
    }
}
