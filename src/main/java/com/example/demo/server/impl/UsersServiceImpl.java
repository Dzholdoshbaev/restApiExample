package com.example.demo.server.impl;

import com.example.demo.dto.UsersDto;
import com.example.demo.mappers.UsersMapper;
import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.server.AuthoritiesService;
import com.example.demo.server.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    public UsersServiceImpl(UsersRepository usersRepository, AuthoritiesService authoritiesService, UsersMapper usersMapper){
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    };

    @Override
    public UsersDto createUsers(UsersDto usersDto) {
        Users users = usersMapper.convertToEntity(usersDto);
        Users savedUser = usersRepository.save(users);
        return usersMapper.convertToDto(savedUser);
    }

    @Override
    public List<UsersDto> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return users.stream().map(usersMapper::convertToDto).collect(Collectors.toList());
    }
}
