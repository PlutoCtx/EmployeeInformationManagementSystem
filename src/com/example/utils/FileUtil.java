package com.example.utils;

import com.example.entity.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * EmployeeInformationManagementSystem
 *
 * @author PlutoCtx ctx195467@163.com
 * @version 2024/1/4 15:48
 * @since JDK17
 */

public class FileUtil {

    private static final String DATA_FILE = "data.txt";

    public static List<Staff> readData() {
        List<Staff> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))){
            String line = reader.readLine();
            while (line != null) {
                String[] dataArray = line.split(",");

                String name = dataArray[0];
                String idCard = dataArray[1];
                String gender = dataArray[2];
                String age = dataArray[3];
                String position = dataArray[4];
                String birthday = dataArray[5];
                String depart = dataArray[6];
                String enterDate = dataArray[7];

                Staff staff = new Staff(name,
                        idCard,
                        gender,
                        age,
                        position,
                        birthday,
                        depart,
                        enterDate);
                result.add(staff);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return result;
        }
        return result;
    }



    public static void addData(Staff staff) {
        List<Staff> result = new ArrayList<>();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE, true))){
            writer.write(staff.toString());
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void deleteData(String idCard) {
        List<Staff> staff = readData();
        File file = new File(DATA_FILE);
        file.delete();

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        staff.removeIf(x -> x.getIdCard().equals(idCard));
        for (Staff s: staff) {
            addData(s);
        }
    }


    public static void updateData(Staff staff) {
        List<Staff> existData = readData();
        File file = new File(DATA_FILE);
        file.delete();

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int index = -1;
        for (Staff s: existData) {
            if (s.getIdCard().equals(staff.getIdCard())){
                index = existData.indexOf(s);
                break;
            }
        }

        if (index != -1) {
            existData.set(index, staff);
        }
        for (Staff s: existData) {
            addData(s);
        }
    }
}
