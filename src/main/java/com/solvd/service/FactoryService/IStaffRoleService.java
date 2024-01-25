package com.solvd.service.FactoryService;

import com.solvd.model.StaffRole;

public interface IStaffRoleService {
    StaffRole createStaffRole(StaffRole staffRole);

    StaffRole getStaffRoleByID(int staffRoleID);
}
