/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary.controller;

import dictionary.model.Dictionary;

/**
 *
 * @author Nhật Huy
 */
public class Controller {
    private Dictionary model = new Dictionary();

    public Controller() {
    }
    
    public void addWord(String eng, String vi) {
        if (model.addWord(eng, vi)) {
            System.out.println("Word added successfully.");
        } else {
            System.out.println("Word not added.");
        }
    }
    
    public void deleteWord(String eng) {
        if (model.removeWord(eng)) {
            System.out.println("Word deleted successfully.");
        }
    }
    
    public String translateWord(String eng) {
        String vi = model.translate(eng);
        return vi;
    }
}
