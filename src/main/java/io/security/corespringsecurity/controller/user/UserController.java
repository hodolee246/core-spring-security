package io.security.corespringsecurity.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

//    private final PasswordEncoder passwordEncoder;

    @GetMapping("/users")
    public String createUser() throws Exception {
        return "user/login/register";
    }

}
