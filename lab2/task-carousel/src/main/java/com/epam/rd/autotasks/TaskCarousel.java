package com.epam.rd.autotasks;

import java.util.ArrayList;

public class TaskCarousel {
    private Task[] tasks;
    int capacity;
    int currantAmount=0;
    int currantIndx=0;
    public TaskCarousel(int capacity) {
        this.capacity=capacity;
        tasks = new Task[capacity];
    }
    private void iterate(){
        currantIndx= (currantIndx + 1 ) % capacity;
    }
    public boolean addTask(Task task) {
        if (task == null || task.isFinished())
            return false;
        if(currantAmount < capacity) {
            while (tasks[currantIndx] != null)
                iterate();
            tasks[currantIndx]=task;
            currantAmount++;
            return true;
        }
        return false;
    }

    public boolean execute() {
        if(isEmpty()) return false;
        iterate();
        while (tasks[currantIndx] == null)
            iterate();
        tasks[currantIndx].execute();
        if (tasks[currantIndx].isFinished()){
            tasks[currantIndx]=null;
            currantAmount--;

        }
        return true;

    }

    public boolean isFull() {
        return currantAmount==capacity;
    }

    public boolean isEmpty() {
        return currantAmount==0;
    }

}
