package com.example.csp.solution;

import com.example.csp.problem.Assignment;
import com.example.csp.problem.Classroom;
import com.example.csp.problem.Course;
import com.example.csp.problem.TimeScheduleProblem;

import java.util.LinkedList;
import java.util.Queue;

public class Backtracking {

    private Queue<Assignment> infrences = new LinkedList();

    public Assignment solve(TimeScheduleProblem csp, Assignment assignment) {
        if (assignment.isCompleted())
            return assignment;
        Course course = assignment.selectUnassignedVariable();
        for (Classroom classroom : csp.getDomains()) {
            if(assignment.isConsistent(csp, course, classroom)) {
                assignment.assign(course, classroom);
                infrences.add(new Assignment(assignment));
                if (csp.getConstraints().stream().allMatch(c -> c.isSatisfied(assignment))) {
                    return solve(csp, assignment);
                }
            }
        }
        return infrences.poll();
    }
}
