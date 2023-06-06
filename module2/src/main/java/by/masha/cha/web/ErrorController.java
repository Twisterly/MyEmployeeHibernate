package by.masha.cha.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @GetMapping({ "/error.html"})
    public ModelAndView errorPage() {
        System.out.println("Call errorPage");
        return new ModelAndView("error");
    }
}
