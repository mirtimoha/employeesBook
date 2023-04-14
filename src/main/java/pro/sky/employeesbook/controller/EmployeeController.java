package pro.sky.employeesbook.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeesbook.model.Employee;
import pro.sky.employeesbook.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class EmployeeController {
    final private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employee/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int department) {
        return service.add(firstName, lastName, department);
    }

    @GetMapping("/employee/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.remove(firstName, lastName);
    }

    @GetMapping("/employee/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return service.find(firstName, lastName);
    }

    @GetMapping("/employee")
    public Collection<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping("/employee/fill")
    //Данный блок кода служит для заполнения данных сотрудников с целью тестирования приложения
    public boolean fill() {
        return service.fillEmployees();
    }

    @GetMapping("/departments/min-salary")
    public Employee findMinSalaryInDepartment(@RequestParam int department) {
        return service.findMinSalaryInDepartment(department);
    }

    @GetMapping("/departments/max-salary")
    public Employee findMaxSalaryInDepartment(@RequestParam int department) {
        return service.findMaxSalaryInDepartment(department);
    }

    @GetMapping("/departments/all")
    public Collection<Employee> findAllInDepartment(@RequestParam(required = false) Integer department) {
        if (department == null) {
            return service.findAllByDepartments();
        }
        return service.findAllInDepartment(department);
    }


}

