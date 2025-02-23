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

    public Authorities() {
    }

    public Authorities(UUID id, String authority, List<Users> usersList) {
        this.id = id;
        this.authority = authority;
        this.usersList = usersList;
    }

    public UUID getId() {
        return id;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public String getAuthority() {
        return authority;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Authorities{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                ", usersList=" + usersList +
                '}';
    }
}
