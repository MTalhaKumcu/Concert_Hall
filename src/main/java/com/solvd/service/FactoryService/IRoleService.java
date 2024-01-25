package com.solvd.service.FactoryService;

import com.solvd.model.Role;

public interface IRoleService {
    Role createRole(Role role);

    Role getRoleByID(int roleID);
}
