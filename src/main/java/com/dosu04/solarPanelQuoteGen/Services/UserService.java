package com.dosu04.solarPanelQuoteGen.Services;

import com.dosu04.solarPanelQuoteGen.Repositories.UserRepo;
//
import com.dosu04.solarPanelQuoteGen.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
        } catch (Exception e) {
            // Handle the exception, e.g., log or throw a custom exception
            throw new RuntimeException("Error registering user", e);
        }
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void deleteUserById(Long userId) {
        userRepo.deleteById(userId);
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }


}
