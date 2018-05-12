package com.example.csp.problem;


import com.example.csp.model.Variable;

import java.util.ArrayList;
import java.util.List;


public class Course implements Variable {
    private String name;
    private String className;
    private String description;

    private List<TimeInterval> timeIntervals = new ArrayList<>();

    public Course(String name, String className, String description) {
        this.name = name;
        this.className = className;
        this.description = description;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addTime(TimeInterval timeInterval){
        this.timeIntervals.add(timeInterval);
    }

    public List<TimeInterval> getTimeIntervals() {
        return timeIntervals;
    }
}
