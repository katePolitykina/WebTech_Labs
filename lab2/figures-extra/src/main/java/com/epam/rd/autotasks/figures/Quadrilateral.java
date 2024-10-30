package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure{
    private static final int POINTS_AMOUNT = 4;
    private Point[] points = new Point[POINTS_AMOUNT];
    public Quadrilateral(Point a, Point b, Point c, Point d){
        points[0]=a;
        points[1]=b;
        points[2]=c;
        points[3]=d;
        for (int i = 0; i < POINTS_AMOUNT; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("Points cannot be null");
            }
        }
        if (area() <= 0 || !isConvex()) {
            throw new IllegalArgumentException("Quadrilateral must have a non-zero area and must be convex");
        }
    }
    public double area() {
        return new Triangle(points[0], points[1], points[3]).area() + new Triangle(points[3], points[1], points[2]).area();
    }
    public boolean isConvex() {
        double crossProduct1 = crossProduct(points[0], points[1], points[2]);
        double crossProduct2 = crossProduct(points[1], points[2], points[3]);
        double crossProduct3 = crossProduct(points[2], points[3], points[0]);
        double crossProduct4 = crossProduct(points[3], points[0], points[1]);


        return (crossProduct1 > 0 && crossProduct2 > 0 && crossProduct3 > 0 && crossProduct4 > 0) ||
                (crossProduct1 < 0 && crossProduct2 < 0 && crossProduct3 < 0 && crossProduct4 < 0);
    }

    private double crossProduct(Point p1, Point p2, Point p3) {
        return (p2.getX() - p1.getX()) * (p3.getY() - p1.getY())
             - (p2.getY() - p1.getY()) * (p3.getX() - p1.getX());
    }


    @Override
    public Point centroid() {
        Triangle tr1 = new Triangle(points[0], points[1], points[2]);
        Triangle tr2 = new Triangle(points[0], points[2], points[3]);

        Point center1 = tr1.centroid();
        Point center2 = tr2.centroid();
        double area1 = tr1.area();
        double area2 = tr2.area();

        double totalArea = area1 + area2;
        double x = (center1.getX() * area1 + center2.getX() * area2) / totalArea;
        double y = (center1.getY() * area1 + center2.getY() * area2) / totalArea;

        return new Point(x, y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (!(figure instanceof Quadrilateral)) {
            return false;
        }

        Quadrilateral other = (Quadrilateral) figure;

        boolean[] matched = new boolean[POINTS_AMOUNT];

        for (Point p1 : this.points) {
            boolean foundMatch = false;
            for (int i = 0; i < POINTS_AMOUNT; i++) {
                if (!matched[i] && p1.arePointsEqual( other.points[i])) {
                    matched[i] = true;
                    foundMatch = true;
                    break;
                }
            }
            if (!foundMatch) {
                return false;
            }
        }

        return true;
    }
}
