package com.example.csp.problem;

import com.example.csp.model.CSP;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TimeScheduleProblem extends CSP<Course, Classroom, CapacityConstraint>  {

    private Ma

    public TimeScheduleProblem() {
        generate();

    }

    public

    public void generate() {
        TimeInterval timeInterval1 = new TimeInterval(LocalTime.parse("08:00:00"), LocalTime.parse("08:30:00"));
        TimeInterval timeInterval2 = new TimeInterval(LocalTime.parse("08:30:00"), LocalTime.parse("09:00:00"));
        TimeInterval timeInterval3 = new TimeInterval(LocalTime.parse("09:00:00"), LocalTime.parse("09:30:00"));
        TimeInterval timeInterval4 = new TimeInterval(LocalTime.parse("09:30:00"), LocalTime.parse("10:00:00"));
        TimeInterval timeInterval5 = new TimeInterval(LocalTime.parse("10:00:00"), LocalTime.parse("10:30:00"));


        List<TimeInterval> timeIntervals = new ArrayList<>();
        timeIntervals.add(timeInterval1);
        timeIntervals.add(timeInterval2);
        timeIntervals.add(timeInterval3);
        timeIntervals.add(timeInterval4);
        timeIntervals.add(timeInterval5);

        Course course1 = new Course("C1", "Class 1", "Intro to Programming");
        Course course2 = new Course("C2", "Class 2", "Intro to Artificial Intelligence");
        Course course3 = new Course("C3", "Class 3", "Image Processing");
        Course course4 = new Course("C4", "Class 4", "Databases");
        Course course5 = new Course("C5", "Class 5", "Computer Organization");

        //C1 - 8:00 - 9:00
        course1.addTime(timeInterval1);
        course1.addTime(timeInterval2);
        //C2 - 8:30 - 9:30
        course2.addTime(timeInterval2);
        course2.addTime(timeInterval3);
        //C3 - 9:00 - 10:00
        course3.addTime(timeInterval3);
        course3.addTime(timeInterval4);
        //C4 - 9:00 - 10:00
        course4.addTime(timeInterval3);
        course4.addTime(timeInterval4);
        //C5 - 9:30 - 10:30
        course5.addTime(timeInterval4);
        course5.addTime(timeInterval5);

        List<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        this.variables = courses;


        Classroom classroomA01 = new Classroom("A01");
        Classroom classroomB01 = new Classroom("B01");
        Classroom classroomC01 = new Classroom("C01");

        List<Classroom> classrooms = new ArrayList<>();
        classrooms.add(classroomA01);
        classrooms.add(classroomB01);
        classrooms.add(classroomC01);
        this.domains = classrooms;

        CapacityConstraint constraint1 = new CapacityConstraint(course1,  classroomC01);

        CapacityConstraint constraint2 = new CapacityConstraint(course2,  classroomB01);
        CapacityConstraint constraint3 = new CapacityConstraint(course2,  classroomC01);

        CapacityConstraint constraint4 = new CapacityConstraint(course3,  classroomA01);
        CapacityConstraint constraint5 = new CapacityConstraint(course3,  classroomB01);
        CapacityConstraint constraint6 = new CapacityConstraint(course3,  classroomC01);

        CapacityConstraint constraint7 = new CapacityConstraint(course4,  classroomA01);
        CapacityConstraint constraint8 = new CapacityConstraint(course4,  classroomB01);
        CapacityConstraint constraint9 = new CapacityConstraint(course4,  classroomC01);

        CapacityConstraint constraint10 = new CapacityConstraint(course5,  classroomB01);
        CapacityConstraint constraint11 = new CapacityConstraint(course5,  classroomC01);


        List<CapacityConstraint> constraints = new ArrayList<>();
        constraints.add(constraint1);
        constraints.add(constraint2);
        constraints.add(constraint3);
        constraints.add(constraint4);
        constraints.add(constraint5);
        constraints.add(constraint6);
        constraints.add(constraint7);
        constraints.add(constraint8);
        constraints.add(constraint9);
        constraints.add(constraint10);
        constraints.add(constraint11);
        this.constraints = constraints;
    }

}
