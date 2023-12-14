package controllers;

import dtos.UserRoleDto;
import jakarta.validation.Valid;
import models.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.UserRoleService;

import java.util.List;

@Controller
@RequestMapping("/userrole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping("/all")
    public String showAllUserRole(Model model){
        model.addAttribute("userRoleInfos", userRoleService.getAllUserRoles());
        return "userRoles-all";
    }

    //    @GetMapping("/userRole-details/{userRole}")
//    public String brandDetails(@PathVariable("userRole") String userRole, Model model) {
//        model.addAttribute("userRoleDetails", userRoleService.userRoleDetails(userRole));
//
//        return "userRole-details";
//    }
    @GetMapping("/add")
    public String addUserRole() {
        return "userRole-add";
    }
    @ModelAttribute("userRoleModel")
    public UserRoleDto initUserRole() {
        return new UserRoleDto();
    }
    @PostMapping("/add")
    public String addUserRole(@Valid UserRoleDto userRoleDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRoleModel", userRoleDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRoleModel",
                    bindingResult);
            return "redirect:/userRoles/add";
        }

        userRoleService.addNewUserRole(userRoleDto);

        return "redirect:/";
    }
}
