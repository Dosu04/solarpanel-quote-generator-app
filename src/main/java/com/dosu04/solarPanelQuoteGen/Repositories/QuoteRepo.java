package com.dosu04.solarPanelQuoteGen.Repositories;


import com.dosu04.solarPanelQuoteGen.models.Quote;
import com.dosu04.solarPanelQuoteGen.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepo extends JpaRepository<Quote, Long> {


    List<Quote> findByUser(User user);
}
