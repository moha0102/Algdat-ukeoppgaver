package Eksamen2017;

public class binaersok {
    public static int finn(int[] a, int verdi) {
        int v = 0;
        int h = a.length - 1;
        while (v <= h) {
            int m = (v + h) / 2;
            int midValue = a[m];

            if (verdi == midValue) {
                return m;
            } else if (verdi < midValue) {
                h = m - 1;
            } else {
                v = m + 1;
            }
        }

        return -(v + 1);
    }

    public static void main(String[] args) {
        int[] a = { 2, 3, 5, 7, 10, 12, 12, 15, 18, 20 };
        System.out.println(finn(a, 1)); // utskrift -1
        System.out.println(finn(a, 12)); // utskrift 5
        System.out.println(finn(a, 16)); // utskrift -9
        System.out.println(finn(a, 21)); // utskrift -11
    }

}
