package io.security.corespringsecurity.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MessageController {

//    private final PasswordEncoder passwordEncoder;

    @GetMapping(value="/messages")
    public String messages() throws Exception {
        return "user/messages";
    }

    @PostMapping("/api/messages")
    @ResponseBody
    public String apiMessage() {
        return "5k";
    }

}
