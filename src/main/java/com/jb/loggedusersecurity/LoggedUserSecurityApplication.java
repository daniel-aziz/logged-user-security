package com.jb.loggedusersecurity;

import com.jb.loggedusersecurity.domain.Role;
import com.jb.loggedusersecurity.domain.User;
import com.jb.loggedusersecurity.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class LoggedUserSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoggedUserSecurityApplication.class, args);
        System.out.printf("\nServer Running at Port: %s","8080");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));


            userService.saveUser(new User(null, "A", "a", "1", new ArrayList<>()));
            userService.saveUser(new User(null, "B", "b", "2", new ArrayList<>()));
            userService.saveUser(new User(null, "C", "c", "3", new ArrayList<>()));
            userService.saveUser(new User(null, "D", "d", "4", new ArrayList<>()));

            userService.addRoleToUser("a", "ROLE_USER");
            userService.addRoleToUser("a", "ROLE_MANAGER");
            userService.addRoleToUser("b", "ROLE_ADMIN");
            userService.addRoleToUser("c", "ROLE_ADMIN");
            userService.addRoleToUser("c", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("d", "ROLE_USER");


        };
    }


}
