package com.example.demo.server;

import com.example.demo.dto.UsersDto;
import java.util.List;

public interface UsersService {
    UsersDto createUsers(UsersDto usersDto);

    List<UsersDto> getAllUsers();
}
