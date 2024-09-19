package com.app.services;

import com.app.models.employers.Employee;

import java.util.ArrayList;

public abstract class AbstractTaskService {
    protected ArrayList<Employee> employees;

    public AbstractTaskService() {
    }

    public void setData(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public abstract void completeTasks();
}
