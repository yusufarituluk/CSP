package com.example.csp.problem;

import com.example.csp.model.Constraint;

public class CapacityConstraint implements Constraint {

    Course course;

    Classroom classroom;

    public CapacityConstraint(Course course, Classroom classroom) {
        this.course=course;
        this.classroom=classroom;
    }

    @Override
    public Boolean isSatisfied(Assignment assignment) {
        return null;
    }
}
