package com.solvd.persistence.dao;

import com.solvd.model.Staff;

import java.util.List;

public interface StaffDAO {

    Staff getStaffByID(int StaffID);

    List<Staff> getAllStaffs();

    void addStaff(Staff staff);

    void updateStaff(Staff staff);

    void deleteStaff(int StaffID);
}
