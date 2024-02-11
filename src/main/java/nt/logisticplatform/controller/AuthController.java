package nt.logisticplatform.controller;

import io.swagger.v3.oas.annotations.Operation;
import nt.logisticplatform.model.AuthDTO;
import nt.logisticplatform.model.AuthInfo;
import nt.logisticplatform.model.RegisterDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/auth")
public interface AuthController {
    @PostMapping("/register")
    @Transactional
    @Operation(tags = {"Authentication"}, summary = "Register")
    AuthInfo register(@RequestBody RegisterDTO registerDTO);

    @PostMapping("/login")
    @Transactional
    @Operation(tags = {"Authentication"}, summary = "Login")
    AuthInfo login(@RequestBody AuthDTO authDTO);
}
