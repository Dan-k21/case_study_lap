package manger;

import model.Staff;

import java.util.ArrayList;

public interface IManger<S> {
    boolean add(S staff);
    boolean edit(int id, S newStaff);
    boolean delete(int id);
    ArrayList<Staff> showAll();
}
