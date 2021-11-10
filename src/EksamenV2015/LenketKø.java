package EksamenV2015;

import java.util.*;

interface Kø<T> {
    public void leggInn(T t); // legger inn bakerst

    public T kikk(); // ser på det som er først

    public T taUt(); // tar ut det som er først

    public int antall(); // antall i køen

    public boolean tom(); // er køen tom?
}

public class LenketKø<T> implements Kø<T> {
    private static final class Node<T> // en indre nodeklasse
    {
        private T verdi; // nodens verdi
        private Node<T> neste; // peker til neste node

        Node(Node<T> neste) // nodekonstruktør
        {
            verdi = null;
            this.neste = neste;
        }
    } // class Node

    private Node<T> fra, til; // fra: først i køen, til: etter den siste
    private int antall; // antall i køen

    private static final int START_STØRRELSE = 8;

    public LenketKø(int størrelse) // konstruktør
    {
        til = fra = new Node<>(null); // lager den første noden

        Node<T> p = fra; // en hjelpevariabel
        for (int i = 1; i < størrelse; i++) {
            p = new Node<>(p); // lager resten av nodene
        }
        fra.neste = p; // for å få en sirkel

        antall = 0; // ingen verdier foreløpig
    }

    public LenketKø() // standardkonstruktør
    {
        this(START_STØRRELSE);
    }

    public int antall() {
        return antall;
    }

    public boolean tom() {
        return fra == til; // eller antall == 0
    }

    public void leggInn(T verdi) // null-verdier skal være tillatt
    {
        til.verdi = verdi; // legger inn bakerst

        if (til.neste == fra) // køen vil bli full - må utvides
        {
            til.neste = new Node<>(fra); // ny node mellom til og fra
        }

        til = til.neste; // flytter til
        antall++; // øker antallet
    }

    public T kikk() {
        if (tom())
            throw new NoSuchElementException("Køen er tom!");
        return fra.verdi; // returnerer verdien
    }

    public T taUt() {
        if (tom())
            throw new NoSuchElementException("Køen er tom!");

        T tempverdi = fra.verdi; // tar vare på verdien i fra
        fra.verdi = null; // nuller innholdet i fra

        fra = fra.neste; // flytter fra
        antall--; // reduserer antallet

        return tempverdi; // returnerer verdien
    }

    /*
     * public void leggInn(T t); // legger inn bakerst
     * 
     * public T kikk(); // ser på det som er først
     * 
     * public T taUt(); // tar ut det som er først
     * 
     * public int antall(); // antall i køen
     * 
     * public boolean tom(); // er køen tom?
     */
    public static <T> T maks(Kø<T> kø, Comparator<? super T> c) {

        T maksverdi = kø.taUt();
        kø.leggInn(maksverdi);

        for (int i = 1; i < kø.antall(); i++) {
            T verdi = kø.taUt();

            if (c.compare(verdi, maksverdi) > 0) {
                maksverdi = verdi;
            }
            kø.leggInn(verdi);
        }
        return maksverdi;
    }

    public static void main(String[] args) {
        Integer[] a = { 3, 9, 6, 2, 8, 1, 5, 10, 7, 4 }; // en heltallstabell
        Kø<Integer> kø = new LenketKø<>(); // en Integer-kø
        for (int tall : a) {
            kø.leggInn(tall); // legger inn i køen
        }
        Comparator<Integer> c = Comparator.naturalOrder(); // en komparator
        Integer maksverdi = maks(kø, c); // kaller metoden
        System.out.println(maksverdi); // skriver ut
        // Utskrift: 10
    }

} // class LenketKø
