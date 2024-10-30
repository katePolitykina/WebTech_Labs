package com.epam.rd.autotasks.max;

import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        if (values == null || values.length == 0)
            return OptionalInt.empty();
        int maxV = values[0];
        for (int value: values
             ) {
            if (maxV< value){
                maxV = value;
            }
        }
        return OptionalInt.of(maxV);
    }
}
