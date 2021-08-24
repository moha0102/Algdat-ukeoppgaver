public class avsnitt114 {
    public static void main(String[] args) {
        /*
        public static int maks(int[] a)   // versjon 2 av maks-metoden
          {
            int m = 0;               // indeks til største verdi
            int maksverdi = a[0];    // største verdi

            for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
            {
              maksverdi = a[i];     // største verdi oppdateres
              m = i;                // indeks til største verdi oppdateres
            }
            return m;   // returnerer indeks/posisjonen til største verdi

          }

        Det opprettes en hjelpevariabel m (1)
        Det opprettes en maksverdi og bli tilordnet en tabelloperasjon (2)
        For løkke opprettes og får 1 som start verdi (1)
        I for løkken skjer sammenligningen (i < a.length) n ganger (n)
        I for løkken skjer addisjonen i++ (n-1) ganger (n-1)
        Setningen if(a[i] > maksverdi) utføres (n-1) ganger og består av to tabelloperasjoner(2(n-1))
        Tilordningen m = i utføres 3x ganger hver gang x er sann (to tilordninger og en tabelloperasjon)
        Retunurer m (1)
        Sum: 1 + 2 + 1 + n + n−1 + 2(n−1) + 3x + 1 = 4n + 2 + 3x
        1. n = 10, x = 0, tilsammen 42
        2. n = 10, x = 9, tilsammen 69
        3. n = 10, x = 4, tilsammen 54

         */


    }
}




