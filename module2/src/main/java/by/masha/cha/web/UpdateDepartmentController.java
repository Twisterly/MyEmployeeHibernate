package by.masha.cha.web;

import by.masha.cha.model.Department;
import by.masha.cha.model.Employee;
import by.masha.cha.service.DepartmentService;
import by.masha.cha.service.EmployeeService;
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
public class UpdateDepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/update-department.html")
    public ModelAndView showUpdateDepartmentPage(Long id) {
        Department department = departmentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("update_department");
        modelAndView.addAllObjects(Map.of("department", department));
        modelAndView.addAllObjects(Map.of("departmentId", id));
        return modelAndView;
    }


    @PostMapping("/update-department.html")
    @SneakyThrows
    public ModelAndView updateDepartment(Department department,
                                         Long id) {
        System.out.println("Call updateDepartment: " + department);
        List<Employee> employees = employeeService.findAllByDepartment(id);
        ModelAndView modelAndView = new ModelAndView("department_info");
        modelAndView.addAllObjects(Map.of("department",
                departmentService.update(department, id)));
        return modelAndView;
    }

}

