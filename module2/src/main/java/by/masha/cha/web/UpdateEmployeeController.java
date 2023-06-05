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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class UpdateEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private ProjectService projectService;

    @GetMapping("/update-employee.html")
    public ModelAndView showUpdateEmployeePage(Long id) {
        Employee employee = employeeService.getById(id);
        List<Department> departments = departmentService.getAll();
        List<Project> projects = projectService.getAll();
        ModelAndView modelAndView = new ModelAndView("update_employee");
        modelAndView.addAllObjects(Map.of("departments", departments));
        modelAndView.addAllObjects(Map.of("employee", employee));
        modelAndView.addAllObjects(Map.of("projects", projects));
        modelAndView.addAllObjects(Map.of("departmentId", id));
        return modelAndView;
    }


    @PostMapping("/update-employee.html")
    @SneakyThrows
    public ModelAndView updateEmployee(Employee employee, Long id,
                                       @RequestParam(value = "projectsList") List<String> projects) {
        System.out.println("Call updateEmployee: " + employee);
        ModelAndView modelAndView = new ModelAndView("employee_info");
        modelAndView.addAllObjects(Map.of("employee",
                employeeService.update(employee, id, projects)));
        modelAndView.addAllObjects(Map.of("projects",
                projectService.findProjectsById(projects)));
        return modelAndView;
    }

}
