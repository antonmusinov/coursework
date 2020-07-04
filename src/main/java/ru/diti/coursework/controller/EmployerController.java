package ru.diti.coursework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/employers")
    public String allEmployers(Model model) {
        List<Employer> allEmployers = employerService.getAllEmployer();
        model.addAttribute("allEmployers", allEmployers);
        return "employer";
    }

    @GetMapping("/employer/add")
    public String showAddEmployer(Model model) {
        Employer employer = new Employer();
        model.addAttribute("add", true);
        model.addAttribute("employer", employer);

        return "employer-edit";
    }

    @PostMapping("/employer/add")
    public String addEmployer(Model model, @ModelAttribute("employer") Employer employer) {
        try {
            employerService.save(employer);
            return "redirect:/employers";
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);
            return "employer-edit";
        }
    }

    @GetMapping(value = {"employer/{employerId}/edit"})
    public String showEditEmployer(Model model, @PathVariable Long employerId) {
        Employer employer = null;
        try {
            employer = employerService.findById(employerId);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", "Contact not found");
        }

        model.addAttribute("add", false);
        model.addAttribute("employer", employer);
        return "employer-edit";
    }

    @PostMapping(value = {"employer/{employerId}/edit"})
    public String updateEmployer(Model model, @PathVariable Long employerId, @ModelAttribute("employer") Employer employer) {
        try {
            employer.setEmployerId(employerId);
            employerService.update(employer);
            return "redirect:/employers";
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            model.addAttribute("errorMessage", errorMessage);

            model.addAttribute("add", false);
            return "employer-edit";
        }
    }

    @GetMapping(value = {"employer/{employerId}/delete"})
    public String deleteEmployer(Model model, @PathVariable Long employerId, @ModelAttribute("employer") Employer employer) {
        try {
            employerService.delete(employer);
            return "employer";
        } catch (Exception e) {
           model.addAttribute("errorMessage", e.getMessage());

           model.addAttribute("add", false);
           return "employer";
        }
    }
}
