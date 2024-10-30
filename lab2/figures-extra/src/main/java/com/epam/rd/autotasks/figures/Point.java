package com.epam.rd.autotasks.figures;

class Point {
    private double x;
    private double y;
    final double EPSILON = 1e-9;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public boolean arePointsEqual( Point other) {
        return Math.abs(x - other.x) < EPSILON && Math.abs(y - other.y) < EPSILON;
    }

}
