package org.salary.mysalary.repository;

import org.salary.mysalary.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final List<Employee> listEm = new ArrayList<>(List.of(
            new Employee("Катя", 90_000),
            new Employee("Дима", 102_000),
            new Employee("Олег", 80_000),
            new Employee("Вика", 135_000),
            new Employee("Женя", 165_000)));

    @Override
    public List<Employee> getScrollSalary() {
        return listEm;
    }
}
