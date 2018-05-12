package com.example.csp.problem;

import com.example.csp.model.Constraint;

public class TimeConstraint implements Constraint {

    //If there is a time confict, the coinstraint is not stisfied

    Course firstCourse;

    Course secondCourse;

    public TimeConstraint(Course firstCourse, Course secondCourse) {
        this.firstCourse=firstCourse;
        this.secondCourse=secondCourse;
    }

    @Override
    public Boolean isSatisfied(Assignment assignment) {
        return true;
    }
}
