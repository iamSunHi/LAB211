/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoryCacheManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Nhật Huy
 */
public class FuMemoryCached {
    private static ConcurrentHashMap<String, FuCached> cached = new ConcurrentHashMap<>();

    public FuMemoryCached() {
    }
    
    public boolean putObject(String key, Object object, int timeToLive) {
        if (cached.containsKey(key)) {
            return false;
        }
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND, timeToLive);
        
        cached.put(key, new FuCached(object, calendar.getTime()));
        return true;
    }
    
    public Object getObject(String key) {
        return cached.get(key);
    }
    
    public boolean clean(String key) {
        if (!cached.containsKey(key)) {
            return false;
        }
        
        cached.remove(key);
        return true;
    }
    
    public boolean cleanAll(){
        if (cached.isEmpty()) {
            return false;
        }
        
        cached.clear();
        return true;
    }
    
    public void readDataFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("E:\\Syllabuses\\LAB211\\Java LAB\\Slot3_4\\src\\memoryCacheManagement\\data.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datas = line.split(",");
                putObject(datas[0], datas, (int)(Math.random() * 3600)); // 3600 sec = 1 hour
            }
            reader.close();
        }
        catch (IOException e) {
            e.getMessage();
        }
    }

    public ConcurrentHashMap<String, FuCached> getCached() {
        return cached;
    }
}
