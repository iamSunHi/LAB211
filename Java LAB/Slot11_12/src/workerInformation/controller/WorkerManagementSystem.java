/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workerInformation.controller;

import java.util.ArrayList;
import java.util.List;
import workerInformation.model.Worker;

/**
 *
 * @author Nhật Huy
 */
public class WorkerManagementSystem {

    private List<Worker> workers;

    public WorkerManagementSystem() {
        workers = new ArrayList<>();
        this.addWorker("W1", "John Doe", 25, 2000, "Location 1");
        this.addWorker("W2", "Jane Smith", 30, 2500, "Location 2");
        this.addWorker("W3", "Michael Johnson", 35, 1800, "Location 1");
        this.addWorker("W4", "Emily Brown", 40, 3000, "Location 3");
        this.addWorker("W5", "David Wilson", 45, 2200, "Location 2");

    }

    public final void addWorker(String id, String name, int age, double salary, String workLocation) {
        Worker worker = new Worker(id, name, age, salary, workLocation);
        workers.add(worker);
    }

    public boolean isWorkerIdExists(String id) {
        for (Worker worker : workers) {
            if (worker.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public int findWorkerById(String id) {
        for (int i = 0; i < this.workers.size(); i++) {
            if (this.workers.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void updateSalary(int i, double salary) {
        if (salary >= this.workers.get(i).getSalary()) {
            this.workers.get(i).setSalaryStatus("UP");
        } else {
            this.workers.get(i).setSalaryStatus("UP");
        }
        this.workers.get(i).setSalary(salary);
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}
