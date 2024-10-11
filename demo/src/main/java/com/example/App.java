package com.example;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] noten = { 29, 37, 38, 41, 84, 67 };
        Note genug = new Note();
        System.out.println(Arrays.toString(genug.ausreichendeNoten(noten)));
        System.out.println(genug.Durchschnittswert(noten));
        System.out.println(Arrays.toString(genug.RoundedNumber(noten)));
        System.out.println(genug.MaxRoundedNumber(noten));
    }

};

class Note {

    int[] ausreichendeNoten(int[] noten) {
        int count = 0;
        for (int note : noten) {
            if (note < 40)
                count++;
        }
        int[] resultArray = new int[count];
        int index = 0;
        for (int note : noten)
            if (note < 40) {
                resultArray[index] = note;
                index++;
            }
        return resultArray;
    }

    double Durchschnittswert(int[] noten) {
        double sum = 0;
        for (int note : noten) {
            sum += note;
        }
        double average = sum / noten.length;
        return Math.round(average * 100) / 100.0;
    }

    int[] RoundedNumber(int[] noten) {
        for (int i = 0; i < noten.length; i++) {
            if (noten[i] >= 38) {
                int multiple = ((noten[i] / 5) + 1) * 5;
                if (multiple - noten[i] < 3) {
                    noten[i] = multiple;
                }
            }

        }
        return noten;
    }
    int MaxRoundedNumber(int[] noten){
        int max=0;
        noten=RoundedNumber(noten);
        for(int note:noten){
            if(note>max){
                max=note;
            }
        }
        return max;
    }

}

class Zahlen{
    
    int maximaleZahl(int[] zahlen){
        int max=0;
        for(int i=0;i<zahlen.length;i++){
            if(zahlen[i]>max){
                zahlen[i]=max;
            }
        }
        return max;
    }
    int minimaleZahl(int[] zahlen){
        int min=999999;
        for(int i=0;i<zahlen.length;i++){
            if(zahlen[i]<min){
                zahlen[i]=min;
            }
        }
        return min;
    }

    int maximaleS
}
