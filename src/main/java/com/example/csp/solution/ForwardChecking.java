package com.example.csp.solution;

import com.example.csp.problem.*;

import java.util.*;
import java.util.stream.Collectors;

public class ForwardChecking {

    private TimeScheduleProblem csp;
    private Map<Course, List<Classroom>> modifiedDomains;

    public ForwardChecking(final TimeScheduleProblem csp) {
        this.csp = csp;
        this.modifiedDomains = csp.getVariables().stream()
                .collect(Collectors.toMap(x -> x, x -> csp.getDomains()));
    }

    public Assignment solve(Assignment assignment) {
        for (Course courseX : csp.getVariables()) {
            if(!assignment.hasAssignment(courseX)) {
                assignment.assign(courseX, selectValue(csp.getConstraints(), assignment, courseX));
                csp.getVariables().stream()
                        .filter(c -> c.isConflicted(courseX))
                        .filter(c -> assignment.getValue(c) == null)
                        .forEach(courseY ->
                                modifiedDomains.put(courseY, modifiedDomains.get(courseY).stream()
                                        .filter(d -> assignment.isConsistent(csp, courseY, d))
                                        .collect(Collectors.toList())));
            }
        }

        return assignment;
    }

    private Classroom selectValue(List<CapacityConstraint> constraints, Assignment assignment, Course course){
        return modifiedDomains.get(course)
                .stream()
                .filter(classroom -> {
                    Assignment temp = new Assignment(assignment);
                    temp.assign(course, classroom);
                    return  constraints.stream().allMatch(c -> c.isSatisfied(temp));
                })
                .findFirst()
                .orElse(null);
    }

}
