package com.example;
public class Electronics {
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
