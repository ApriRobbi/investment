package com.invest.investment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerError extends RuntimeException{
    public ServerError(String pesan){
        super(pesan);
    }
}
