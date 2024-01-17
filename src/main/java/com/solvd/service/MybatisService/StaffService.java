package com.solvd.service.MybatisService;

import com.solvd.model.Staff;
import com.solvd.persistence.dao.StaffDAO;

import java.util.List;


public class StaffService {

    private final StaffDAO staffDAO;

    public StaffService(StaffDAO staffDAO) {
        this.staffDAO = staffDAO;
    }

    public Staff getStaffByID(int StaffID) {
        return staffDAO.getStaffByID(StaffID);
    }

    public List<Staff> getAllStaffs() {
        return staffDAO.getAllStaffs();
    }

    public void addStaff(Staff staff) {
        staffDAO.addStaff(staff);
    }

    public void updateStaff(Staff staff) {
        staffDAO.updateStaff(staff);
    }

    public void deleteStaff(int StaffID) {
        staffDAO.deleteStaff(StaffID);
    }
}
