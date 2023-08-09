package org.salary.mysalary.controllers;

import jakarta.annotation.Resource;
import org.salary.mysalary.models.Employee;
import org.salary.mysalary.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Resource
    EmployeeService employeeService;


    @GetMapping("all")
    public ResponseEntity<List<Employee>> allEmployee() {
        List<Employee> scrollSalaryAndName = employeeService.getScrollSalaryAndName();
        return ResponseEntity.ok(scrollSalaryAndName);
    }

    @GetMapping("salary/sum")
    public ResponseEntity<Integer> sumSalary() {
        int i = employeeService.sumSalary();
        if (i == 0) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(i);
    }
    @GetMapping("salary/max")
    public ResponseEntity<String> maxSalary() {
        String str = employeeService.maxSalary();
        if(str==null)return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(str);
    }
    @GetMapping("salary/min")
    public ResponseEntity<String> minSalary() {
        String str = employeeService.minSalary();
        if(str==null)return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(str);
    }
    @GetMapping("high-salary")
    public ResponseEntity<String> highSalary() {
        String str = employeeService.averageSalary();
        if(str.isBlank())return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(str);
    }
}
