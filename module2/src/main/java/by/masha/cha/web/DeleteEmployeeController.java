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
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class DeleteEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/delete-employee.html")
    public ModelAndView showDeleteQuestion(Long id) {
        Employee employee = employeeService.getById(id);
        ModelAndView modelAndView = new ModelAndView("delete_question_2");
        modelAndView.addAllObjects(Map.of("employeeId", id));
        return modelAndView;
    }

    @PostMapping("/delete-employee.html")
    @SneakyThrows
    public String deleteEmployee(Long id) {
        Employee employee= employeeService.getById(id);
        System.out.println("Call deleteEmployee: " + employee);
       employeeService.delete(employee);
        return "redirect:/employee-list.html";
    }
}
