package com.challenge.springboot.controller;

import com.challenge.springboot.model.ERole;
import com.challenge.springboot.model.Role;
import com.challenge.springboot.model.User;
import com.challenge.springboot.payload.request.LoginRequest;
import com.challenge.springboot.payload.request.SignupRequest;
import com.challenge.springboot.payload.response.JwtResponse;
import com.challenge.springboot.payload.response.MessageResponse;
import com.challenge.springboot.repository.RoleRepository;
import com.challenge.springboot.repository.UserRepository;
import com.challenge.springboot.security.jwt.JwtUtils;
import com.challenge.springboot.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser (@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String > roles = userDetails.getAuthorities().stream()
                .map(item ->item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                                                    userDetails.getId(),
                                                    userDetails.getUsername(),
                                                    userDetails.getEmail(),
                                                    roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser (@RequestBody SignupRequest signupRequest){

        if (userRepository.existsByUsername(signupRequest.getUsername())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Erro: O usuário já existe"));
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Erro: O email já está sendo utilizado"));
        }

        //Criando o usuário
        User user = new User(signupRequest.getUsername(),
                            signupRequest.getEmail(),
                            encoder.encode(signupRequest.getPassword()));

        Set<String> strRoles = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null){
            Role userRole = roleRepository.findAllByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Erro, Role not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role){
                    case "admin":
                        Role adminRole = roleRepository.findAllByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Erro, Role not found."));
                        roles.add(adminRole);
                        break;
                    default:
                        Role userRole = roleRepository.findAllByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Erro, Role not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok( new MessageResponse("Usuário Criado com sucesso "));
    }
}
