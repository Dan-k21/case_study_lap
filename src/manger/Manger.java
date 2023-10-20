package manger;

import java.util.ArrayList;

public interface Manger<S> {
    boolean add(S staff);
    boolean edit(int id, S newStaff);
    boolean delete(int id);
    ArrayList<S> showAll();
}
