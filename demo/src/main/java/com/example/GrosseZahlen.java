package com.example;

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