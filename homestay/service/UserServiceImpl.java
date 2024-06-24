package com.csc3402.security.homestay.service;

import com.csc3402.security.homestay.dto.UserDto;
import com.csc3402.security.homestay.model.Role;
import com.csc3402.security.homestay.model.User;
import com.csc3402.security.homestay.repository.RoleRepository;
import com.csc3402.security.homestay.repository.UserRepository;
import com.csc3402.security.homestay.util.TbConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto){
        Role role = roleRepository.findByName(TbConstants.Roles.USER);

        if (role == null)
            role = roleRepository.save(new Role(TbConstants.Roles.USER));

        User user = new User(userDto.getName(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), userDto.getPhone(), Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
