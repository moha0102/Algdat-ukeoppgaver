package Eksamen2016;

import java.util.Objects;

public class LenketHashTabell<T> {
    private static final class Node<T> {
        private final T verdi; // nodens verdi
        private final int hashverdi; // lagrer hashverdien
        private Node<T> neste; // referanse til neste node

        private Node(T verdi, int hashverdi, Node<T> neste) {
            this.verdi = verdi;
            this.hashverdi = hashverdi;
            this.neste = neste;
        }
    } // class Node

    private Node<T>[] hash; // en nodetabell
    private final float tetthet; // eng: loadfactor
    private int grense; // eng: threshold (norsk: terskel)
    private int antall; // antall verdier

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public LenketHashTabell(int dimensjon) // konstruktør
    {
        hash = new Node[dimensjon];
        antall = 0;
        tetthet = 0.75f;
        grense = (int) (tetthet * hash.length);
    }

    private void utvid() {
        @SuppressWarnings({ "rawtypes", "unchecked" }) // bruker raw type
        Node<T>[] nyhash = new Node[2 * hash.length + 1]; // dobling + 1

        for (int i = 0; i < hash.length; i++) // den gamle tabellen
        {
            Node<T> p = hash[i]; // listen til hash[i]
            while (p != null) // går nedover
            {
                Node<T> q = p.neste; // hjelpevariabel
                int nyindeks = p.hashverdi % nyhash.length; // indeks i ny tabell
                p.neste = nyhash[nyindeks]; // p skal legges først
                nyhash[nyindeks] = p;
                p = q; // flytter p til den neste
            }
            hash[i] = null; // nuller i den gamle
        }
        hash = nyhash; // bytter tabell
        grense = (int) (tetthet * hash.length); // ny grense
    }

    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "verdi er null!");

        if (antall >= grense)
            utvid(); // utvider

        int hashverdi = verdi.hashCode() & 0x7fffffff; // fjerner fortegn
        int indeks = hashverdi % hash.length; // finner tabellindeks

        hash[indeks] = new Node<>(verdi, hashverdi, hash[indeks]); // først i listen

        antall++;
        return true;
    }

    /* De øvrige metodene er ikke tatt med. */
    public static void main(String[] args) {
        LenketHashTabell<String> hash = new LenketHashTabell<>(11);
        String[] navn = { "Envy", "Bo", "Ali", "Per", "Eli", "Siri", "Ola", "Mari", "Ann", "Åse" };
        for (int i = 0; i <= 8; i++) {
            System.out.println(hash.leggInn(navn[i]) + ": " + hash.grense + ": Nr: " + i);
        }

    }
}
