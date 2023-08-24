package model;

public class Employee {

    protected String id;
    protected String name;
    protected String address;
    protected float coefficientsSalary;

    public Employee(String id, String name, String address, float coefficientsSalary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.coefficientsSalary = coefficientsSalary;
    }

    public float calculateSalary() {
        return coefficientsSalary * 1650000;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Address: " + address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(float coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }
}
