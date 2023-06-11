package com.github.blackchronos.foodspect_back.core.acount.controller;

import com.github.blackchronos.foodspect_back.core.acount.AccountService;
import com.github.blackchronos.foodspect_back.core.acount.model.AccountToken;
import com.github.blackchronos.foodspect_back.core.acount.model.AccountType;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class SignUpController {
    private final AccountService accountService;

    @MessageMapping("signUp")
    @PreAuthorize("isAnonymous()")
    public Mono<AccountToken> signUp(@RequestBody SignUpRequest request) {
        return this.accountService.create(request.username.toLowerCase(), request.password, AccountType.USER)
                .flatMap(account -> this.accountService.getToken(account, true));
    }

    public record SignUpRequest(String username, String password) {
    }
}