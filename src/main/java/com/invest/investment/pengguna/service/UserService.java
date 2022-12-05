package com.invest.investment.pengguna.service;

import com.invest.investment.pengguna.dto.SigninDto;
import com.invest.investment.pengguna.dto.SigninResponseDto;
import com.invest.investment.pengguna.dto.SignupDto;
import com.invest.investment.pengguna.dto.SignupResponseDto;
import com.invest.investment.pengguna.exception.AuthenticationFailException;
import com.invest.investment.pengguna.exception.CustomException;
import com.invest.investment.pengguna.exception.MessageStrings;
import com.invest.investment.pengguna.model.AuthenticationToken;
import com.invest.investment.pengguna.model.User;
import com.invest.investment.pengguna.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationService authenticationService;


    public SignupResponseDto signUp(SignupDto signupDto) throws CustomException{
        if (Objects.nonNull((userRepository.findByEmail(signupDto.getEmail())))){
            throw new CustomException("User already exists");
        }

        User user = new User(signupDto.getFirstName(), signupDto.getLastName(), signupDto.getEmail(), signupDto.getPassword());

        try {
            userRepository.save(user);
            final AuthenticationToken authenticationToken = new AuthenticationToken(user);
            authenticationService.saveConfirmationToken(authenticationToken);
            return new SignupResponseDto("success", "user created successfully");
        } catch (Exception e){
            throw new CustomException(e.getMessage());
        }
    }


    public SigninResponseDto signIn(SigninDto signinDto) throws AuthenticationFailException, CustomException{

        User user = userRepository.findByEmail((signinDto.getEmail()));
        if(!Objects.nonNull(user)){
            throw new AuthenticationFailException("user not present");
        }

        try {
            if(!user.getPassword().equals(signinDto.getPassword())){
                throw new AuthenticationFailException(MessageStrings.WRONG_PASSWORD);
            }
        } catch (Exception e){
            throw new CustomException(e.getMessage());
        }

        AuthenticationToken token = authenticationService.getToken(user);

        if(!Objects.nonNull(token)){
            throw new CustomException(MessageStrings.AUTH_TOKEN_NOT_PRESENT);
        }

        return new SigninResponseDto("success", token.getToken());
    }
}
