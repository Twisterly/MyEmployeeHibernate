package by.masha.cha.web;


import by.masha.cha.model.Project;
import by.masha.cha.service.ProjectService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
public class UpdateProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/update-project.html")
    public ModelAndView showUpdateProjectPage(Long id) {
        Project project = projectService.findById(id);
        ModelAndView modelAndView = new ModelAndView("update_project");
        modelAndView.addAllObjects(Map.of("project", project));
        modelAndView.addAllObjects(Map.of("projectId", id));
        return modelAndView;
    }


    @PostMapping("/update-project.html")
    @SneakyThrows
    public ModelAndView updateProject(Project project, Long id) {
        System.out.println("Call updateProject: " + project);
        return new ModelAndView("project_info", Map.of("project",
                projectService.update(project, id)));

    }

}
