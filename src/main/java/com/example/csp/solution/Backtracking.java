package com.example.csp.solution;

import com.example.csp.problem.Assignment;
import com.example.csp.problem.Classroom;
import com.example.csp.problem.Course;
import com.example.csp.problem.TimeScheduleProblem;
import java.util.Stack;

public class Backtracking {

    private TimeScheduleProblem csp;

    private Stack<Assignment> infrences = new Stack<>();

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
                infrences.push(new Assignment(assignment));
                if (csp.checkConstraints(assignment)) {
                    assignment = solveInLoop(csp, assignment);
                    if(assignment.isCompleted()) return  assignment;
                }
                else{
                    infrences.pop();
                }
            }
        }
        return !infrences.empty() ? infrences.pop() : assignment;
    }
}
