package com.invest.investment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PermintaanTidakDikabulkanException extends RuntimeException{
    public PermintaanTidakDikabulkanException(String pesan){
        super(pesan);
    }
}
