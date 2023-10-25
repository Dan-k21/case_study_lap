package manger;

import dao.ReadAndWriteStaff;
import model.Staff;

import java.util.ArrayList;

public class StaffManger implements IManger<Staff> {
    ArrayList<Staff> staffList;
    ReadAndWriteStaff readAndWriteStaff = new ReadAndWriteStaff();
    public StaffManger() {
        this.staffList = readAndWriteStaff.readFile();
    }
    @Override
    public boolean add(Staff staff) {
        this.staffList.add(staff);
        readAndWriteStaff.writeFile(this.staffList);
        return true;
    }

    @Override
    public boolean edit(int id, Staff newStaff) {
        int index = findById(id);
        if (index == -1) {
            return false;
        }
        this.staffList.set(index, newStaff);
        readAndWriteStaff.writeFile(this.staffList);
        return true;
    }

    @Override
    public boolean delete(int id) {
        int index = findById(id);
        this.staffList.remove(index);
        readAndWriteStaff.writeFile(this.staffList);
        return true;
    }

    @Override
    public ArrayList<Staff> showAll() {
        return this.staffList;
    }

    public int findById(int id) {
        for (int i = 0; i < staffList.size(); i++) {
            if (id == this.staffList.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Staff> findStaffByName(String name) {
        ArrayList<Staff> staff = new ArrayList<>();
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                staff.add(staffList.get(i));
            }
        }
        return staff;
    }

    public boolean checkName(String name) {
        boolean checkName = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                return checkName = true;
            }
        }
        return checkName;
    }
}
