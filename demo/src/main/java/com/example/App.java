package com.example;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] noten = { 29, 37, 38, 41, 84, 67 };
        int[] numbers = { 4, 8, 3, 10, 17 };
        int[] arr1 = { 130000000 };
        int[] arr2 = { 870000000 };
        int[] keyboards={15,20,10,35};
        int[] usbs={20,15,40,15};
        Note genug = new Note();
        Zahlen number = new Zahlen();
        // GrosseZahlen zahl = new GrosseZahlen();
        Electronics gadget=new Electronics();
        System.out.println("Aufgabe 1 ");
        System.out.println("AusreichendeNoten: " + Arrays.toString(genug.ausreichendeNoten(noten)));
        System.out.println("Mean: " + genug.Durchschnittswert(noten));
        System.out.println("RoundedArray: " + Arrays.toString(genug.RoundedNumber(noten)));
        System.out.println("RoundedMaxNumber: " + genug.MaxRoundedNumber(noten));
        System.out.println("Aufgabe 2 ");
        System.out.println("MaximaleSumme: " + number.maximaleSumme(numbers));
        System.out.println("MinimaleSumme: " + number.minimaleSumme(numbers));
        System.out.println("MaximaleZahl: " + number.maximaleZahl(numbers));
        System.out.println("MinimaleZahl: " + number.minimaleZahl(numbers));
        // System.out.println(Arrays.toString(zahl.summe(arr1, arr2)));
        System.out.println(gadget.biligste(keyboards));
        System.out.println(gadget.teursten(keyboards, usbs));

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

    int MaxRoundedNumber(int[] noten) {
        int max = 0;
        noten = RoundedNumber(noten);
        for (int note : noten) {
            if (note > max) {
                max = note;
            }
        }
        return max;
    }

}

class Zahlen {

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
        for (int i = 0; i < zahlen.length; i++) {
            if (zahlen[i] < maximaleZahl(zahlen)) {
                sum += zahlen[i];
            }
        }
        return sum;
    }

    int maximaleSumme(int[] zahlen) {
        int sum = 0;
        for (int i = 0; i < zahlen.length; i++) {
            if (zahlen[i] > minimaleZahl(zahlen)) {
                sum += zahlen[i];
            }
        }
        return sum;
    }
}

class IntWrapper {
    int value;
}

// class GrosseZahlen {
//     int[] summe(int[] arr1, int[] arr2) {

//         IntWrapper resultSize = new IntWrapper();
//         int sum = 0;
//         int carry = 0;
//         resultSize.value = 0;
//         int[] result = new int[Math.max(arr1.length, arr2.length) + 1];
//         int i = arr1.length - 1;
//         int j = arr2.length - 1;
//         int digitA, digitB;
//         while (i >= 0 || j >= 0 || carry > 0) {
//             if (i >= 0) {
//                 digitA = arr1[i];
//             } else {
//                 digitA = 0;
//             }
//             if (j >= 0) {
//                 digitB = arr2[j];
//             } else {
//                 digitB = 0;
//             }
//             sum = digitA + digitB + carry;

//             result[resultSize.value++] = sum % 10;
//             carry = sum / 10;
//             i--;
//             j--;
//         }
//         int[] finalResult = new int[resultSize.value];
//         for (int k = 0; k < resultSize.value; k++) {
//             finalResult[k] = result[k]; // Copy the digits
//         }

//         // Reverse the final result to get the correct order
//         for (int k = 0; k < finalResult.length / 2; k++) {
//             int temp = finalResult[k];
//             finalResult[k] = finalResult[finalResult.length - 1 - k];
//             finalResult[finalResult.length - 1 - k] = temp;
//         }

//         return finalResult; //
//     }
// }
    class Electronics{
        int biligste(int[] keyboard){
            int min=99999;
            for(int i=0;i<keyboard.length;i++){
                if(keyboard[i]<min){
                    min=keyboard[i];
                }
            }
            return min;
        }

        int teursten(int[] keyboards, int[]usbs){
            int max=0;
            for(int keyboard:keyboards){
                if(keyboard>max)
                max=keyboard;
            }
            for(int usb:usbs){
                if(usb>max)
                max=usb;
            }
            return max;
        }
        int affordable(int[] usbs, int budget){
            int max=0;
            for(int usb:usbs){
                if(usb>max && max<budget)
                max=usb;
            }
            return max;     
        }

        int bothaffordable(int budget, int[]keyboards, int[]usbs){
            int max=0;
            for(int keyboard:keyboards){
                for(int usb:usbs){
                    if(keyboard+usb>max && max<budget)
                    max=keyboard+usb;
                }
            }
            return max;
        }



    }

