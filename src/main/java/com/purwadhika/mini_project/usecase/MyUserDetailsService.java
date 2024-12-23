package com.purwadhika.mini_project.usecase;


import com.purwadhika.mini_project.common.security.UserPrincipal;
import com.purwadhika.mini_project.entity.Users;
import com.purwadhika.mini_project.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);
        if(user == null){ // if user not found
            System.out.println("User not found ayee");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user);
    }
}
