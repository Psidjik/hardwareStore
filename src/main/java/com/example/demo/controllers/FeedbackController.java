package com.example.demo.controllers;

import com.example.demo.dtos.FeedbackDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.service.FeedbackService;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    private FeedbackService feedbackService;


    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }
    @ModelAttribute("feedbackModel")
    public FeedbackDto initModel() {
        return new FeedbackDto();
    }

    @GetMapping("/add")
    public String addFeedback(Model model) {
         model.addAttribute("availableClients", feedbackService.showUsers());
         model.addAttribute("availableProducts", feedbackService.showProducts());
        return "feedback-add";
    }

    @PostMapping("/add")
    public String addFeedback(@ModelAttribute("feedbackDto") @Valid FeedbackDto feedbackDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("feedbackDto", feedbackDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.feedbackDto",
                    bindingResult);
            return "redirect:/feedback/add";
        }

        feedbackService.addNewFeedback(feedbackDto);
        return "redirect:/feedback/all";
    }

    @GetMapping("/all")
    public String getAllFeedbacks(Model model) {
        model.addAttribute("feedbackInfos", feedbackService.getAllFeedbacks());
        return "feedback-all";
    }
}
