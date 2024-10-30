package com.epam.rd.autotasks.figures;

class Triangle extends Figure{
    private static final int POINTS_AMOUNT = 3;
    private Point[] points = new Point[POINTS_AMOUNT];
    public Triangle (Point a, Point b, Point c){
        points[0]=a;
        points[1]=b;
        points[2]=c;
    }
    @Override
    public double area() {
        return 0.5 * Math.abs(
                points[0].getX() * (points[1].getY() - points[2].getY()) +
                        points[1].getX() * (points[2].getY() - points[0].getY()) +
                        points[2].getX() * (points[0].getY() - points[1].getY())
        );
    }

    @Override
    public String pointsToString() {
        return pointsToString(points);
    }

    @Override
    public Point leftmostPoint() {
       return leftmostPoint(points);
    }
}
