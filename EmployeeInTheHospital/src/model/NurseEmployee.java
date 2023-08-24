package model;

public class NurseEmployee extends Employee {
    private String department;
    private int overtimeHours;
    
    public NurseEmployee(String id, String name, String address, float coefficientsSalary) {
        super(id, name, address, coefficientsSalary);
    }
    
    public NurseEmployee(String id, String name, String address, float coefficientsSalary, String department, int overtimeHours) {
        super(id, name, address, coefficientsSalary);
        this.department = department;
        this.overtimeHours = overtimeHours;
    }

    @Override
    public float calculateSalary() {
        return (coefficientsSalary * 1650000) + (overtimeHours * 20000);
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: Nurse";
    }
}
