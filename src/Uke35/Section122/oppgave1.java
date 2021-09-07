package Uke35.Section122;

import java.util.Arrays;
import java.util.Random;

public class oppgave1 {
    private oppgave1() {}

    public static void bytt(int[] a, int i, int j) {
      int temp = a[i]; 
      a[i] = a[j]; 
      a[j] = temp;
    }

    public static void byttChar(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void randPerm(int[] a)  // stokker om a
    {
      Random r = new Random();     // en randomgenerator
  
      for (int k = a.length - 1; k > 0; k--)
      {
        int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
        bytt(a,k,i);
      }
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
      Random r = new Random();         // en randomgenerator
      int[] a = new int[n];            // en tabell med plass til n tall
  
      Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n
  
      for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
      {
        int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
        bytt(a,k,i);                   // bytter om
      }
  
      return a;                        // permutasjonen returneres
    }

    public static int maks(int[] a, int fra, int til) {
      if (fra < 0 || til > a.length || fra >= til)
      {
        throw new IllegalArgumentException("Illegalt intervall!");
      }
  
      int m = fra;              // indeks til største verdi i a[fra:til>
      int maksverdi = a[fra];   // største verdi i a[fra:til>
  
      for (int i = fra + 1; i < til; i++)
      {
        if (a[i] > maksverdi)
        {
          m = i;                // indeks til største verdi oppdateres
          maksverdi = a[m];     // største verdi oppdateres
        }
      }
  
      return m;  // posisjonen til største verdi i a[fra:til>
    }

    public static int maks(int[] a) {
      return maks(a,0,a.length);     // kaller metoden over
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

    public static void skriv(int[] a, int fra, int til) {
        
        for (int i = fra; i <= til; i++) {
            if (i == til) {
                System.out.println(a[i]);
            } else {
                System.out.print(a[i] + " ");
            }
            
        }   
    }

    public static void skrivUt(int[] a) {
        skriv(a, 2, 5);
    }

    public static void skrivln(int[] a, int fra, int til) {
        
        for (int i = fra; i <= til; i++) {
            if (i == til) {
                System.out.println(a[i]);
            } else {
                System.out.println(a[i] + " ");
            }
            
        }   
    }

    public static void skrivUtln(int[] a) {
        skrivln(a, 2, 5);
    }

    public static void main(String[] args) {
        int[] a = oppgave1.randPerm(20);              // en tilfeldig tabell
        for (int k : a) System.out.print(k + " ");  // skriver ut a
  
        int m = oppgave1.maks(a);   // finner posisjonen til største verdi
  
        System.out.println("\nStørste verdi ligger på plass " + m);

        System.out.println("----------------Oppgave 4----------------");
        skrivUt(a);
        
        System.out.println("----------------Oppgave 5----------------");
        skrivUtln(a);
    }
}
