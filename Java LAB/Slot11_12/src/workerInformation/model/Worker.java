/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workerInformation.model;

/**
 *
 * @author Nhật Huy
 */
public class Worker {
    private String id;
    private String name;
    private int age;
    private double salary;
    private String salaryStatus;
    private String workLocation;

    public Worker(String id, String name, int age, double salary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.salaryStatus = "NULL";
        this.workLocation = workLocation;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    } 

    public String getSalaryStatus() {
        return salaryStatus;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setSalaryStatus(String salaryStatus) {
        this.salaryStatus = salaryStatus;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }
}
