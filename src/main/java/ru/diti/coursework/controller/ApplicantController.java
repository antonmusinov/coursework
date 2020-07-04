package ru.diti.coursework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.diti.coursework.entity.Applicant;
import ru.diti.coursework.service.api.ApplicantService;

import java.util.List;

@Controller
public class ApplicantController {

    private ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping("/applicants")
    public String allApplicants(Model model) {
        List<Applicant> allApplicants = applicantService.getAllApplicants();
        model.addAttribute("allApplicants", allApplicants);
        return "/applicant";
    }
}
