package dao;

import model.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteAlbum {
    File file = new File("album.csv");
    public void writeFile(List<Staff> albumList) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = "";
            for (Staff album :
                    albumList) {
                data += album.getId() + ", " +
                        album.getSong();
            }
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Staff> readFile() {
        ArrayList<Staff> albums = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(", ");
                Staff album = new Staff(Integer.parseInt(data[0]), data[1]);
                bufferedReader.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return albums;
    }
}
