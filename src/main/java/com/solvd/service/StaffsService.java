package com.solvd.service;

import com.solvd.model.Staffs;
import com.solvd.persistence.dao.StaffsDAO;

import java.util.List;


public class StaffsService {

    private final StaffsDAO staffDAO;

    public StaffsService(StaffsDAO staffDAO) {
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
