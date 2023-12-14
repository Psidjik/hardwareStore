package com.example.demo.controllers;

import com.example.demo.dtos.CategoryDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.service.CategoryService;


@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping("/all")
    public String showAllCategories(Model model) {
        model.addAttribute("categoriesInfos", categoryService.getAllCategories());
        return "categories-all";
    }

    @GetMapping("/add")
    public String addCategory() {
        return "category-add";
    }

    @ModelAttribute("categoryModel")
    public CategoryDto initCategory() {
        return new CategoryDto();
    }

    @PostMapping("/add")
    public String addCategory(@Valid CategoryDto categoryDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("categoryModel", categoryDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.categoryModel",
                    bindingResult);
            return "redirect:/category/add";
        }
        categoryService.addNewCategory(categoryDto);
        return "redirect:/category/all";
    }
    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
