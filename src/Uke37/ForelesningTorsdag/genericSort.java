package Uke37.ForelesningTorsdag;

import java.util.Arrays;

public class genericSort {
    public static void main(String[] args) {
       int myValue = 5;
       test(myValue);
       System.out.println("Versjon 1: " + myValue);

       
       int[] myValueArray = {5};
       testArray(myValueArray);
       System.out.println("Versjon 2: " + Arrays.toString(myValueArray));
    }

    //Pass by value: ting kopieres inn i funksjonen.
    public static void test(int value) {
        value += 2;
    }

    //Pass by reference: vi sender en peker til det faktiske objektet
    public static void testArray(int[] value) {
        value[0] += + 4;
    }
}
