package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "authorities")
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid")
    private UUID id;
    @Column(name = "authority")
    private String authority;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "authorityId")
    private List<Users> usersList;
}
