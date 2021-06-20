package com.challenge.springboot.repository;

import com.challenge.springboot.model.ERole;
import com.challenge.springboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findAllByName(ERole name);
}
