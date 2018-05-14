package com.example.csp.problem;

import com.example.csp.exception.UnassignedValueNotFound;
import com.example.csp.model.Domain;
import com.example.csp.model.Variable;

import java.util.*;

public class Assignment {

    Map<Course, Classroom> assigments;

    public Assignment(List<Course> courses) {
        assigments = new HashMap<>();
        courses.forEach(c -> assigments.put(c, null));
    }

    public Assignment(Assignment assigment) {
        this.assigments = assigment.assigments;
    }

    public boolean hasAssignment(Variable var) {
        return assigments.get(var) != null;
    }

    public boolean assign(Course course, Classroom classroom) {
        if (!assigments.containsKey(course))
            return false;
        boolean result = this.assigments.entrySet().stream()
                .filter(e -> e.getValue() == classroom)
                .noneMatch(e -> e.getKey().isConflicted(course));
        if (result)
            assigments.put(course, classroom);
        return result;
    }

    public Classroom getValue(Course course) {
        return assigments.get(course);
    }

    public boolean isCompleted() {
        return assigments.entrySet().stream().noneMatch(e -> e.getValue() == null);
    }

    public boolean isConsistent(TimeScheduleProblem csp, Course course, Classroom classroom) {
        return csp.getVariables().stream()
                .filter(v -> v.isConflicted(course))
                .map(this::getValue)
                .filter(c -> c != null)
                .noneMatch(c -> c == classroom);
    }

    public Course selectUnassignedVariable() {
        return this.assigments.entrySet().stream()
                .filter(e -> e.getValue() == null)
                .map(e -> e.getKey())
                .findFirst()
                .orElseThrow(UnassignedValueNotFound::new);
    }

    public Map<Course, Classroom> getAssigments() {
        return Collections.unmodifiableMap(assigments);
    }

    @Override
    public String toString() {
        return "Assigments => " + assigments;
    }
}
