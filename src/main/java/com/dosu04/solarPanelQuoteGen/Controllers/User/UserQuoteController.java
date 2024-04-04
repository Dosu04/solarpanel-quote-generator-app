package com.dosu04.solarPanelQuoteGen.Controllers.User;

import com.dosu04.solarPanelQuoteGen.Services.QuoteService;
import com.dosu04.solarPanelQuoteGen.Services.UserService;
import com.dosu04.solarPanelQuoteGen.models.Quote;
import com.dosu04.solarPanelQuoteGen.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserQuoteController {
        private final QuoteService quoteService;
        private final UserService userService;

        public UserQuoteController(QuoteService quoteService, UserService userService) {
            this.quoteService = quoteService;
            this.userService = userService;
        }

        @GetMapping("/quotes")
        public String viewQuotes(Model model, Authentication authentication) {
            User user = (User) authentication.getPrincipal();
            List<Quote> quotes = quoteService.findQuotesByUser(user);

            // Sort the quotes by creation date in descending order
            quotes.sort(Comparator.comparing(Quote::getCreatedAt).reversed());


            model.addAttribute("quotes", quotes);
            model.addAttribute("user", user);
            return "user/quotes";
        }

        @PostMapping("/delete-quote/{id}")
        public String deleteQuote(@PathVariable Long id, RedirectAttributes redirectAttributes) {
            quoteService.delete(id);
            redirectAttributes.addFlashAttribute("successMessage", "Quote deleted successfully.");
            return "redirect:/user/quotes";

        }



    }

