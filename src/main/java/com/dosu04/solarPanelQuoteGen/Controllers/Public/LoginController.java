package com.dosu04.solarPanelQuoteGen.Controllers.Public;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String displayLogin() {
        return "public/login";
    }
}