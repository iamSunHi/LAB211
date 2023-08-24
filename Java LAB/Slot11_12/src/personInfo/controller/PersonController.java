/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personInfo.controller;

import java.util.Arrays;
import java.util.Scanner;
import personInfo.model.Person;

/**
 *
 * @author Nhật Huy
 */
public class PersonController {

    private Person[] people;

    public PersonController() {
    }
    
    public void createPeopleList(int numberOfPeople) {
        this.people = new Person[numberOfPeople];
    }

    public void inputPersonInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n=====Management Person program=====");
        for (int i = 0; i < this.people.length; i++) {
        System.out.println("\nInput Information of Person");
            System.out.print("Please input name: ");
            String name = scanner.nextLine();

            System.out.print("Please input address: ");
            String address = scanner.nextLine();

            double salary = 0;

            while (true) {
                try {
                    System.out.print("Please input salary: ");
                    String sSalary = scanner.nextLine();
                    salary = Double.parseDouble(sSalary);

                    if (salary < 0) {
                        throw new Exception("Salary is greater than zero.");
                    }

                    break;
                } catch (NumberFormatException e) {
                    System.out.println("You must input a number.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            this.people[i] = new Person(name, address, salary);
        }
    }

    public void displayPersonInfo() {
        this.sortBySalary();
        System.out.println("\nInformation of Person you have entered:");
        for (Person person : this.people) {
            System.out.println("Name: " + person.getName());
            System.out.println("Address: " + person.getAddress());
            System.out.println("Salary: " + person.getSalary() + "\n");
        }
    }

    public void sortBySalary() {
        Arrays.sort(this.people, (p1, p2) -> Double.compare(p1.getSalary(), p2.getSalary()));
    }

    public Person[] getPeople() {
        return this.people;
    }

    public void setPeople(Person[] people) {
        this.people = people;
    }
}
