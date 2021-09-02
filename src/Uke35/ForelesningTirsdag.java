package Uke35;

import java.util.Arrays;

public class ForelesningTirsdag {
    public static void main(String[] args) {
        int[] tall = {3,5,6,8,9,2};
        int[] a = new int[12];
        int x = 0;
        int temp = 0;

        for (int i = a.length-1; i > 5; i--) {
            a[i] = tall[x];
            x++;
            temp = i;
        }

        for (int i = temp - 1; i > 0; i--) {
            int left = 2 * i;
            int right = (2*i) + 1;

            if (a[right] > a[left]) {
                a[i] = a[right];
            } else {
                a[i] = a[left];
            }


        }

        System.out.println(Arrays.toString(a));
    }
}
