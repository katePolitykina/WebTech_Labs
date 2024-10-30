package com.epam.rd.autotasks;

public class GraduallyDecreasingCarouselRun extends CarouselRun{
    private int round =1;
    GraduallyDecreasingCarouselRun(int[] elements) {
        super(elements);
    }
    @Override
    public int next() {
        if(isFinished())
            return -1;
        while (elements[currentIndex] <= 0){
            currentIndex++;
            if (currentIndex == capacity){
                currentIndex = 0;
                round++;
            }
        }
        int res = elements[currentIndex];
        elements[currentIndex]-=round;
        currentIndex++;
        if (currentIndex == capacity){
            currentIndex = 0;
            round++;
        }
        return res;
    }
}
