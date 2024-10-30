package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns)
    {
        int [][] array = new int[rows][columns];
        int buttomBorder= rows-1, upBorder=0, rightBorder=columns-1, leftBorder=0;
        int currNumb=1;
        int maxNumb = rows*columns;
        while (true)  {
            for (int i = leftBorder; i <= rightBorder; i++) {
                array[upBorder][i] = currNumb++;
            }
            if (currNumb>maxNumb) break;
            upBorder++;
            for (int j = upBorder; j <= buttomBorder; j++) {
                array[j][rightBorder] = currNumb++;
            }
            if (currNumb>maxNumb) break;
            rightBorder--;
            for (int i = rightBorder; i >= leftBorder; i--) {
                array[buttomBorder][i] = currNumb++;
            }
            if (currNumb>maxNumb) break;
            buttomBorder--;
            for (int j = buttomBorder; j >= upBorder; j--) {
                array[j][leftBorder] = currNumb++;
            }
            leftBorder++;
            if (currNumb>maxNumb) break;
        }
        return array;
    }
}
