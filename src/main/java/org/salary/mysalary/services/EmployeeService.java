package org.salary.mysalary.services;

import jakarta.annotation.Resource;
import org.salary.mysalary.models.Employee;
import org.salary.mysalary.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EmployeeService {
    @Resource
    EmployeeRepository employeeRepository;

    public List<Employee> getScrollSalaryAndName() {
        return employeeRepository.getScrollSalary();
    }

    private IntStream iteratorSalary() {
        return getScrollSalaryAndName().stream().mapToInt(Employee::salary);
    }

    public int sumSalary() {
        return iteratorSalary().sum();
    }

    public String maxSalary() {
        return getScrollSalaryAndName().
                stream().
                filter(employee -> employee.salary() == iteratorSalary().
                        max().
                        orElse(0)).
                map(Employee::name).findFirst().orElse(null);
    }

    public String minSalary() {
        return getScrollSalaryAndName().
                stream().
                filter(employee -> employee.salary() == iteratorSalary().
                        min().
                        orElse(0)).
                map(Employee::name).
                findFirst().orElse(null);

    }

    public String averageSalary() {
        return getScrollSalaryAndName()
                .stream()
                .filter(employee -> employee.salary() > iteratorSalary()
                        .average()
                        .orElse(0))
                .map(Employee::name)
                .collect(Collectors.joining(", "));
    }
}

