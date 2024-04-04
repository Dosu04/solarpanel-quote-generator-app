package com.dosu04.solarPanelQuoteGen.Controllers.User;

import com.dosu04.solarPanelQuoteGen.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/profile")
public class UserProfileController {


    @GetMapping("")
    public String showEditSettings(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        model.addAttribute("user", user);
        return "user/profile";

    }


    }

