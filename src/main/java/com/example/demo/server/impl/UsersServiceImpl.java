package com.example.demo.server.impl;

import com.example.demo.dto.UsersDto;
import com.example.demo.model.Authorities;
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
    private final AuthoritiesService authoritiesService;

    public UsersServiceImpl(UsersRepository usersRepository, AuthoritiesService authoritiesService){
        this.usersRepository = usersRepository;
        this.authoritiesService = authoritiesService;
    };

    @Override
    public UsersDto createUsers(UsersDto usersDto) {
        Users users = convertToEntity(usersDto);
        Users savedUser = usersRepository.save(users);
        return convertToDto(savedUser);
    }

    @Override
    public Users convertToEntity(UsersDto usersDto){
        Authorities authorities = authoritiesService.getUsersAuthorities(usersDto.getAuthorityId());
        return new Users(usersDto.getId(),usersDto.getName(),usersDto.getSurname(),usersDto.isEnabled(),authorities,usersDto.getLogin(),usersDto.getPassword());
    }

    @Override
    public UsersDto convertToDto(Users users){
        return new UsersDto(users.getId(), users.getName(),users.getSurname(),users.getLogin(),users.getPassword(),users.isEnabled(),users.getAuthorityId().getId());
    }

    @Override
    public List<UsersDto> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
