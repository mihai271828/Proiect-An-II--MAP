package com.example;

    public class Note {

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

