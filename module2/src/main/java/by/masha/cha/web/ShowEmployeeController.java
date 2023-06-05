package by.masha.cha.web;

import by.masha.cha.model.Employee;
import by.masha.cha.service.EmployeeService;
import by.masha.cha.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ShowEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/employee-info.html")
    public ModelAndView showEmployeeInfo(Long id) {
        Employee employee = employeeService.getById(id);
        ModelAndView modelAndView = new ModelAndView("show_employee");
        modelAndView.addAllObjects(Map.of("employees",
                employeeService.findAllByDepartment(id)));
        return modelAndView;
    }

}
