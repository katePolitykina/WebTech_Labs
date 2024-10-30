package com.epam.rd.autotasks;

public class HalvingCarouselRun extends CarouselRun{
    HalvingCarouselRun(int[] elements) {
        super(elements);
    }
    @Override
    public int next() {
        if(isFinished())
            return -1;
        while (elements[currentIndex] == 0)
            currentIndex = (currentIndex+1) % capacity;
        int res = elements[currentIndex];
        elements[currentIndex] /=2;
        currentIndex = (currentIndex+1) % capacity;
        return res;
    }
}
