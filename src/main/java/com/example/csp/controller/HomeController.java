package com.example.csp.controller;


import com.example.csp.problem.Assignment;
import com.example.csp.problem.TimeScheduleProblem;
import com.example.csp.solution.Backtracking;
import com.example.csp.solution.ForwardChecking;
import com.example.csp.solution.Heuristic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    TimeScheduleProblem timeScheduleProblem;

    @RequestMapping(value={"/","/Home"})
    public String home() {
        return "Home";
    }

    @RequestMapping("/Backtracking")
    public String getBacktracking(Model model) {
        Assignment backtrackingAssignment = new Assignment(timeScheduleProblem.getVariables());
        Backtracking backtracking = new Backtracking(timeScheduleProblem);
        Assignment backtrackingSolution = backtracking.solve(backtrackingAssignment);
        model.addAttribute("assignments", backtrackingSolution.getAssigments());
        model.addAttribute("result", (backtrackingSolution.isCompleted() && timeScheduleProblem.checkConstraints(backtrackingSolution)));
        return "Backtracking";
    }

    @RequestMapping("/ForwardChecking")
    public String getForwardChecking(Model model) {
        Assignment forwardCheckingAssignment = new Assignment(timeScheduleProblem.getVariables());
        ForwardChecking forwardChecking = new ForwardChecking(timeScheduleProblem);
        Assignment forwardCheckingSolution = forwardChecking.solve(forwardCheckingAssignment);
        model.addAttribute("assignments", forwardCheckingSolution.getAssigments());
        model.addAttribute("result", (forwardCheckingSolution.isCompleted() && timeScheduleProblem.checkConstraints(forwardCheckingSolution)));
        return "ForwardChecking";
    }

    @RequestMapping("/Heuristics")
    public String getHeuristics(Model model) {
        model.addAttribute("mrv", Heuristic.getMRV(timeScheduleProblem).toString());
        model.addAttribute("lcv", Heuristic.getLCV(timeScheduleProblem).toString());
        return "Heuristics";
    }

    @RequestMapping("/ConstraintGraph")
    public String getConstraintGraph(Model model) {
        TimeScheduleProblem.Graph graph =timeScheduleProblem.getGraph();
        model.addAttribute("graph", graph);
        return "ConstraintGraph";
    }

}
