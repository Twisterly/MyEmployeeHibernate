package by.masha.cha.web;

import by.masha.cha.dao.ProjectDao;
import by.masha.cha.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class ProjectListController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/project-list.html")
    public ModelAndView showProjectList() {
        return new ModelAndView(
                "project_list",
                Map.of("projects", projectService.getAll())
        );
    }
}
