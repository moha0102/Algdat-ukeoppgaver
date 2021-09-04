package Uke35.Section121;

import java.util.Arrays;

public class oppgave5 {
    public static void main(String[] args) {
        char[] c = {'A','B','C','D','E','F','G','H','I','J'};
        char[] d = Arrays.copyOfRange(c, 4, 8);
        int x = 0;
        System.out.print("[");
        for(char k : d) {
            if (x == d.length - 1) {
                System.out.print(k);
            } else {
                System.out.print(k + ",");
            }
            x++;
        }
        System.out.print("]");
    }
    
}
