package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {
    private int id ;
    private String name;
    private int estimate;
    private boolean isCompleted = false;

    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void complete() {
        isCompleted = true;
    }

    public int getEstimate() {
        return estimate;
    }
}
