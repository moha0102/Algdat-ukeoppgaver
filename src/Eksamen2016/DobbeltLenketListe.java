package Eksamen2016;

import java.util.*;
import java.util.function.Predicate;

interface Liste<T> extends Beholder<T> {
    public boolean leggInn(T verdi); // verdi bakerst

    public void leggInn(int indeks, T verdi); // verdi på plass indeks

    public boolean inneholder(T verdi); // er verdi i listen?

    public T hent(int indeks); // hent verdi på plass indeks

    public int indeksTil(T verdi); // hvor ligger verdi?

    public T oppdater(int indeks, T verdi); // oppdater på plass indeks

    public boolean fjern(T verdi); // fjern verdi

    public T fjern(int indeks); // fjern verdi på plass indeks

    public int antall(); // antallet i listen

    public boolean tom(); // er listen tom?

    public void nullstill(); // listen nullstilles (og tømmes)

    public Iterator<T> iterator(); // en iterator

    public String toString(); // innholdet - først til bakerst

    public default String melding(int indeks) // Unntaksmelding
    {
        return "Indeks: " + indeks + ", Antall: " + antall();
    }

    public default void indeksKontroll(int indeks, boolean leggInn) {
        if (indeks < 0 ? true : (leggInn ? indeks > antall() : indeks >= antall())) {
            throw new IndexOutOfBoundsException(melding(indeks));
        }
    }
}

interface Beholder<T> extends Iterable<T> {
    public boolean leggInn(T t); // legger inn t i beholderen

    public boolean inneholder(T t); // sjekker om den inneholder t

    public boolean fjern(T t); // fjerner t fra beholderen

    public int antall(); // returnerer antallet i beholderen

    public boolean tom(); // sjekker om beholderen er tom

    public void nullstill(); // tømmer beholderen

    public Iterator<T> iterator(); // returnerer en iterator

    default boolean fjernHvis(Predicate<? super T> p) // betingelsesfjerning
    {
        Objects.requireNonNull(p); // kaster unntak

        boolean fjernet = false;
        for (Iterator<T> i = iterator(); i.hasNext();) // løkke
        {
            if (p.test(i.next())) // betingelsen
            {
                i.remove(); // fjerner
                fjernet = true; // minst en fjerning
            }
        }
        return fjernet;
    }

} // grensesnitt Beholder

public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi; // nodens verdi
        private Node<T> forrige, neste; // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode; // peker til den første i listen
    private Node<T> hale; // peker til den siste i listen
    private int antall; // antall noder i listen
    private int endringer; // antall endringer i listen

    // En som Konstruktør
    public DobbeltLenketListe() {
        hode = null;
        hale = null;
        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
        Objects.requireNonNull(a, "Arrayet kan ikke være null");
        hode = new Node<>(null);
        hale = new Node<>(null);
        hode = hale;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                hale.neste = new Node<>(a[i], hale, null);
                hale = hale.neste;
                antall++;
            }
        }

        if (antall == 0) {
            hode = null;
            hale = null;
        } else {
            hode = hode.neste;
            hode.forrige = null;
        }
    }

    public static <T> int compare(Liste<T> a, Liste<T> b, Comparator<? super T> comp) {
        Iterator<T> i = a.iterator(), j = b.iterator();
        int m = Math.min(a.antall(), b.antall());

        for (int k = 0; k < m; k++) {
            int cmp = comp.compare(i.next(), j.next());
            if (cmp != 0) {
                return cmp;
            }
        }
        return a.antall() - b.antall();
    }

    public static void main(String[] args) {
        Character[] tegn1 = { 'A', 'B', 'C' }, tegn2 = { 'A', 'B', 'D' };
        Integer[] tall1 = { 1, 2, 3, 4, 5 }, tall2 = { 1, 2, 3, 4 };

        Liste<Character> a = new DobbeltLenketListe<>(tegn1); // A,B,C
        Liste<Character> b = new DobbeltLenketListe<>(tegn2); // A,B,D

        Liste<Integer> c = new DobbeltLenketListe<>(tall1); // 1,2,3,4,5
        Liste<Integer> d = new DobbeltLenketListe<>(tall2); // 1,2,3,4

        int cmp1 = compare(a, b, Comparator.naturalOrder()); // cmp1 skal bli negativ
        int cmp2 = compare(c, d, Comparator.naturalOrder()); // cmp2 skal bli positiv

        System.out.println(cmp1);
        System.out.println(cmp2);
    }

    public Liste<T> subliste(int fra, int til) {
        fromToController(antall, fra, til);

        Liste<T> nyListe = new DobbeltLenketListe<>();
        int sum = til - fra;

        if (sum < 1) {
            return nyListe;
        }
        Node<T> findNode = finnNode(fra);

        for (int i = sum; i > 0; i--) {
            nyListe.leggInn(findNode.verdi);
            findNode = findNode.neste;
        }

        return nyListe;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        if (antall == 0 && hode == null && hale == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Kan ikke være null!");
        Node<T> nyVerdi = new Node<>(verdi);
        if (antall == 0) {
            hode = nyVerdi;
            hale = hode;

            endringer++;
            antall++;
            return true;
        } else {
            nyVerdi.forrige = hale;
            hale.neste = nyVerdi;
            hale = nyVerdi;

            endringer++;
            antall++;
            return true;
        }
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "Verdi kan ikke være NULL");

        if (antall < indeks) {
            throw new IndexOutOfBoundsException("Antall noder er mindre enn index");
        } else if (indeks < 0) {
            throw new IndexOutOfBoundsException("Index er mindre enn null!");
        }

        if (indeks == 0 && antall == 0) {
            hale = new Node<T>(verdi, null, null);
            hode = hale;
        } else if (indeks == 0) {
            hode = new Node<T>(verdi, null, hode);
            hode.neste.forrige = hode;
        } else if (indeks == antall) {
            hale = new Node<T>(verdi, hale, null);
            hale.forrige.neste = hale;
        } else {
            Node<T> p = hode;
            for (int i = 0; i < indeks; i++)
                p = p.neste;
            {
                p = new Node<T>(verdi, p.forrige, p);
            }
            p.neste.forrige = p.forrige.neste = p;
        }
        antall++;
        endringer++;
    }

    @Override
    public boolean inneholder(T verdi) {
        if (indeksTil(verdi) != -1) {
            return true;
        }

        return false;

    }

    private void fromToController(int antall, int from, int to) {
        if (from < 0 || to > antall) {
            throw new IndexOutOfBoundsException();
        }
        if (from > to) {
            throw new IllegalArgumentException();
        }
    }

    // Hjelpemetode for å finne index
    private Node<T> finnNode(int index) {
        indeksKontroll(index, false);
        Node<T> verdi;

        if (index < antall / 2) {
            verdi = hode;
            for (int i = 0; i < index; i++) {
                verdi = verdi.neste;
            }
            return verdi;
        } else {
            verdi = hale;
            for (int i = antall - 1; i > index; i--) {
                verdi = verdi.forrige;
            }
            return verdi;
        }

    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }

    // hjelpemetode for arve fra lsite
    private void indeksKontroll(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + "is negative!");
        }
        if (index >= antall) {
            throw new IndexOutOfBoundsException("Index: " + index + "> antall: " + antall);
        }
    }

    @Override
    public int indeksTil(T verdi) {
        if (verdi == null) {
            return -1;
        }

        for (int i = 0; i < antall; i++) {
            if (verdi.equals(hent(i))) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        indeksKontroll(indeks);
        Objects.requireNonNull(nyverdi, "Kan ikke være NULL");
        indeksKontroll(indeks, false);

        Node<T> findNode = finnNode(indeks);
        T preValue = findNode.verdi;
        findNode.verdi = nyverdi;
        endringer++;
        return preValue;
    }

    @Override
    public boolean fjern(T verdi) {
        if (verdi == null) {
            return false;
        }

        Node<T> head = hode;

        if (verdi.equals(head.verdi)) {
            if (head.neste != null) {
                hode = head.neste;
                hode.forrige = null;
            } else {
                hode = null;
                hale = null;
            }
            endringer--;
            antall--;
            return true;
        }

        head = hale;
        if (verdi.equals(head.verdi)) {
            hale = head.forrige;
            hale.neste = null;
            antall--;
            endringer--;
            return true;
        }

        for (head = hode.neste; head != null; head = head.neste) {
            if (verdi.equals(head.verdi)) {
                head.forrige.neste = head.neste;
                head.neste.forrige = head.forrige;
                antall--;
                endringer--;
                return true;
            }
        }
        return false;

    }

    @Override
    public T fjern(int indeks) {
        indeksKontroll(indeks, false);

        T value;
        Node<T> p = hode;

        if (indeks == 0) {
            value = p.verdi;
            if (p.neste != null) {
                hode = p.neste;
                hode.forrige = null;
            } else {
                hode = null;
                hale = null;
            }
        } else if (indeks == antall - 1) {
            p = hale;
            value = hale.verdi;

            hale = p.forrige;
            hale.neste = null;
        } else {
            for (int i = 0; i < indeks; i++) {
                p = p.neste;
            }
            value = p.verdi;

            p.forrige.neste = p.neste;
            p.neste.forrige = p.forrige;
        }

        antall--;
        endringer++;
        return value;
    }

    @Override
    public void nullstill() {
        for (Node<T> i = hode; i != null; i = i.neste) {
            i.verdi = null;
            i.forrige = null;
            i.neste = null;
        }
        hale = null;
        hode = hale;
        antall = 0;
        endringer++;
    }

    @Override
    public String toString() {
        StringBuilder nyStreng = new StringBuilder();
        nyStreng.append('[');
        if (tom()) {
            nyStreng.append("]");
            return nyStreng.toString();
        } else {
            nyStreng.append(hode.verdi);
            for (Node<T> i = hode.neste; i != null; i = i.neste) {
                nyStreng.append(", ");
                nyStreng.append(i.verdi);

            }
        }
        nyStreng.append(']');
        return nyStreng.toString();
    }

    public String omvendtString() {
        StringBuilder nyStreng = new StringBuilder();
        nyStreng.append('[');
        if (tom()) {
            nyStreng.append("]");
            return nyStreng.toString();
        } else {
            nyStreng.append(hale.verdi);
            for (Node<T> i = hale.forrige; i != null; i = i.forrige) {
                nyStreng.append(", ");
                nyStreng.append(i.verdi);

            }
        }
        nyStreng.append(']');
        return nyStreng.toString();
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> newIterator = new DobbeltLenketListeIterator();
        return newIterator;
    }

    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks, false);
        Iterator<T> initiate = new DobbeltLenketListeIterator(indeks);
        return initiate;
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode; // p starter på den første i listen
            fjernOK = false; // blir sann når next() kalles
            iteratorendringer = endringer; // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            denne = finnNode(indeks);
            endringer = iteratorendringer;
            fjernOK = false;
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            if (iteratorendringer != endringer) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T temp = denne.verdi;
            denne = denne.neste;
            fjernOK = true;

            return temp;
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe
