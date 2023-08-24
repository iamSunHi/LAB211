/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Nhật Huy
 */
public class Dictionary {
    private Map<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
        loadData();
    }

    public void loadData() {
        try {
            File file = new File("E:\\Syllabuses\\LAB211\\Java LAB\\Slot11_12\\src\\dictionary\\model\\dictionary.txt");

            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                dictionary = (HashMap<String, String>) ois.readObject();
                ois.close();
                fis.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            
        }
    }

    public void updateDatabase() {
        try {
            FileOutputStream fos = new FileOutputStream("E:\\Syllabuses\\LAB211\\Java LAB\\Slot11_12\\src\\dictionary\\model\\dictionary.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dictionary);
            oos.close();
            fos.close();
        } catch (IOException e) {
            
        }
    }

    public boolean addWord(String eng, String vi) {
        if (dictionary.containsKey(eng)) {
            System.out.println("Word already exists. Do you want to update its meaning? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            if (choice.toUpperCase().equals("Y")) {
                dictionary.put(eng, vi);
                updateDatabase();
                return true;
            } else {
                return false;
            }
        } else {
            dictionary.put(eng, vi);
            updateDatabase();
            return true;
        }
    }

    public boolean removeWord(String eng) {
        if (dictionary.containsKey(eng)) {
            dictionary.remove(eng);
            updateDatabase();
            return true;
        } else {
            System.out.println("Word does not exist in the dictionary.");
            return false;
        }
    }

    public String translate(String eng) {
        if (dictionary.containsKey(eng)) {
            return dictionary.get(eng);
        } else {
            return "";
        }
    }
}
