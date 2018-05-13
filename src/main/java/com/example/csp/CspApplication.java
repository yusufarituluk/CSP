package com.example.csp;

import com.example.csp.problem.Assignment;
import com.example.csp.problem.TimeScheduleProblem;
import com.example.csp.solution.Backtracking;

//@SpringBootApplication
public class CspApplication {

    public static void main(String[] args) {
        //SpringApplication.run(CspApplication.class, args);
        TimeScheduleProblem timeScheduleProblem = new TimeScheduleProblem();
        Assignment startState = new Assignment(timeScheduleProblem.getVariables());


        // App
        Backtracking backtracking = new Backtracking();
        Assignment endState = backtracking.solve(timeScheduleProblem, startState);
        System.out.print(endState.toString());

        //timeScheduleProblem.displaConstraintGraph();

    }
}
