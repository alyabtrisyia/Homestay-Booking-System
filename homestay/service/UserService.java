package com.csc3402.security.homestay.service;

import com.csc3402.security.homestay.dto.UserDto;
import com.csc3402.security.homestay.model.User;
public interface UserService {

    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
}
