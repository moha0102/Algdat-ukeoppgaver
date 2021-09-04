package Uke35.Section121;

public class oppgave1 {
    public static void main(String[] args) {
        int[] values = {2,5,4,6,7,3,1,9m5};
        System.out.println(values[kjorMin(values)]);
    }

    public static int minimum(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Feil intervall!");
        }

        int m = fra;
        int minverdi = a[fra];

        for (int i = fra + 1; i < til; i++) {
            if (a[i] < minverdi) {
                m = i;
                minverdi = a[m];
            }
        }
        return m;
    }

    public static int kjorMin(int[] a) {
        return minimum(a, 0, a.length);
    }

}
