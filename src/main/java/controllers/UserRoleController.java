package controllers;

import dtos.UserRoleDto;
import jakarta.validation.Valid;
import models.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserRoleService;

import java.util.List;

@Controller
@RequestMapping("/userrole")
public class UserRoleController {
    private UserRoleService userRoleService;

    @ModelAttribute("userRoleDto")
    public UserRoleDto initBrand(){
        return new UserRoleDto();
    }

    @GetMapping("/add")
    String addUserRole(){
        return "userrole-add";
    }

    @PostMapping("/add")
    String addUserRole(@Valid UserRoleDto userRoleDto){
        userRoleService.addNewUserRole(userRoleDto);
        return "redirect:/";
    }

    @GetMapping("/all")
    List<UserRoleDto> getAllUserRole(){
        return userRoleService.getAllUserRole();
    }
    @GetMapping("/{id}")
    UserRoleDto getUserRoleById(@PathVariable String id){
        return userRoleService.getUserRoleById(id);
    }

    @DeleteMapping("/delete/{id}")
    String deleteUserRole(@PathVariable String id){
        userRoleService.deleteUserRoleById(id);
        return "Client with id = " + id + " was deleted";}
    @PutMapping("/{id}/{role}")
    UserRoleDto updateUserRoleName(@PathVariable String id, @PathVariable Role role){
        return userRoleService.updateUserRoleName(id, role);
    }
    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }
}
