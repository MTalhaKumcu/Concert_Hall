package com.solvd.persistence.dao;

import com.solvd.model.Role;

import java.util.List;

public interface RoleDAO {
    Role getRoleByID(int roleID);

    List<Role> getAllRoles();

    void addRole(Role role);

    void updateRole(Role role);

    void deleteRole(int roleID);
}
