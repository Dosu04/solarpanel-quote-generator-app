package com.dosu04.solarPanelQuoteGen.Repositories;


import com.dosu04.solarPanelQuoteGen.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
