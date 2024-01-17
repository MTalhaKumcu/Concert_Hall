package com.solvd.service.MybatisService;

import com.solvd.model.Role;
import com.solvd.persistence.dao.RoleDAO;

import java.util.List;

public class RolesService {
    private final RoleDAO roleDAO;

    public RolesService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public Role getRoleByID(int roleID) {
        return roleDAO.getRoleByID(roleID);
    }

    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    public void addRole(Role role) {
        roleDAO.addRole(role);
    }

    public void updateRole(Role role) {
        roleDAO.updateRole(role);
    }

    public void deleteRole(int roleID) {
        roleDAO.deleteRole(roleID);
    }
}
