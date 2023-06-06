package by.masha.cha.web;

import by.masha.cha.model.Project;
import by.masha.cha.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/add-project.html")
    public String showAddProjectPage() {
        return "add_project";
    }

    @PostMapping("/add-project.html")
    public String addProject(Project project) {
        System.out.println("addProject: " + project);
        if (projectService.isAlreadyExist(project) == false) {
            projectService.add(project);
            return "redirect:/project-list.html";
        } else {
            return "redirect:/error.html";
        }

    }
}
