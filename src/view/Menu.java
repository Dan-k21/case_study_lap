package view;

import input.Input;
import manger.IManger;
import manger.StaffManger;
import model.Staff;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private StaffManger staffList = new StaffManger();
    public void showMainMenu() {
        int choice;
        do {
            System.out.println("\nQUẢN LÝ NHÂN VIÊN\n\n" +
                    "1. Thêm nhân viên\n" +
                    "2. Tìm kiếm nhân viên\n" +
                    "3. Kiểm tra trạng thái nhân viên\n" +
                    "4. Sửa thông tin nhân viên\n" +
                    "5. Thay đổi trạng thái nhân viên\n" +
                    "6. Xoá nhân viên\n" +
                    "7. Thông tin tài khoản\n" +
                    "8. Đăng xuất\n" +
                    "9. Hiển thị tất cả các nhân viên\n");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.getInputInt();
            switch (choice) {
                case 1:
                    showAddMenu();
                    break;
                case 2:
                    showSearchMenuByName();
                    break;
                case 4:
                    showEditMenu();
                    break;
                case 6:
                    showDelMenu();
                    break;
                case 8:
                    showListStaff();
                    break;
            }
        } while (choice != 7);
    }

    public void showSearchStatusMenu() {
        System.out.println("Kiểm tra trạng thái nhân viên");

    }

    public void showDelMenu() {
        System.out.println("Xoá nhân viên theo ID");
        System.out.print("Nhập ID nhân viên bạn muốn xoá: ");
        int id = Input.getInputInt();
        this.staffList.delete(id);
    }

    public void showAddMenu() {
        System.out.println("Thêm nhân viên");
        System.out.print("Nhập tên nhân viên: ");
        String name = Input.getInputString();
        System.out.print("Nhập tuổi nhân viên: ");
        int age = Input.getInputInt();
        System.out.print("Nhập trạng thái nhân viên: ");
        String status = Input.getInputBoolean();
        System.out.println("Nhập loại nhân viên: ");
        String type = Input.getInputType();
        Staff staff = new Staff(name, age, status, type);
        this.staffList.add(staff);
    }

    public void showEditMenu() {
        System.out.println("Sửa thông tin nhân viên");
        System.out.print("Nhập ID mà bạn muốn sửa: ");
        int id = Input.getInputInt();
        System.out.print("Tên: ");
        String name = Input.getInputString();
        System.out.print("Tuổi: ");
        int age = Input.getInputInt();
        System.out.print("Trạng thái: ");
        String status = Input.getInputBoolean();
        Staff staff = new Staff(name, age, status);
        this.staffList.edit(id, staff);
    }

    public void showListStaff() {
        System.out.println("\nDanh sách nhân viên");
        ArrayList<Staff> list = staffList.showAll();
        for (Staff staffs : list) {
            System.out.println(staffs);
        }
    }

    public void showSearchMenuByName() {
        System.out.println("\nTìm kiếm nhân viên theo tên");
        System.out.print("Nhập tên nhân viên muốn tìm: ");
        String name = Input.getInputString();
        if (staffList.checkName(name) == false) {
            System.out.println("Không có");
        } else {
            System.out.println("\nDanh sách nhân viên cần tìm");
            for (Staff staff : staffList.findStaffByName(name)) {
                System.out.println(staff);
            }
        }
    }
}
