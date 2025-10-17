package com.java.pink_closet.security;

import com.java.pink_closet.model.Customer;
import com.java.pink_closet.model.Manager;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
public class AppUserDetails implements UserDetails {

    private final Object user; // pode ser Customer ou Manager

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Futuro: podemos retornar roles se quiser
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        if (user instanceof Customer c) return c.getPassword();
        if (user instanceof Manager m) return m.getPassword();
        return null;
    }

    @Override
    public String getUsername() {
        if (user instanceof Customer c) return c.getEmail();
        if (user instanceof Manager m) return m.getEmail();
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        if (user instanceof Customer c) return c.isActive();
        if (user instanceof Manager m) return m.isActive();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (user instanceof Customer c) return c.isActive();
        if (user instanceof Manager m) return m.isActive();
        return true;
    }

    public Long getId() {
        if (user instanceof Customer c) return c.getId();
        if (user instanceof Manager m) return m.getId();
        return null;
    }

    public String getType() {
        if (user instanceof Customer) return "CUSTOMER";
        if (user instanceof Manager) return "MANAGER";
        return "UNKNOWN";
    }

    public Object getUser() {
        return user;
    }
}
