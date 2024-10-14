package com.example;

public class Zahlen {

    int maximaleZahl(int[] zahlen) {
        int max = 0;
        for (int i = 0; i < zahlen.length; i++) {
            if (zahlen[i] > max) {
                max = zahlen[i];
            }
        }
        return max;
    }

    int minimaleZahl(int[] zahlen) {
        int min = 999999;
        for (int i = 0; i < zahlen.length; i++) {
            if (zahlen[i] < min) {
                min = zahlen[i];
            }
        }
        return min;
    }

    int minimaleSumme(int[] zahlen) {
        int sum = 0;
        int maxCount = 0;
        int max = maximaleZahl(zahlen);
        for (int i = 0; i < zahlen.length; i++) {
            sum += zahlen[i];
            if (zahlen[i] == max) {
                maxCount++;
            }
        }
        return sum - (maxCount * maximaleZahl(zahlen));
    }

    int maximaleSumme(int[] zahlen) {
        int sum = 0;
        int min = minimaleZahl(zahlen);
        int minCount = 0;
        for (int i = 0; i < zahlen.length; i++) {
            sum += zahlen[i];
            if (zahlen[i] == min) {
                minCount++;
            }
        }
        return sum - (minCount * min);
    }
}
