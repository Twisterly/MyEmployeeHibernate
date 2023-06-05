package by.masha.cha.web;

import by.masha.cha.model.Department;
import by.masha.cha.model.Employee;
import by.masha.cha.service.DepartmentService;
import by.masha.cha.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Map;

@Controller
public class ShowDepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/department-info.html")
    public ModelAndView showDepartmentInfo( Long id) {
        Department department = departmentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("show_department");
        modelAndView.addAllObjects(Map.of("department", department));
        modelAndView.addAllObjects(Map.of("employees",
                employeeService.findAllByDepartment(id)));
        return modelAndView;
    }

}




