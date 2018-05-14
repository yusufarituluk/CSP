package com.example.csp;

import com.example.csp.problem.Assignment;
import com.example.csp.solution.ForwardChecking;
import com.example.csp.solution.Heuristic;
import com.example.csp.problem.TimeScheduleProblem;
import com.example.csp.solution.Backtracking;

//@SpringBootApplication
public class CspApplication {

    public static void main(String[] args) {
        //SpringApplication.run(CspApplication.class, args);

        /**
        * Initialization of the problem
        */
        TimeScheduleProblem timeScheduleProblem = new TimeScheduleProblem();


        /**
         * Apply backtracking algorithm
         */
//        Assignment backtrackingAssignment = new Assignment(timeScheduleProblem.getVariables());
//        Backtracking backtracking = new Backtracking(timeScheduleProblem);
//        Assignment backtrackingSolution = backtracking.solve(backtrackingAssignment);
//        System.out.println(backtrackingSolution.toString());


        /**
         * Diplay Heuristics of the problem
         */
        //System.out.println("Minimum Remaining Value : " + Heuristic.getMRV(timeScheduleProblem));
        //System.out.println("Least Constraining Value : " + Heuristic.getLCV(timeScheduleProblem));



        /**
         * Apply forward checking algoritm
         */
        Assignment forwardCheckingAssignment = new Assignment(timeScheduleProblem.getVariables());
        ForwardChecking forwardChecking = new ForwardChecking(timeScheduleProblem);
        Assignment forwardCheckingSolution = forwardChecking.solve(forwardCheckingAssignment);
        System.out.println(forwardCheckingSolution.toString());


        /**
         * Displaying constraint graph of the problem
         */
        //timeScheduleProblem.displaConstraintGraph();

    }
}
