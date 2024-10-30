package com.epam.rd.autotasks.figures;

abstract class Figure{

    public abstract double area();

    public abstract String pointsToString();
    protected String pointsToString(Point[] points){
        String res = "";
        for (int i = 0; i < points.length; i++) {
            res += String.format("(%s,%s)", points[i].getX(), points[i].getY());
        }
        return res;
    }

    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    public abstract Point leftmostPoint();
    protected Point leftmostPoint(Point[] points){
        if (points == null)
            return null;
        Point leftmost = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i].getX() < leftmost.getX()) leftmost = points[i];
        }
        return leftmost;
    }

}
