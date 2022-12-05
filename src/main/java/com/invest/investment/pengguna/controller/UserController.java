package com.invest.investment.pengguna.controller;

import com.invest.investment.pengguna.dto.SigninDto;
import com.invest.investment.pengguna.dto.SigninResponseDto;
import com.invest.investment.pengguna.dto.SignupDto;
import com.invest.investment.pengguna.dto.SignupResponseDto;
import com.invest.investment.pengguna.exception.AuthenticationFailException;
import com.invest.investment.pengguna.exception.CustomException;
import com.invest.investment.pengguna.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public SignupResponseDto signUp(@RequestBody SignupDto signupDto) throws CustomException{
        return userService.signUp(signupDto);
    }

    @PostMapping("/signin")
    public SigninResponseDto signin(@RequestBody SigninDto signinDto) throws CustomException, AuthenticationFailException {
        return userService.signIn(signinDto);
    }
}
