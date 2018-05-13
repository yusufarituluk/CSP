package com.example.csp.problem;

import com.example.csp.model.Constraint;

import java.util.List;

public class CapacityConstraint implements Constraint {

    Course course;

    List<Classroom> classrooms;

    public CapacityConstraint(Course course, List<Classroom> classrooms) {
        this.course=course;
        this.classrooms=classrooms;
    }

    @Override
    public Boolean isSatisfied(Assignment assignment) {
        Classroom classroom =  assignment.getValue(this.course);
        return classroom==null ||  classrooms.contains(classroom);
    }
}
