package com.example;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] noten = { 29, 37, 38, 41, 84, 67 };
        int[] numbers = { 4, 8, 3, 10, 17};
        int[] arr1 = { 1, 3, 0, 0, 0, 0, 0, 0, 0 };
        int[] arr2 = { 8, 7, 0, 0, 0, 0, 0, 0, 0 };
        int[] arr3 = { 8, 3, 0, 0, 0, 0, 0, 0, 0 };
        int[] arr4 = { 5, 4, 0, 0, 0, 0, 0, 0, 0 };
        int[] arr5 = { 2, 3, 6, 0, 0, 0, 0, 0, 0 };
        int[] result = {};
        int[] keyboards1 = { 40 ,35, 70 ,15 ,45 };
        int[] keyboards2={15,20,10,35};
        int[] usbs2={20,15,40,15};
        int[] preise = { 15,45,20 };
        int[] keyboards4_1={40,50,60};
        int[] usb4_1={8,12};
        int[] keyboards4_2={60};
        int[] keyboards4_3={40,60};
        Note genug = new Note();
        Zahlen number = new Zahlen();
        GrosseZahlen zahl = new GrosseZahlen();
        Electronics gadget = new Electronics();
        System.out.println("Aufgabe 1 ");
        System.out.println("RoundedArray: " + Arrays.toString(genug.RoundedNumber(noten)));
        System.out.println("AusreichendeNoten: " + Arrays.toString(genug.ausreichendeNoten(noten)));
        System.out.println("Mean: " + genug.Durchschnittswert(noten));
        System.out.println("RoundedMaxNumber: " + genug.MaxRoundedNumber(noten));
        System.out.println("Aufgabe 2 ");
        System.out.println("MaximaleSumme: " + number.maximaleSumme(numbers));
        System.out.println("MinimaleSumme: " + number.minimaleSumme(numbers));
        System.out.println("MaximaleZahl: " + number.maximaleZahl(numbers));
        System.out.println("MinimaleZahl: " + number.minimaleZahl(numbers));
        System.out.println("Aufgabe 4");
        System.out.println("Aufagabe 4.1: "+gadget.biligste(keyboards1));
        System.out.println("Aufgabe 4.2: "+gadget.teursten(keyboards2, usbs2));
        System.out.println("Aufgabe 4.3: " +gadget.affordable(preise, 30));
        System.out.println("Aufgabe 4.4: "+gadget.bothaffordable(60, keyboards4_1, usb4_1)+" "+gadget.bothaffordable(60, keyboards4_2, usb4_1)+" "+gadget.bothaffordable(60, keyboards4_3, usb4_1));
        System.out.println("Aufgabe 3 ");
        System.out.println("Summe: " + Arrays.toString(zahl.summe(arr1, arr2, result)));
        System.out.println("Difference: " + Arrays.toString(zahl.diff(arr3, arr4, result)));
        System.out.println("Multiplikation: " + Arrays.toString(zahl.multiplikation(arr5, 2)));
        System.out.println("Division: "+Arrays.toString(zahl.Division(arr5, 2)));
    }

};








