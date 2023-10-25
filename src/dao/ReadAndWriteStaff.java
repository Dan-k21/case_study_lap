package dao;

import model.Staff;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWriteStaff {
    File file = new File("staff.csv");

    public void writeFile(ArrayList<Staff> staffList) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = "";
            for (Staff staff :
                    staffList) {
                data += staff.getId() + ", " +
                        staff.getName() + ", " +
                        staff.getAge() + ", " +
                        staff.isStatus();
            }
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Staff> readFile() {
        ArrayList<Staff> staffArrayList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");
                Staff staff = new Staff(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), (data[3]));
                staffArrayList.add(staff);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return staffArrayList;
    }
}


