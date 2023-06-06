package by.masha.cha.web;

import by.masha.cha.model.Department;
import by.masha.cha.model.Employee;
import by.masha.cha.model.Project;
import by.masha.cha.service.DepartmentService;
import by.masha.cha.service.EmployeeService;
import by.masha.cha.service.ProjectService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AddEmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    ProjectService projectService;

    @GetMapping("/add-employee.html")
    public ModelAndView showAddEmployeePage() {
        List<Department> departments = departmentService.getAll();
        List<Project> projects = projectService.getAll();
        ModelAndView modelAndView = new ModelAndView("add_employee");
        modelAndView.addAllObjects(Map.of("departments", departments));
        modelAndView.addAllObjects(Map.of("projects", projects));
        return modelAndView;

    }

    @PostMapping("/add-employee.html")
    @SneakyThrows
    public String addEmployee(@ModelAttribute("employeeAttribute") Employee employee,
                              @RequestParam(value = "projectsList") List<String> projects) {
        System.out.println("Call addEmployee: " + employee);
        if (employeeService.isAlreadyExist(employee) == false) {
            employeeService.add(employee, projects);
            return "redirect:/employee-list.html";
        } else {
            return "redirect:/error.html";
        }

    }



}

