package com.example.csp.solution;

import com.example.csp.problem.Assignment;
import com.example.csp.problem.Classroom;
import com.example.csp.problem.Course;
import com.example.csp.problem.TimeScheduleProblem;

import java.util.LinkedList;
import java.util.Queue;

public class Backtracking {

    private TimeScheduleProblem csp;

    private Queue<Assignment> infrences = new LinkedList();

    public Backtracking(TimeScheduleProblem csp) {
        this.csp = csp;
    }

    public Assignment solve(Assignment assignment) {
        return solveInLoop(this.csp, assignment);
    }

    private Assignment solveInLoop(TimeScheduleProblem csp, Assignment assignment) {
        if (assignment.isCompleted())
            return assignment;
        Course course = assignment.selectUnassignedVariable();
        for (Classroom classroom : csp.getDomains()) {
            if(assignment.isConsistent(csp, course, classroom)) {
                assignment.assign(course, classroom);
                infrences.add(new Assignment(assignment));
                if (csp.getConstraints().stream().allMatch(c -> c.isSatisfied(assignment))) {
                    return solveInLoop(csp, assignment);
                }
            }
        }
        return infrences.poll();
    }
}
