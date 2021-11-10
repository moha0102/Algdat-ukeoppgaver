package Eksamen2016;

import java.rmi.UnexpectedException;
import java.util.*;

interface Stakk<T> {
    public void leggInn(T verdi); // legger verdi på toppen

    public T kikk(); // ser på den øverste

    public T taUt(); // tar ut den øverste

    public int antall(); // antall på stakken

    public boolean tom(); // er stakken tom?

    public void nullstill(); // tømmer stakken

    public String toString(); // fra toppen og nedover
}

class LenketStakk<T> implements Stakk<T> {
    private static final class Node<T> // en «nøstet» nodeklasse
    {
        private T verdi;
        private Node<T> neste;

        private Node(T verdi, Node<T> neste) // nodekonstruktør
        {
            this.verdi = verdi;
            this.neste = neste;
        }

    } // class Node

    private Node<T> hode; // stakkens topp
    private int antall; // antall på stakken

    public LenketStakk() // konstruktør
    {
        hode = null;
        antall = 0;
    }

    @Override
    public void leggInn(T verdi) {
        hode = new Node<>(verdi, hode);
        antall++;
    }

    @Override
    public T kikk() {
        if (antall == 0)
            throw new NoSuchElementException("Stakken er tom!");
        return hode.verdi;
    }

    @Override
    public T taUt() {
        if (antall == 0)
            throw new NoSuchElementException("Stakken er tom!");

        T temp = hode.verdi;
        hode = hode.neste;
        antall--;

        return temp;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public void nullstill() {
        hode = null;
        antall = 0;
    }

    @Override
    public String toString() {
        if (tom())
            return "[]";

        StringBuilder s = new StringBuilder();

        Node<T> p = hode;
        s.append('[');
        s.append(p.verdi);

        p = p.neste;
        while (p != null) {
            s.append(',');
            s.append(' ');
            s.append(p.verdi);
            p = p.neste;
        }
        s.append(']');

        return s.toString();
    }

} // class LenketStakk

public class TabellStakk<T> implements Stakk<T> {
    private T[] a; // en T-tabell
    private int antall; // antall verdier på stakken

    public TabellStakk() // konstruktør - tabellengde 8
    {
        this(8);
    }

    @SuppressWarnings("unchecked") // pga. konverteringen: Object[] -> T[]
    public TabellStakk(int lengde) // valgfri tabellengde
    {
        if (lengde < 0)
            throw new IllegalArgumentException("Negativ tabellengde!");

        a = (T[]) new Object[lengde]; // oppretter tabellen
        antall = 0; // stakken er tom
    }

    public void nullstill() {
        for (int i = 0; i < antall; i++)
            a[i] = null;
        antall = 0;
    }

    @Override
    public T kikk() {
        if (antall == 0) // sjekker om stakken er tom
            throw new NoSuchElementException("Stakken er tom!");

        return a[antall - 1]; // returnerer den øverste verdien
    }

    @Override
    public void leggInn(T verdi) {
        if (antall == a.length)
            a = Arrays.copyOf(a, antall == 0 ? 1 : 2 * antall); // dobler

        a[antall++] = verdi;
    }

    @Override
    public T taUt() {
        if (antall == 0) // sjekker om stakken er tom
            throw new NoSuchElementException("Stakken er tom!");

        antall--; // reduserer antallet

        T temp = a[antall]; // tar var på det øverste objektet
        a[antall] = null; // tilrettelegger for resirkulering

        return temp; // returnerer den øverste verdien
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public String toString() // bruker StringJoiner
    {
        StringJoiner s = new StringJoiner(", ", "[", "]");
        for (int i = antall - 1; i >= 0; i--)
            s.add(a[i] == null ? "null" : a[i].toString());
        return s.toString();
    }

    public String toString2() // bruker StringBuilder
    {
        if (tom())
            return "[]";

        StringBuilder s = new StringBuilder();
        s.append('[');
        s.append(a[antall - 1]);

        for (int i = antall - 2; i >= 0; i--)
            s.append(',').append(' ').append(a[i]);

        s.append(']');
        return s.toString();
    }

    /*
     * public void leggInn(T verdi); // legger verdi på toppen
     * 
     * public T kikk(); // ser på den øverste
     * 
     * public T taUt(); // tar ut den øverste
     * 
     * public int antall(); // antall på stakken
     * 
     * public boolean tom(); // er stakken tom?
     * 
     * public void nullstill(); // tømmer stakken
     * 
     * public String toString(); // fra toppen og nedover
     */
    public static <T> void omvendtkopi(Stakk<T> a, Stakk<T> b) {
        if (a.antall() == 0 && b.antall() == 0) {
            throw new IndexOutOfBoundsException("Begge stakkene har null elementer");
        }

        Stakk<T> help = new TabellStakk<>();

        for (int i = a.antall(); i > 0; i--) {
            help.leggInn(a.kikk());
            b.leggInn(a.taUt());
        }

        for (int i = help.antall(); i > 0; i--) {
            a.leggInn(help.taUt());
        }

    }

    public static void main(String[] args) {
        Stakk<String> a = new TabellStakk<>(), b = new LenketStakk<>();
        a.leggInn("C");
        a.leggInn("B");
        a.leggInn("A");
        System.out.println(a + " " + b); // utskrift: [A, B, C] []
        omvendtkopi(a, b);
        System.out.println(a.toString() + " " + b.toString()); // utskrift: [A, B, C] [C, B, A]

    }

} // class TabellStakk