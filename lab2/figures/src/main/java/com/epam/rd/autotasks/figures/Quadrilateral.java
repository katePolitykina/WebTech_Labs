package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure
{
    private static final int POINTS_AMOUNT = 4;
    private Point[] points = new Point[POINTS_AMOUNT];
    public Quadrilateral(Point a, Point b, Point c, Point d){
        points[0]=a;
        points[1]=b;
        points[2]=c;
        points[3]=d;
    }


    @Override
    public double area() {

        return new Triangle(points[0], points[1], points[3]).area() + new Triangle(points[3], points[1], points[2]).area();
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
