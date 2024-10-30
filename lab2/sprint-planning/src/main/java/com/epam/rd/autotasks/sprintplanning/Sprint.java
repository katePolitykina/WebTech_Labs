package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;

public class Sprint {
    int estimate, ticketsLimit;
    int currentTicketsAmount =0;
    boolean isFull = false;
    Ticket []tickets ;
    public Sprint(int capacity, int ticketsLimit) {
        estimate = capacity;
        this.ticketsLimit = ticketsLimit;
        tickets = new Ticket[ticketsLimit];
    }

    public boolean addUserStory(UserStory userStory) {
        if (isFull || userStory == null
             || userStory.getEstimate()>estimate || userStory.isCompleted())
            return false;
        for (UserStory dependency: userStory.getDependencies()) {
            boolean dependencyFound = false;
            for (int i = 0; i < currentTicketsAmount; i++) {
                if (tickets[i]==dependency){
                    dependencyFound = true;
                    break;
                }
            }
            if(!dependencyFound)
                return false;
        }
        tickets[currentTicketsAmount++]=userStory;
        estimate -= userStory.getEstimate();
        if(currentTicketsAmount == ticketsLimit || estimate == 0)
            isFull = true;

        return true;

    }

    public boolean addBug(Bug bugReport) {
        if (isFull|| bugReport == null 
                || bugReport.getEstimate()>estimate || bugReport.isCompleted())
            return false;
        tickets[currentTicketsAmount++]=bugReport;
        estimate -= bugReport.getEstimate();
        if(currentTicketsAmount == ticketsLimit || estimate == 0)
            isFull = true;
        return true;
    }

    public Ticket[] getTickets() {
        return Arrays.copyOf(tickets,currentTicketsAmount);
    }

    public int getTotalEstimate() {
        int summ = 0;
        for (int i = 0; i < currentTicketsAmount; i++) {
            summ += tickets[i].getEstimate();
        }
        return summ;
    }
}
