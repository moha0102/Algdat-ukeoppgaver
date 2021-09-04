package Uke35;

import java.util.Arrays;

//Bubble sort
public class ForelesningTorsdagSortering {
    public static void main(String[] args) {
        int[] values = {1,5,6,7,8,9};

        for (int i = 0; i < values.length; i++) {
            for (int j = values.length - 1; j > i; j--) {
                if (values[j] > values[j - 1]) {
                    int temp = values[j];
                    values [j] = values[j-1];
                    values[j - 1] = temp;
                }
            }

        }
        System.out.print(Arrays.toString(values));
    }

  
}
