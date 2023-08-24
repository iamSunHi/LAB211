/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryCacheManagement;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nhật Huy
 */
public class App extends Menu {

    static FuMemoryCached managerCached = new FuMemoryCached();

    public static String[] optionsList = {"Put object", "Get object", "Remove one object", "Clean all"};

    public App(String title, String[] optionsList) {
        super(title, optionsList);
    }

//    public static void main(String[] args) {
//        Thread mainThread = new Thread(() -> {
//            managerCached.readDataFromFile();
//            App m = new App("M E N U", optionsList);
//            m.run();
//            System.out.println("\nEnd Program !");
//        });
//        Thread controlThread = new Thread(() -> {
//            do {
//                try {
//                    Thread.sleep(1000);
//                    Set<String> keySet = managerCached.getCached().keySet();
//                    for (String key : keySet) {
//                        if (managerCached.getCached().get(key).getExpiredDate().before(Date.from(Instant.now()))) {
//                            managerCached.getCached().remove(key);
//                            System.out.println("\nThe object with key \"" + key + "\" has been removed because of the excess time of existence!");
//                        }
//                    }
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } while (mainThread.isAlive());
//        });
//
//        mainThread.start();
//        controlThread.start();
//    }

    @Override
    public void execute(int choice) {
        Scanner sc = new Scanner(System.in);
        String key = "";
        switch (choice) {
            case 1:
                String data;
                ArrayList<String> datas = new ArrayList<>();
                int timeTolive;
                int i = 1;

                do {
                    System.out.println("\nEnter the information for the object (Leave blank if you don't want to enter more):");
                    System.out.println("Note: the first information will be used as a key for later retrieval!");
                    do {
                        data = "";
                        System.out.print("\t - " + i++ + " information: ");
                        data = sc.nextLine();
                        if (i == 2) {
                            key = data;
                        } else {
                            datas.add(data);
                        }
                    } while (!data.isEmpty());

                    System.out.print("Expiration time (second): ");
                    timeTolive = sc.nextInt();
                    sc.nextLine();

                    if (!managerCached.putObject(key, datas.toArray(), timeTolive)) {
                        System.out.println("\nThe key already exists, please re-enter!");
                        datas.clear();
                        i = 1;
                        continue;
                    }
                    break;
                } while (true);
                System.out.println("\nPut the object with key \"" + key + "\" successfully!");
                break;
            case 2:
                do {
                    System.out.print("\nEnter the key of the object you want to get: ");
                    key = sc.nextLine();
                    if (managerCached.getCached().containsKey(key)) {
                        System.out.println(managerCached.getObject(key).toString());
                        break;
                    } else {
                        System.out.println("\nThis key does not exist or has expired, please re-enter!");
                    }
                } while (true);
                break;
            case 3:
                do {
                    System.out.print("\nEnter the key of the object you want to remove: ");
                    key = sc.nextLine();
                    if (managerCached.clean(key)) {
                        System.out.println("\nThe object with key \"" + key + "\" has been removed!");
                        break;
                    } else {
                        System.out.println("\nThis key does not exist or has expired, please re-enter!");
                    }
                } while (true);
                break;
            case 4:
                if (managerCached.cleanAll()) {
                    System.out.println("\nClean cache successfully!");
                }
                else {
                    System.out.println("\nThe cache is empty!");
                }
                break;
        }
    }
}
