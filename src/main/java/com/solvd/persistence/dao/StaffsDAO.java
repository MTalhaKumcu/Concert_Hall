package com.solvd.persistence.dao;

import com.solvd.model.Staffs;

import java.util.List;

public interface StaffsDAO {

    Staffs getStaffByID(int StaffID);

    List<Staffs> getAllStaffs();

    void addStaff(Staffs staffs);

    void updateStaff(Staffs staffs);

    void deleteStaff(int StaffID);
}
