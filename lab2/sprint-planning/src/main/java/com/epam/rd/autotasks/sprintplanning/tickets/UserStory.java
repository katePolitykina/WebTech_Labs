package com.epam.rd.autotasks.sprintplanning.tickets;

import java.util.Arrays;

public class UserStory extends Ticket {
    private final UserStory [] dependencies;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        dependencies = dependsOn;
    }

    private boolean isDependenciesComplited(UserStory userStory){
        UserStory [] usDependencies = userStory.getDependencies();
        for (UserStory dependency: usDependencies) {
            if (!isDependenciesComplited(dependency))
                return false;
        }
        if (userStory.isCompleted())
            return true;
        else return false;

    }
    @Override
    public void complete() {
        for (UserStory dependency: this.getDependencies()) {
            if(!dependency.isCompleted())
                return ;
        }
        super.complete();

    }

    public UserStory[] getDependencies() {
        return Arrays.copyOf(dependencies, dependencies.length);
    }

    @Override
    public String toString() {
        return  "[US " + getId() + "] " + getName();
    }
}
