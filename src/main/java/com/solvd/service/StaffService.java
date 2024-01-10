package com.solvd.service;

import com.solvd.model.Staffs;
import com.solvd.persistence.dao.StaffDAO;

import java.util.List;


public class StaffService {

    private final StaffDAO staffDAO;

    public StaffService(StaffDAO staffDAO) {
        this.staffDAO = staffDAO;
    }

    public Staffs getStaffByID(int StaffID) {
        return staffDAO.getStaffByID(StaffID);
    }

    public List<Staffs> getAllStaffs() {
        return staffDAO.getAllStaffs();
    }

    public void addStaff(Staffs staffs) {
        staffDAO.addStaff(staffs);
    }

    public void updateStaff(Staffs staffs) {
        staffDAO.updateStaff(staffs);
    }

    public void deleteStaff(int StaffID) {
        staffDAO.deleteStaff(StaffID);
    }
}
