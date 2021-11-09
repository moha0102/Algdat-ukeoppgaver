package EksamenV2015;

public class maksMetode {
    public interface Kø<T> {
    public void leggInn(T t);   // legger inn bakerst
    public T kikk();            // ser på det som er først
    public T taUt();            // tar ut det som er først
    public int antall();        // antall i køen
    public boolean tom();       // er køen tom?
    public void nullstill();    // tømmer køen
} 

public static <T> T maks(Kø<T> kø, Comparator<? super T> c) {
    T maksverdi = kø.taUt();
    kø.leggInn(maksverdi);

    for (int i = 1; i < kø.antall(); i++) {
        T verdi = kø.taUt();
        if (c.compare(verdi,maksverdi) > 0) {
            maksverdi = verdi;
        }
        kø.leggInn(verdi);
    }

    return maksverdi;
}

public static void main(String[] args) {
    Integer[] a = {3,9,6,2,8,1,5,10,7,4};               // en heltallstabell
    Kø<Integer> kø = new LenketKø<>();                  // en Integer-kø
    for (int tall : a) kø.leggInn(tall);                // legger inn i køen
    Comparator<Integer> c = Comparator.naturalOrder();  // en komparator
    Integer maksverdi = maks(kø, c);                    // kaller metoden
    System.out.println(maksverdi);                      // skriver ut
    // Utskrift: 10
}
    
}
