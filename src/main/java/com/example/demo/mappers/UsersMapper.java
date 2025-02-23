package com.example.demo.mappers;

import com.example.demo.dto.UsersDto;
import com.example.demo.model.Authorities;
import com.example.demo.model.Users;
import com.example.demo.server.AuthoritiesService;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    private final AuthoritiesService authoritiesService;

    public UsersMapper(AuthoritiesService authoritiesService) {
        this.authoritiesService = authoritiesService;
    }

    public Users convertToEntity(UsersDto usersDto){
        Authorities authorities = authoritiesService.getUsersAuthorities(usersDto.getAuthorityId());
        return new Users(usersDto.getId(),usersDto.getName(),usersDto.getSurname(),usersDto.isEnabled(),authorities,usersDto.getLogin(),usersDto.getPassword());
    }

    public UsersDto convertToDto(Users users){
        return new UsersDto(users.getId(), users.getName(),users.getSurname(),users.getLogin(),users.getPassword(),users.isEnabled(),users.getAuthorityId().getId());
    }
}
