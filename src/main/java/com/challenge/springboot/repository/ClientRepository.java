package com.challenge.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.springboot.model.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
