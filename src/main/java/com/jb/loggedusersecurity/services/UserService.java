package com.jb.loggedusersecurity.services;


import com.jb.loggedusersecurity.domain.User;
import com.jb.loggedusersecurity.domain.Role;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUser();


}
