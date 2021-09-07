package Uke36.ForelesningTirsdag;

import java.util.Arrays;

public class Bubblesort {

    public static void main(String[] args) {
        int[] values = {5,6,9,2,8,3,1};
        int temp = 0;

        for (int i = 0; i < values.length - 1; i++) {
            for (int j = values.length -1 ; j > i; j--) {
                if (values[i] /* values[j-1] */ > values[j]) {
                    temp = values[j];
                    values[j] = values[i];
                    values[i] = temp;
                    /*
                    temp = values[j];
                    values[j] = values[j-1];
                    values[j-1] = temp;
                    */
                }
            } 
        }

        System.out.println("Ferdig sortert verdier");

        System.out.println(Arrays.toString(values));


    }
    
}
