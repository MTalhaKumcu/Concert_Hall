package com.solvd.persistence.dao;

import com.solvd.model.Roles;

import java.util.List;

public interface RoleDAO {
    Roles getRoleByID(int roleID);

    List<Roles> getAllRoles();

    void addRole(Roles roles);

    void updateRole(Roles roles);

    void deleteRole(int roleID);
}
