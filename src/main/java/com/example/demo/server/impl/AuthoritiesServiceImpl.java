package com.example.demo.server.impl;

import com.example.demo.exceptions.AuthorityNotFoundException;
import com.example.demo.model.Authorities;
import com.example.demo.repository.AuthoritiesRepository;
import com.example.demo.server.AuthoritiesService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {
    private final AuthoritiesRepository authoritiesRepository;

    public AuthoritiesServiceImpl(AuthoritiesRepository authoritiesRepository) {
        this.authoritiesRepository = authoritiesRepository;
    }

    @Override
    public Authorities getUsersAuthorities(UUID authorityId) {
        return authoritiesRepository.findById(authorityId).orElseThrow(() -> new AuthorityNotFoundException("Authority not found"));
    }
}
