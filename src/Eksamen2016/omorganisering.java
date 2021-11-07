package Eksamen2016;

import java.util.Arrays;

public class omorganisering {

    public static int omorganiser(char[] c) {
        int v = 0;
        int h = c.length - 1;

        while (v <= h && c[v] > 'Z') {
            v++;
        }

        while (v <= h && c[h] <= 'Z') {
            h--;
        }

        while (true) {
            if (v < h) {
                bytt(c, v++, h--);
            } else {
                return v;
            }
            while (c[v] > 'Z') {
                v++;
            }
            while (c[h] <= 'Z') {
                h--;
            }
        }
    }

    private static void bytt(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args) {
        char[] c = "AbaAcBbAAaCCbcAB".toCharArray();
        int antall = omorganiser(c);
        System.out.println(antall + "  " + Arrays.toString(c));
        // Utskrift: 7 [c, b, a, b, c, a, b, A, A, B, C, C, A, A, A, B]

    }
}