package ru.diti.coursework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.diti.coursework.entity.Deal;
import ru.diti.coursework.service.api.DealService;

import java.util.List;

@Controller
public class DealController {

    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping("/deals")
    public String allEmployers(Model model) {
        List<Deal> allDeals = dealService.getAllDeals();
        model.addAttribute("allDeals", allDeals);
        return "deal";
    }

    @GetMapping("/deal/add")
    public String showAddDeal(Model model) {
        Deal deal = new Deal();
        model.addAttribute("add", true);
        model.addAttribute("deal", deal);

        return "deal-edit";
    }

    @PostMapping("/deal/add")
    public String addEmployer(Model model, @ModelAttribute("deal") Deal deal) {
        try {
            dealService.save(deal);
            return "redirect:/deals";
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", true);
            return "deal-edit";
        }
    }

    @GetMapping(value = {"deal/{dealId}/edit"})
    public String showEditEmployer(Model model, @PathVariable Long employerId) {
        Deal deal = null;
        try {
            deal = dealService.findById(employerId);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", "Contact not found");
        }

        model.addAttribute("add", false);
        model.addAttribute("deal", deal);
        return "deal-edit";
    }

    @PostMapping(value = {"deal/{dealId}/edit"})
    public String updateEmployer(Model model, @PathVariable Long dealId, @ModelAttribute("deal") Deal deal) {
        try {
            deal.setDealId(dealId);
            dealService.update(deal);
            return "redirect:/deals";
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            model.addAttribute("errorMessage", errorMessage);

            model.addAttribute("add", false);
            return "deal-edit";
        }
    }

    @GetMapping(value = {"employer/{employerId}/delete"})
    public String deleteEmployer(Model model, @PathVariable Long employerId, @ModelAttribute("deal") Deal deal) {
        try {
            dealService.delete(deal);
            return "deal";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());

            model.addAttribute("add", false);
            return "deal";
        }
    }
}
