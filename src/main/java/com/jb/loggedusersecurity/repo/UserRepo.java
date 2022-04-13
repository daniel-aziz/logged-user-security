package com.jb.loggedusersecurity.repo;

import com.jb.loggedusersecurity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
