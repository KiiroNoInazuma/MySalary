package org.salary.mysalary.repository;

import org.salary.mysalary.models.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getScrollSalary();
}
