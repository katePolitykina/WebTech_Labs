package com.epam.rd.autotasks;

public class CarouselRun {
    protected int [] elements;
    protected final int capacity;
    protected int currentIndex = 0;
    private boolean finished = false;
    CarouselRun(int[] elements){
        this.elements = elements;
        capacity = elements.length;
    }

    public int next() {
        if(isFinished())
            return -1;
        while (elements[currentIndex] == 0)
            currentIndex = (currentIndex+1) % capacity;
        int res = elements[currentIndex]--;
        currentIndex = (currentIndex+1) % capacity;
        return res;
    }

    public boolean isFinished() {
        if (finished)
            return true;
        for (int i = 0; i <capacity; i++) {
            if(elements[i]>0) return false;
        }
        finished = true;
        return true;
    }

}

