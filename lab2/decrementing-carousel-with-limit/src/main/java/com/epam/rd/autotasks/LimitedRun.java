package com.epam.rd.autotasks;

public class LimitedRun extends CarouselRun{
    private int actionLimit;
    LimitedRun(int[] elements, int actionLimit) {
        super(elements);
        this.actionLimit = actionLimit;
    }
    public int next() {
        if(isFinished())
            return -1;
        actionLimit --;
        while (elements[currentIndex] <= 0)
            currentIndex = (currentIndex+1) % capacity;
        int res = elements[currentIndex]--;
        currentIndex = (currentIndex+1) % capacity;

        if (actionLimit <= 0){
            finished = true;
        }
        return res;

    }
}
