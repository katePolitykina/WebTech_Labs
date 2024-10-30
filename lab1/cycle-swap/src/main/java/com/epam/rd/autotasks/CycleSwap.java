package com.epam.rd.autotasks;

import java.lang.reflect.Array;
import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        cycleSwap(array, 1);
    }

    static void cycleSwap(int[] array, int shift) {
        if (array == null || array.length == 0 || shift == 0) {
            return;
        }
        int[] lastPart = Arrays.copyOfRange(array, array.length - shift, array.length);
        System.arraycopy(array, 0, array, shift, array.length - shift);
        System.arraycopy(lastPart, 0, array, 0, shift);
    }
}
