/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personInfo.view;

import java.util.Scanner;
import personInfo.controller.PersonController;

/**
 *
 * @author Nhật Huy
 */
public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How many people do you want to input? ");
        int numberOfPeople = sc.nextInt();
        PersonController personController = new PersonController();
        personController.createPeopleList(numberOfPeople);
        
        personController.inputPersonInfo();
        personController.displayPersonInfo();
    }
}
