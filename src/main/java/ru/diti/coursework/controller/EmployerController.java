package ru.diti.coursework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diti.coursework.entity.Employer;
import ru.diti.coursework.service.api.EmployerService;

import java.util.List;

@Controller
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @RequestMapping("/")
    public String allEmployers(Model model) {
        List<Employer> allEmployers = employerService.getAllEmployer();
        model.addAttribute("allEmployers", allEmployers);
        return "index";
    }
}
