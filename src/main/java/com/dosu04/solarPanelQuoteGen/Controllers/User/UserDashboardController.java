package com.dosu04.solarPanelQuoteGen.Controllers.User;

import com.dosu04.solarPanelQuoteGen.Services.QuoteService;
import com.dosu04.solarPanelQuoteGen.models.Quote;
import com.dosu04.solarPanelQuoteGen.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserDashboardController {

    private final QuoteService quoteService;

    public UserDashboardController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }


    @GetMapping("")
    public String showDashboard(Model model, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        model.addAttribute("quote", new Quote());


        List<Quote> userQuotes = quoteService.findQuotesByUser(user);
        userQuotes.sort(Comparator.comparing(Quote::getCreatedAt).reversed());

        // Filter the top 3 recent quotes
        List<Quote> recentQuotes = userQuotes.stream().limit(3).toList();


        model.addAttribute("recentQuotes", recentQuotes);



        return "user/dashboard";
    }


    @PostMapping("/save-quote")
    public String saveQuote(@ModelAttribute("quote") Quote quote, Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        // Set the user on the quote
        quote.setUser(user);
        // Save the quote to the database
        quoteService.save(quote);

        // Redirect or return a view based on your requirements
        return "redirect:/user";
    }


}
