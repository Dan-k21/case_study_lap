package model;

import dao.ReadAndWriteStaff;

import java.util.ArrayList;

public class Staff {
    private int id;
    private String name;
    private int age;
    private String status;
    private String type;

    public Staff() {}
    private ReadAndWriteStaff readAndWriteStaff = new ReadAndWriteStaff();

    public Staff(String name, int age, String status, String type) {
        ArrayList<Staff> productList = readAndWriteStaff.readFile();
        if(productList.isEmpty()) {
            this.id = 0;
        } else {
            this.id = productList.get(productList.size() - 1).getId() + 1;
        }
        this.name = name;
        this.age = age;
        this.status = status;
        this.type = type;
    }

    public Staff(int id, String name, int age, String status, String type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.status = status;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + getId() +
                " Tên: " + getName() +
                ", Tuổi: " + getAge() +
                ", Trạng thái: " + ((isStatus().equalsIgnoreCase("True"))?"Đang làm việc":"Nghỉ việc");
    }
}
