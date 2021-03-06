package com.qiangliu8.exception;
//当用户的姓名有异常
public class NameException extends MyUserException{
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
