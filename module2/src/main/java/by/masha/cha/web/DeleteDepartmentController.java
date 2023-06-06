package by.masha.cha.web;

import by.masha.cha.model.Department;
import by.masha.cha.service.DepartmentService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class DeleteDepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/delete-department.html")
    public ModelAndView showDeleteQuestion(Long id) {
        Department department = departmentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete_question");
        modelAndView.addAllObjects(Map.of("departmentId", id));
        return modelAndView;
    }

    @PostMapping("/delete-department.html")
    @SneakyThrows
    public String deleteDepartment(Long id) {
       Department department= departmentService.findById(id);
        System.out.println("Call deleteDepartment: " + department);
        departmentService.delete(department);
        return "redirect:/department-list.html";
    }

}

