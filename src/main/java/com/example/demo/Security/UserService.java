package com.example.demo.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Arrays;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public UserService(UserRepository userRepository){this.userRepository=userRepository;}


    public User findByUsername(String username){return userRepository.findByUserName(username);}

    public void saveUser(User user){
        user.setRoles(Arrays.asList(roleRepository.findRoleByRole("APPLICANT")));
        user.setEnabled(true);
        userRepository.save(user);
    }

    public void saveAdmin(User user){
        user.setRoles(Arrays.asList(roleRepository.findRoleByRole("EMPLOYER")));
        user.setEnabled(true);
        userRepository.save(user);
    }

}
