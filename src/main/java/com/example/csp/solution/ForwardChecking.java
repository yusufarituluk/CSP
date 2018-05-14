package com.example.csp.solution;

import com.example.csp.problem.Assignment;
import com.example.csp.problem.Classroom;
import com.example.csp.problem.Course;
import com.example.csp.problem.TimeScheduleProblem;

import java.util.Collections;
import java.util.List;
import java.util.Map;
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
            for (Classroom classroom : modifiedDomains.get(courseX)) {
                assignment.assign(courseX, classroom);
                csp.getVariables().stream()
                        .filter(c -> c.isConflicted(courseX))
                        .filter(c -> modifiedDomains.size() > 1)
                        .forEach(courseY -> {
                            List<Classroom> classrooms = modifiedDomains.get(courseY);
                            classrooms.forEach(d -> {
                                        if (assignment.isConsistent(csp, courseY, d)) {
                                            modifiedDomains.get(courseY).remove(d);
                                        }
                                    });
                        });
            }
        }
        return assignment;
    }

}
