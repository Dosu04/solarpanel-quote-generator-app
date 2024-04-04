package com.dosu04.solarPanelQuoteGen.Controllers.Admin;

import com.dosu04.solarPanelQuoteGen.Services.UserService;
import com.dosu04.solarPanelQuoteGen.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showDashboard(Model model) {

        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin/dashboard";

    }


    @PostMapping("/delete-user/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUserById(userId);
        return "redirect:/admin";
    }


}
