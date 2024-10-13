package com.example;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] noten = { 29, 37, 38, 41, 84, 67 };
        int[] numbers = { 4, 8, 3, 10, 17 };
        int[] arr1 = { 1, 3, 0, 0, 0, 0, 0, 0, 0 };
        int[] arr2 = { 8, 7, 0, 0, 0, 0, 0, 0, 0 };
        int[] arr3 = { 8, 3, 0, 0, 0, 0, 0, 0, 0 };
        int[] arr4 = { 5, 4, 0, 0, 0, 0, 0, 0, 0 };
        int[] arr5 = { 2, 3, 6, 0, 0, 0, 0, 0, 0 };
        int[] result = {};
        int[] keyboards = { 40, 60 };
        int[] usbs = { 8, 12 };
        Note genug = new Note();
        Zahlen number = new Zahlen();
        GrosseZahlen zahl = new GrosseZahlen();
        Electronics gadget = new Electronics();
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
        System.out.println(gadget.biligste(keyboards));
        System.out.println(gadget.teursten(keyboards, usbs));
        System.out.println(gadget.affordable(usbs, 30));
        System.out.println(gadget.bothaffordable(60, keyboards, usbs));
        System.out.println("Summe: " + Arrays.toString(zahl.summe(arr1, arr2, result)));
        System.out.println("Difference: " + Arrays.toString(zahl.diff(arr3, arr4, result)));
        System.out.println("Multiplikation: " + Arrays.toString(zahl.multiplikation(arr5, 2)));
        System.out.println("Division: "+Arrays.toString(zahl.Division(arr5, 2)));
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

class GrosseZahlen {
    int[] summe(int[] arr1, int[] arr2, int[] result) {

        int maxLength = Math.max(arr1.length, arr2.length) + 1;
        result = new int[maxLength];

        int sum = 0;
        int carry = 0;

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = maxLength - 1;

        int digitA, digitB;
        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) {
                digitA = arr1[i];
            } else {
                digitA = 0;
            }
            if (j >= 0) {
                digitB = arr2[j];
            } else {
                digitB = 0;
            }
            sum = digitA + digitB + carry;
            result[k] = sum % 10;
            carry = sum / 10;
            i--;
            j--;
            k--;

        }
        return result;
    }

    int[] diff(int[] arr1, int[] arr2, int[] result) {
        int maxLength = Math.max(arr1.length, arr2.length);
        result = new int[maxLength];

        int borrow = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = result.length - 1;
        int digitA, digitB;
        while (i >= 0 || j >= 0) {

            if (i >= 0) {
                digitA = arr1[i];
            } else {
                digitA = 0;
            }
            if (j >= 0) {
                digitB = arr2[j];
            } else {
                digitB = 0;
            }
            int sub = digitA - digitB - borrow;
            if (sub < 0) {
                sub += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result[k] = sub;

            i--;
            j--;
            k--;

        }

        return result;
    }

    int[] multiplikation(int[] arr, int factor) {
        int[] result = new int[arr.length + 1];
        int sum = 0;
        int carry = 0;
        int k = result.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum = arr[i] * factor + carry;
            result[k--] = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) {
            result[k--] = carry;
        }

        int startIndex = k + 1;
        int[] finalResult = new int[result.length - startIndex];
        System.arraycopy(result, startIndex, finalResult, 0, finalResult.length);
        return finalResult;
    }

    int[] Division(int[] arr, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Invalid divisor");
        }

        int[] result = new int[arr.length];
        int index = 0;
        int carry = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = carry * 10 + arr[i];
            int quotinent = current / divisor;
            carry = arr[i] % divisor;

            if (index > 0 || quotinent != 0) {
                result[index++] = quotinent;
            }
        }
        return result;
    }
}

class Electronics {
    int biligste(int[] keyboard) {
        int min = 99999;
        for (int i = 0; i < keyboard.length; i++) {
            if (keyboard[i] < min) {
                min = keyboard[i];
            }
        }
        return min;
    }

    int teursten(int[] keyboards, int[] usbs) {
        int max = 0;
        for (int keyboard : keyboards) {
            if (keyboard > max)
                max = keyboard;
        }
        for (int usb : usbs) {
            if (usb > max)
                max = usb;
        }
        return max;
    }

    int affordable(int[] usbs, int budget) {
        int max = 0;
        for (int usb : usbs) {
            if (usb > max && usb < budget)
                max = usb;
        }
        return max;
    }

    int bothaffordable(int budget, int[] keyboards, int[] usbs) {
        int max = -1;
        for (int keyboard : keyboards) {
            for (int usb : usbs) {
                if (keyboard + usb > max && keyboard + usb < budget) {
                    max = keyboard + usb;
                }

            }
        }
        return max;
    }

}
