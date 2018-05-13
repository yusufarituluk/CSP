package com.example.csp.exception;

public class UnassignedValueNotFound extends RuntimeException {

    public UnassignedValueNotFound(){
        super("There is no unassigned value");
    }

}