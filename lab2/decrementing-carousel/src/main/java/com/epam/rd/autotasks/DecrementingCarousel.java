package com.epam.rd.autotasks;

public class DecrementingCarousel {
    private final int[] elements;
    private int currentIndex = 0;
    private boolean isRunning = false;

    public DecrementingCarousel(int capacity) {
        if (capacity>0){
            elements = new int[capacity];
        }else
            throw new IllegalArgumentException();
    }

    public boolean addElement(int element){
        if (isRunning)
            return false;
        if (element <=0 || currentIndex == elements.length)
            return false;
        elements[currentIndex++]= element;
        return true;
    }

    public CarouselRun run(){
        if (isRunning)
            return null;
        isRunning = true;
        return new CarouselRun(elements);
    }
}
