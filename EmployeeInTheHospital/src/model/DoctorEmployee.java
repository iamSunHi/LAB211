package model;

public class DoctorEmployee extends Employee {
    private int level;
    private String major;
    private int positionAllowance;

    public DoctorEmployee(String id, String name, String address, float coefficientsSalary) {
        super(id, name, address, coefficientsSalary);
    }

    public DoctorEmployee(String id, String name, String address, float coefficientsSalary, int level, String major, int positionAllowance) {
        super(id, name, address, coefficientsSalary);
        this.level = level;
        this.major = major;
        this.positionAllowance = positionAllowance;
    }

    @Override
    public float calculateSalary() {
        return ((level + coefficientsSalary) * 1650000) + positionAllowance;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: Doctor";
    }
}
