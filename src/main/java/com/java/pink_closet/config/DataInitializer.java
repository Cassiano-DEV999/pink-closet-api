package com.java.pink_closet.config;

import com.java.pink_closet.model.Customer;
import com.java.pink_closet.model.Manager;
import com.java.pink_closet.model.ManagerRole;
import com.java.pink_closet.repositories.CustomerRepository;
import com.java.pink_closet.repositories.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final ManagerRepository managerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        // Criar Manager de teste
        managerRepository.findByEmailIgnoreCase("admin@pinkcloset.com")
                .ifPresentOrElse(
                        existing -> System.out.println("Manager já existe: " + existing.getEmail()),
                        () -> {
                            Manager manager = Manager.builder()
                                    .name("Admin PC")
                                    .email("adminpc@pinkcloset.com")
                                    .password(passwordEncoder.encode("admin123"))
                                    .role(ManagerRole.ADMIN)
                                    .active(true)
                                    .build();
                            try {
                                managerRepository.save(manager);
                                System.out.println("✅ Manager de teste criado: admin@pinkcloset.com / admin123");
                            } catch (Exception e) {
                                System.out.println("⚠️ Erro ao criar Manager: " + e.getMessage());
                            }
                        }
                );

        // Criar Customer de teste
        customerRepository.findByEmailIgnoreCase("cliente@pinkcloset.com")
                .ifPresentOrElse(
                        existing -> System.out.println("Customer já existe: " + existing.getEmail()),
                        () -> {
                            Customer customer = Customer.builder()
                                    .name("Cliente Teste")
                                    .email("cliente@pinkcloset.com")
                                    .password(passwordEncoder.encode("cliente123"))
                                    .active(true)
                                    .build();
                            try {
                                customerRepository.save(customer);
                                System.out.println("✅ Customer de teste criado: cliente@pinkcloset.com / cliente123");
                            } catch (Exception e) {
                                System.out.println("⚠️ Erro ao criar Customer: " + e.getMessage());
                            }
                        }
                );
    }
}
