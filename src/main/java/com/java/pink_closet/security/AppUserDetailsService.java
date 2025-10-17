package com.java.pink_closet.security;

import com.java.pink_closet.model.Customer;
import com.java.pink_closet.model.Manager;
import com.java.pink_closet.repositories.CustomerRepository;
import com.java.pink_closet.repositories.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;
    private final ManagerRepository managerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Tenta achar Customer
        Customer customer = customerRepository.findByEmail(email).orElse(null);
        if (customer != null) {
            return new AppUserDetails(customer);
        }

        // Tenta achar Manager
        Manager manager = managerRepository.findByEmail(email).orElse(null);
        if (manager != null) {
            return new AppUserDetails(manager);
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
