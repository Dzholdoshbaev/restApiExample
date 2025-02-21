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
}
