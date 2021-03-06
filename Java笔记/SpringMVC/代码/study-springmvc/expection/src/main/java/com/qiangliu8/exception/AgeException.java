package com.qiangliu8.exception;
//当用户的年龄有异常
public class AgeException extends MyUserException{
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
