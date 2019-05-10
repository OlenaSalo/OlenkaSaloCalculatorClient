package com.epam.labTA.web.exception;

public class ResponseError extends Exception {
    public ResponseError(String errorMsg){
        super(errorMsg);
    }
}
