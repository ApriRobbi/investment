package com.invest.investment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND) // coba buka materi
public class TidakKetemuException extends RuntimeException{
        public TidakKetemuException(String pesan){
                super(pesan);
        }
}
