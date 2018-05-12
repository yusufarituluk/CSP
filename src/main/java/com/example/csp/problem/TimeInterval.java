package com.example.csp.problem;

import java.time.LocalTime;

public class TimeInterval implements Comparable<TimeInterval>{
    private final LocalTime from;
    private final LocalTime to;

    public TimeInterval(LocalTime from, LocalTime to) {
        this.from = from;
        this.to = to;
    }

    public LocalTime getFrom() {
        return from;
    }

    public LocalTime getTo() {
        return to;
    }

    @Override
    public int compareTo(TimeInterval o) {
        int result = this.getTo().compareTo(o.getTo());
        if(result == 0)
            return this.getFrom().compareTo(o.getFrom());
        return result;
    }
}
