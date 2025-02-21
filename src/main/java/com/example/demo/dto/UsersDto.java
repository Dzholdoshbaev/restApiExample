package com.example.demo.dto;

import java.util.UUID;

public class UsersDto {
    private UUID id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private boolean enabled;
    private UUID authorityId;

    public UsersDto (){
    }

    public UsersDto(UUID id, String name, String surname, String login, String password, boolean enabled, UUID authorityId){
        this.id = id;
        this.name =name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.enabled = enabled;
        this.authorityId = authorityId;
    }

    public UUID getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }

    public boolean isEnabled(){
        return enabled;
    }

    public UUID getAuthorityId(){
        return authorityId;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }

    public void setAuthorityId(UUID authorityId){
        this.authorityId = authorityId;
    }

    @Override
    public String toString() {
        return "UsersDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", authorityId=" + authorityId +
                '}';
    }
}

