package com.example.csp.problem;

import com.example.csp.model.Domain;

public class Classroom implements Domain {
    private final String name;

    public Classroom(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
