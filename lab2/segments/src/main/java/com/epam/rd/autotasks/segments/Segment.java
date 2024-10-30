package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    private final Point start, end;
    final double EPSILON = 1e-9;
    public Point getStart(){
        return this.start;
    }

    public Point getEnd() {
        return end;
    }

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
        if (start == null || end == null || start.equals(end))
            throw new IllegalArgumentException();

    }

    double length() {
        double length =Math.sqrt( Math.pow((start.getX()-end.getX()),2) + Math.pow((start.getY()-end.getY()),2));
        return length;
    }

    Point middle() {

       double midX= (start.getX()+end.getX()) / 2;
       double midY= (start.getY()+end.getY()) / 2;

       return new Point(midX, midY);
    }

    Point intersection(Segment another) {
        double denominator =  (start.getX() - end.getX()) * (another.start.getY() - another.end.getY())
                - (start.getY() - end.getY()) * (another.start.getX() - another.end.getX());

        if (abs(denominator) < EPSILON) // Проверка на параллельные или совпадающие линии
            return null;

        double numeratorT = (start.getX() - another.start.getX()) * (another.start.getY() - another.end.getY())
                - (start.getY() - another.start.getY()) * (another.start.getX() - another.end.getX());
        double numeratorU = (start.getX() - end.getX()) * (start.getY() - another.start.getY())
                - (start.getY() - end.getY()) * (start.getX() - another.start.getX());

        double t = numeratorT / denominator;
        double u = -numeratorU / denominator;

        if (t >= -EPSILON && t <= 1 + EPSILON && u >= -EPSILON && u <= 1 + EPSILON) {
            // Правильное вычисление координат пересечения
            double px = start.getX() + t * (end.getX() - start.getX());
            double py = start.getY() + t * (end.getY() - start.getY());
            return new Point(px, py);
        } else {
            return null;
        }
    }

}
