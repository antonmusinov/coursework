package ru.diti.coursework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.diti.coursework.entity.Applicant;
import ru.diti.coursework.entity.Employer;
import ru.diti.coursework.service.api.ApplicantService;

@Controller
public class ApplicantController {
    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping(value = {"applicant/{applicantId}/edit"})
    public String showEditEmployer(Model model, @PathVariable Long applicantId) {
        Applicant applicant = null;
        try {
            applicant = applicantService.findById(applicantId);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", "Contact not found");
        }

        model.addAttribute("add", false);
        model.addAttribute("applicant", applicant);
        return "applicant-edit";
    }

    @PostMapping(value = {"applicant/{applicantId}/edit"})
    public String updateEmployer(Model model, @PathVariable Long applicantId, @ModelAttribute("applicant") Applicant applicant) {
        try {
            applicant.setApplicantId(applicantId);
            applicantService.update(applicant);
            return "redirect:/applicants";
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);
            return "applicant-edit";
        }
    }

    @GetMapping("/applicant/add")
    public String showAddApplicant(Model model) {
        Applicant applicant = new Applicant();
        model.addAttribute("add", true);
        model.addAttribute("applicant", applicant);

        return "applicant-edit";
    }

    @PostMapping("/applicant/add")
    public String addApplicant(Model model, @ModelAttribute("applicant") Applicant applicant) {
        try {
            applicantService.save(applicant);
            return "redirect:/applicants";
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);
            return "applicant-edit";
        }
    }

    @GetMapping("/applicants")
    public String allApplicants(Model model) {
        model.addAttribute("allApplicants", applicantService.allApplicants());
        return "applicant";
    }

    @GetMapping(value = {"applicant/{applicantId}/delete"})
    public String deleteApplicant(Model model, @PathVariable Long applicantId, @ModelAttribute("applicant") Applicant applicant) {
        try {
            applicantService.delete(applicant);
            return "applicant";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("add", false);
            return "applicant";
        }
    }
}
