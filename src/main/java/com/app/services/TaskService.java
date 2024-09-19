package com.app.services;

import com.app.models.employers.Company;
import com.app.models.employers.Employee;
import com.app.models.employers.Individual;

public class TaskService extends AbstractTaskService {

    @Override
    public void completeTasks() {
        this.getIndividualClientsCount();
        this.getCompanyClientsCount();
        this.getClientsUnderTwenty();
    }

    private void getIndividualClientsCount() {
        int count = 0;
        for(Employee employee : this.employees) {
            if (employee instanceof Individual) {
                count++;
            }
        }

        System.out.printf("Total number of individual clients: %d%n", count);
    }

    private void getCompanyClientsCount() {
        int count = 0;
        for(Employee employee : this.employees) {
            if (employee instanceof Company) {
                count++;
            }
        }

        System.out.printf("Total number of company clients: %d%n", count);
    }

    private void getClientsUnderTwenty() {
        System.out.printf("Total clients under 20:\n");
        for(Employee employee : this.employees) {
            if (employee instanceof Individual && ((Individual) employee).getAge() < 20) {
                System.out.printf("%s %s%n", ((Individual) employee).getName(), ((Individual) employee).getSecondName());
            }
        }
    }
}
