package com.weather.exception;



public class InvalidDateException extends RuntimeException{
    public InvalidDateException(String message){
        super(message);
    }
}
