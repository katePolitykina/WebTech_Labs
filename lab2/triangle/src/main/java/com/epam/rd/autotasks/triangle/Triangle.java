package com.epam.rd.autotasks.triangle;

import static java.lang.Math.abs;

class Triangle {
    private Point a, b, c;
    double EPSILON = 1e-8;
    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null)
            throw new IllegalArgumentException();

        if ( a.equals(b) || b.equals(c) || c.equals(a))
            throw new IllegalArgumentException();

        double determinant = (b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY()) * (c.getX() - a.getX());
        if (Math.abs(determinant) < EPSILON) {
            throw new IllegalArgumentException();
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double res = 0.5 * ( a.getX()*b.getY() - b.getX()*a.getY() +
                             b.getX()*c.getY() - c.getX()*b.getY() +
                             c.getX()*a.getY() - a.getX()*c.getY() );
        return abs(res);
    }

    public Point centroid(){
        double x = ( a.getX() + b.getX() + c.getX() ) / 3;
        double y = ( a.getY() + b.getY() + c.getY() ) / 3;
        return new Point(x, y);
    }

}
