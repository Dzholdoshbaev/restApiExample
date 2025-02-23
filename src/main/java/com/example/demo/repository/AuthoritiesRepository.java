package com.example.demo.repository;

import com.example.demo.model.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, UUID> {
}
