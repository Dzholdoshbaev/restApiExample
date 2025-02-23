package com.example.demo.server;

import com.example.demo.dto.UsersDto;
import com.example.demo.model.Users;

import java.util.List;

public interface UsersService {
    UsersDto createUsers(UsersDto usersDto);

    Users convertToEntity(UsersDto usersDto);

    UsersDto convertToDto(Users users);

    List<UsersDto> getAllUsers();
}
