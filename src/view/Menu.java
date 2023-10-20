package view;

import input.Input;
import model.Staff;

import java.util.ArrayList;

public class Menu {
    ArrayList<Staff> albums = new ArrayList<>();
    public void showMainMenu() {
        int choice;
        do {
            System.out.println("QUẢN LÝ ALBUM" +
                    "1. Thêm ALBUM" +
                    "2. Sửa ALBUM" +
                    "3. Xoá ABLUM" +
                    "4. Hiển thị tất cả ALBUM");
            choice = Input.getInputInt();

        } while (choice != 0);
    }

    public void showAddMenu() {
        System.out.println("Thêm ALBUM");
        System.out.print("Nhập tên ALBUM: ");
        String.
    }
}
