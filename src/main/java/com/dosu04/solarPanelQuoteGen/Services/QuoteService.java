package com.dosu04.solarPanelQuoteGen.Services;

import com.dosu04.solarPanelQuoteGen.Repositories.QuoteRepo;
import com.dosu04.solarPanelQuoteGen.models.Quote;
import com.dosu04.solarPanelQuoteGen.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {

    private final QuoteRepo quoteRepo;
    public QuoteService(QuoteRepo quoteRepo) {
        this.quoteRepo = quoteRepo;
    }


    public void save(Quote quote) {
        quoteRepo.save(quote);
    }

    public List<Quote> findQuotesByUser(User user) {
        return quoteRepo.findByUser(user);
    }

    public Quote findQuoteById(Long id) {
        return quoteRepo.findById(id).orElse(null);
    }


    public void delete(Long id) {
        quoteRepo.deleteById(id);
    }

    public List<Quote> searchQuotes(String keyword) {
    }
}
