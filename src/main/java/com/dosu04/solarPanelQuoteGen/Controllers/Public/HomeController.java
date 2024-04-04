package com.dosu04.solarPanelQuoteGen.Controllers.Public;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String showHome() {
        return "public/index";
    }
}
