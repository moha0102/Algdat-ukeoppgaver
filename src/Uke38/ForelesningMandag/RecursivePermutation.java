package Uke38.ForelesningMandag;

import java.util.Arrays;

public class RecursivePermutation {
    public static void main(String[] args) {
        System.out.println("Recursive permutations!");
        int[] values = {1,2,3};

        recursivePermutation(values, 0);
    }   


    public static void recursivePermutation(int[] values, int k) {
        if (k == values.length -1) {
            System.out.println(Arrays.toString(values));
        }

        for (int i = k; i < values.length; i++) {
            swap(values, i, k);
            recursivePermutation(values,k+1);
            swap(values, k, i);
        }
    }

    public static void swap(int[] values, int m, int n) {
        int temp = values[m];
        values[m] = values[n];
        values[n] = temp;
    }
}
