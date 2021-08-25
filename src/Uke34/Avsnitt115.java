package Uke34;

public class Avsnitt115 {
    public static void main(String[] args) {
        int[] values = {2,3,4};
        //Om lengden er 1, vil vi få returnert 0;
        //Om lengden arrayet er tomt, vil vi få returnert Index 0 out of bounds for length 0
        System.out.println(maks(values));
        
    }

    public static int maks(int[] a) {
        int siste = a.length - 1;
        int m = 0;
        int maksverdi = a[0];
        int temp = a[siste];
        a[siste] = 0x7fffffff;

        for (int i = 0; ; i++) {
            if ( a[i] > maksverdi) {
                if (i == siste) {
                    a[siste] = temp;
                    return temp >= maksverdi ? siste : m;
                } else {
                    maksverdi = a[i];
                    m = i;
                }
            }
        }
        
    }
}
