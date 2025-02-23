package com.example.demo.server;

import com.example.demo.model.Authorities;

import java.util.UUID;

public interface AuthoritiesService {
    Authorities getUsersAuthorities(UUID authorityId);
}
