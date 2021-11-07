package Eksamen2017;

import java.util.Arrays;

public class snuOperasjon {
    public static void bytt(int[] a, int i, int v) {
        int temp = a[i];
        a[i] = a[v];
        a[v] = temp;
    }

    public static void snu(int[] a) {
        int j = a.length - 1;
        for (int i = 0; i < j;) {
            bytt(a, i++, j--);
        }

    }

    public static void main(String[] args) {
        int[] a = { 4, 2, 5, 1, 3, 6 }, b = {};
        snu(a);
        snu(b);
        System.out.println(Arrays.toString(a) + " " + Arrays.toString(b));
        // Utskrift: [6, 3, 1, 5, 2, 4] []
    }

}
