package com.example.demo.model;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.ToStringExclude;
import java.util.UUID;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private boolean enabled;
    @ToStringExclude
    @ManyToOne
    @JoinColumn(name = "authority_uuid")
    private Authorities authorityId;

    public Users() {
    }

    public Users(UUID id, String name, String surname, boolean enabled, Authorities authorityId, String login, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.enabled = enabled;
        this.authorityId = authorityId;
        this.login = login;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return surname;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Authorities getAuthorityId() {
        return authorityId;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAuthorityId(Authorities authorityId) {
        this.authorityId = authorityId;
    }
}
