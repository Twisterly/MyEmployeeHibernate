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
public class DeleteProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/delete-project.html")
    public ModelAndView showDeleteQuestion(Long id) {
        Project project = projectService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete_question_3");
        modelAndView.addAllObjects(Map.of("projectId", id));
        return modelAndView;
    }

    @PostMapping("/delete-project.html")
    @SneakyThrows
    public String deleteProject(Long id) {
        Project project = projectService.findById(id);
        System.out.println("Call deleteProject: " + project);
        projectService.delete(project);
        return "redirect:/project-list.html";
    }
}
