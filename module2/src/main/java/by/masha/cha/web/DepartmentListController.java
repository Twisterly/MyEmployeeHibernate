package by.masha.cha.web;

import by.masha.cha.dao.DepartmentDao;
import by.masha.cha.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class DepartmentListController {

    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/department-list.html")
    public ModelAndView showDepartmentList() {

        return new ModelAndView(
                "department_list",
                Map.of("departments", departmentService.findAll())
        );
    }

}
