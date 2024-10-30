package com.epam.rd.autotasks.figures;

class Triangle extends Figure{
    private static final int POINTS_AMOUNT = 3;
    private Point[] points = new Point[POINTS_AMOUNT];
    public Triangle (Point a, Point b, Point c){
        points[0]=a;
        points[1]=b;
        points[2]=c;
        for (int i = 0; i < POINTS_AMOUNT; i++) {
            if (points[i]== null)
                throw new IllegalArgumentException();
        }
        if (area()==0){
            throw new IllegalArgumentException();
        }
    }
    public double area() {
        return 0.5 * Math.abs(
                points[0].getX() * (points[1].getY() - points[2].getY()) +
                        points[1].getX() * (points[2].getY() - points[0].getY()) +
                        points[2].getX() * (points[0].getY() - points[1].getY())
        );
    }

    @Override
    public Point centroid() {
        double x = 0.0, y = 0.0;
        for (int i = 0; i < POINTS_AMOUNT; i++) {
            x += points[i].getX();
            y += points[i].getY();
        }
        x/= POINTS_AMOUNT;
        y/= POINTS_AMOUNT;
        return new Point(x,y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (!(figure instanceof Triangle)) {
            return false;
        }
        Triangle other = (Triangle) figure;

        boolean[] matched = new boolean[3];

        for (Point p1 : this.points) {
            boolean foundMatch = false;
            for (int i = 0; i < 3; i++) {
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
