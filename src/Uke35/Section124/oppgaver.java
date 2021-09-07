package Uke35.Section124;

import java.util.Arrays;
import java.util.Random;

public class oppgaver {
    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0) {
          throw new ArrayIndexOutOfBoundsException ("fra(" + fra + ") er negativ!");
        }                                
        if (til > tablengde) {
            throw new ArrayIndexOutOfBoundsException
            ("til(" + til + ") > tablengde(" + tablengde + ")");
          }
    
        if (fra > til) {
            throw new IllegalArgumentException
            ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
          }
      }

      public static int maks(int[] a, int fra, int til) {
        if (a == null) {
            throw new NullPointerException("Array can not be null");
        }
    
        fratilKontroll(a.length, fra, til);
    
        if (fra < 0 || til > a.length || fra >= til) {
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

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] nestMaks(int[] a) {
        int n = a.length;
        if (n < 2) {
            throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");
        }

        int m = maks(a);

        int nm;

        bytt(a,0,m);
        int k = oppgaver.maks(a,1,a.length);

        if(k==m) {
            k = 0;
        }
        oppgaver.bytt(a,0,m); 
        /*
        if (m == 0) {
            nm = maks(a,1,n);
        } else if (m == n - 1) {
            nm = maks(a, 0, n - 1); 
        } else {
            int mv = maks(a,0,m);
            int mh = maks(a,m+1,n);
            nm = a[mh] > a[mv] ? mh : mv;
        }

        return new int[] {m,nm};
        */
        return new int[] {m,k};
    }

    public static int[] randPerm(int n) {
      Random r = new Random();         // en randomgenerator
      int[] a = new int[n];            // en tabell med plass til n tall
  
      Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n
  
      for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
      {
        int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
      }
  
      return a;                        // permutasjonen returneres
    }

    public static void skrivln(int[] a, int fra, int til) {
        
        for (int i = fra; i <= til - 1; i++) {
            if (i == til) {
                System.out.println(a[i]);
            } else {
                System.out.println(a[i] + " ");
            }
            
        }   
    }

    public static void skrivUtln(int[] a) {
        skrivln(a, 0, a.length);
    }

    public static void main(String[] args) {
        int[] a = oppgaver.randPerm(20); // tilfeldig permutasjon av 1 . . 20
        int[] b = oppgaver.nestMaks(a);  // metoden returnerer en tabell

        int m = b[0], nm = b[1];       // m for maks, nm for nestmaks

        oppgaver.skrivUtln(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);

    }
}
