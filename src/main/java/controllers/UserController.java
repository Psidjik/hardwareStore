package controllers;


import dtos.ClientDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @ModelAttribute("userModel")
    public ClientDto initUser() {
        return new ClientDto();
    }

    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute("availableRoles", userService.showRole());
        return "user-add";
    }
    @PostMapping("/add")
    String addUser(@Valid ClientDto userDto, RedirectAttributes redirectAttributes, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userDto", userDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userDto",
                    bindingResult);
            return "redirect:/user/add";
        }
        userService.addNewUser(userDto);
        return "redirect:/user/all";
    }

    @GetMapping("/all")
    String getAllUser(Model model){
        model.addAttribute("userInfos", userService.getAllUser());
        return "user-all";
    }


//    @GetMapping("/details/{username}")
//    String getUserByUsername(@PathVariable String username, Model model){
//        model.addAttribute("userDetail", userService.getUserByUsername(username));
//        model.addAttribute("offers", userService.getOffersByUsername(username));
//        return "user-details";
//    }

//    @DeleteMapping("/delete/{id}")
//    String deleteUser(@PathVariable String id){
//        userService.deleteUserById(id);
//        return "Client with id = " + id + " was deleted";}

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
