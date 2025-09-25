package edu.cit.yu.rainricrandy.campuseequipmentloan.controller;

import edu.cit.yu.rainricrandy.campuseequipmentloan.model.Student;
import edu.cit.yu.rainricrandy.campuseequipmentloan.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    private final UserService userService;

    public WebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("student", new Student());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute Student student) {
        userService.register(student);
        return "redirect:/login";
    }
}