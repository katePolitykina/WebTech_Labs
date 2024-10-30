package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    private int actionLimit;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
    }
    public CarouselRun run(){
        if (isRunning)
            return null;
        isRunning = true;
        return new LimitedRun(elements, actionLimit);
    }
}
