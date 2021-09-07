package Uke34;
import javax.swing.*;

public class Avsnitt113 {
    /* Oppgave 5 Avsnitt 1.1.3
    public static void main(String[] args) {
        int[] a = {5,10};

        System.out.println(Arrays.toString(minmaks(a)));
    }

   public static int[] minmaks(int[] a) {
       int[] b = new int[a.length];
       int minVal = a[0];
       int maxVal = a[0];
       for (int i = 0; i < a.length; i++) {
           if (minVal > a[i]) {
               minVal = a[i];
           } else if(maxVal < a[i]) {
               maxVal = a[i];
           }
           b[i] = a[i];
       }
        return (b);
    }
    */

    public static void main(String[] args) {
       String a = JOptionPane.showInputDialog("Skriv inn ett tall");
        System.out.println(fak(Integer.parseInt(a)));
    }

    static long fak(int n) {

        int sum = 1;
        for (int i = n; i > 0; i--) {
            sum = sum*i;
        }
        return sum;
    }
}
