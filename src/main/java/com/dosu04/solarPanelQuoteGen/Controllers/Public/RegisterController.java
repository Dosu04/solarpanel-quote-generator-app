package com.dosu04.solarPanelQuoteGen.Controllers.Public;


import com.dosu04.solarPanelQuoteGen.Repositories.RoleRepo;
import com.dosu04.solarPanelQuoteGen.Services.UserService;
import com.dosu04.solarPanelQuoteGen.models.Role;
import com.dosu04.solarPanelQuoteGen.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class RegisterController {


    private final UserService userService;
    private final RoleRepo roleRepo;

    public RegisterController(UserService userService, RoleRepo roleRepo) {
        this.userService = userService;
        this.roleRepo = roleRepo;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "public/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {

        // Fetch the "USER" role from the roles table
        Role userRole = roleRepo.findByName("user");

        if (userRole == null) {
            throw new RuntimeException("Role 'USER' not found in the database.");
        }

        user.getRoles().add(userRole);

        userService.save(user);
        return "redirect:/user";
    }



}
