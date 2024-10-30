package com.epam.rd.autotasks.segments;

class Point {
    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals ( Point other){
        if (other == null)
            return false;
        if (x == other.x && y == other.y)
            return true;
        else return false;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
