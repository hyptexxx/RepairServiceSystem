package com.repairService.repairService.controller;

import com.repairService.repairService.enums.UserRoleEnum;
import com.repairService.repairService.model.User;
import com.repairService.repairService.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/api/v1/auth")
    public ResponseEntity<Object> authorize(@RequestParam("login") String login,
                                            @RequestParam("password") String password) throws IOException {
        User user = userRepository.findUser(login, password);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Set<GrantedAuthority> roles = new HashSet<>();

        roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));

        if (user != null) {
            Authentication auth =
                    new UsernamePasswordAuthenticationToken(login, passwordEncoder.encode(password), roles);
            SecurityContextHolder.getContext().setAuthentication(auth);

            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }


    }

    @PostMapping("/api/v1/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextHolder = new SecurityContextLogoutHandler();
        securityContextHolder.logout(request, response, null);
    }
}
