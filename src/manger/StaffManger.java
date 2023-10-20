package manger;

import dao.ReadAndWriteAlbum;
import model.Staff;

import java.util.ArrayList;

public class StaffManger implements Manger<Staff>{
    ArrayList<Staff> staffList;
    ReadAndWriteAlbum readAndWriteAlbum = new ReadAndWriteAlbum();
    @Override
    public boolean add(Staff staff) {
        this.staffList.add(staff);
        readAndWriteAlbum.writeFile(this.staffList);
        return true;
    }

    @Override
    public boolean edit(int id, Staff newStaff) {
        int index = findById(id);
        if (index == -1) {
            return false;
        }
        this.staffList.set(index, newStaff);
        readAndWriteAlbum.writeFile(staffList);
        return true;
    }

    @Override
    public boolean delete(int id) {
        int index = findById(id);
        this.staffList.remove(index);
        readAndWriteAlbum.writeFile(staffList);
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
}
