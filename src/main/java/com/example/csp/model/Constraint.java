package com.example.csp.model;

import com.example.csp.problem.Assignment;

public interface Constraint {
    Boolean isSatisfied(Assignment assignment);
}
