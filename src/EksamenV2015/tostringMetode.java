package EksamenV2015;

import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.namespace.QName;

public class tostringMetode {
    public static String toString(int[] a) {
        StringBuilder s = new StringBuilder("[");
        if (a.length != 0) {
            for (int i = 0; i < a.length; i++) {
                if (i == a.length -1) {
                    s.append(a[i]);
                } else {
                    s.append(a[i]).append(", ");
                }
            }
        }
        return s.append("]").toString();

    }

    public static int[] snitt(int[] a, int[] b) {
        ArrayList<Integer> insertion = new ArrayList<Integer>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    insertion.add(b[j]);
                }
            }
        }
        int[] arr = insertion.stream().mapToInt(i -> i).toArray();



        return arr;
    }

    public static void main(String[] args) {
        /*
        int[] a = {};
        int[] b = {5};
        int[] c = {1,2,3,4,5,6,7,8,9,10};
      
        System.out.println(toString(a) + " " + toString(b) + " " + toString(c));
      
        // Utskrift: [] [5] [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        */
        int[] a = {1,2,4,5,8,9,12};
        int[] b = {2,6,9,12,15};
        int[] c = {4,7,10};
      
        String ab = toString(snitt(a, b));
        String bc = toString(snitt(b,c));
        String ac = toString(snitt(a, c));
      
        System.out.println(ab + " " + bc + " " + ac);
        // Utskrift: [2, 9, 12] [] [4]
    }
    
}
