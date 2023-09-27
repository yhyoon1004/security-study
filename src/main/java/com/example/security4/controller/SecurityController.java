package com.example.security4.controller;

import com.example.security4.dto.UserForm;
import com.example.security4.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class SecurityController {
    private final UserDetailsServiceImpl userDetailsServiceImple;

    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @ResponseBody
    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @ResponseBody
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @ResponseBody
    @GetMapping("/manager")
    public String manager() {
        return "manager";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join")
    public ResponseEntity join(@RequestBody UserForm userForm) {
        String status = "excuted";
        userDetailsServiceImple.enrollUser(userForm);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "loginPage";
    }
}
