package com.example.csp.problem;

import com.example.csp.model.Domain;
import com.example.csp.model.Variable;

import java.util.*;

public class Assignment {

    Map<Variable, Domain> assigments;

    public Assignment() {
        assigments = new HashMap<>();
    }

    public boolean hasAssignment(Variable var) {
        return assigments.get(var) != null;
    }


    public void assign(Variable variable, Domain domain) {
    }

    public void unassign(Variable variable) {

    }
}
