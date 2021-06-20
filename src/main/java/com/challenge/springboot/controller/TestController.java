package com.challenge.springboot.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/tests")
@RestController
public class TestController {

    @GetMapping("/all")
    public String allAccess(){
        return "Conteúdo Público :)";
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess(){
        return "Conteúdos só para usuários";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('Admin')")
    public String adminAccess(){
        return "Conteúdo só para admins";
    }
}
