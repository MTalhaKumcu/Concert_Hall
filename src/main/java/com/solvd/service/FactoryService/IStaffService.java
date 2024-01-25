package com.solvd.service.FactoryService;

import com.solvd.model.Staff;

public interface IStaffService {
    Staff createStaff(Staff staff);

    Staff getStaffByID(int staffID);
}
