package com.dosu04.solarPanelQuoteGen.Repositories;

import com.dosu04.solarPanelQuoteGen.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public User findByUsername(String username);

}

