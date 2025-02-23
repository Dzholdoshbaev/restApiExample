package com.example.demo.dto;

import java.util.UUID;

public class AuthoritiesDto {
    private UUID id;
    private String authority;

    public AuthoritiesDto(){
    }

    public AuthoritiesDto(UUID id, String authority){
        this.id = id;
        this.authority = authority;
    }

    public UUID getId(){
        return id;
    }

    public String getAuthority(){
        return authority;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public void setAuthority(String authority){
        this.authority = authority;
    }

    @Override
    public String toString(){
        return "AuthorityDto{" +
                "id=" + id +
                ", authority=" + authority + '\'' +
                '}';
    }
}
