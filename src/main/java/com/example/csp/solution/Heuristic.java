package com.example.csp.solution;

import com.example.csp.problem.CapacityConstraint;
import com.example.csp.problem.Course;
import com.example.csp.problem.TimeScheduleProblem;

import java.util.Comparator;

public class Heuristic {

    public static Course getMRV(TimeScheduleProblem csp){
        return csp.getConstraints().stream()
                .max(Comparator.comparingInt(CapacityConstraint::getSize))
                .get()
                .getCourse();
    }

    public static Course getLCV(TimeScheduleProblem csp){
        return csp.getConstraints().stream()
                .min(Comparator.comparingInt(CapacityConstraint::getSize))
                .get()
                .getCourse();
    }
}
