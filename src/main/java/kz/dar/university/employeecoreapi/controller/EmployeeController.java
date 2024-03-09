package kz.dar.university.employeecoreapi.controller;

import jakarta.validation.Valid;
import kz.dar.university.employeecoreapi.domain.Employee;
import kz.dar.university.employeecoreapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    //private final EmployeeService employeeService
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmplyeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public void createEmployee(@Valid @RequestBody Employee employee) {
        employee.setId(UUID.randomUUID().toString());
        employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public void updateEmployee(
            @PathVariable String id,
            @Valid @RequestBody Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
    }

    @PutMapping
    public void updateEmployee(
            @Valid @RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
    }
}
