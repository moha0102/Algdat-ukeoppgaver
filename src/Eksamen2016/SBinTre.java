package Eksamen2016;

public class SBinTre<T> {
    private static final class Node<T> // en indre nodeklasse
    {
        private T verdi; // nodens verdi
        private Node<T> venstre, høyre; // venstre og høyre barn
        private int vAntall; // antall noder i venstre subtre

        private Node(T verdi) // konstruktør
        {
            this.verdi = verdi;
            venstre = høyre = null;
            vAntall = 0;
        }
    } // class Node

    private Node<T> rot;
    private final Comparator<? super T> comp;

    public SBinTre(Comparator<? super T> c) // konstruktør - lager et tomt tre
    {
        rot = null; // rot er null i et tomt tre
        comp = c; // komparatoren får verdi
    }

    public boolean leggInn(T verdi) {
        Node<T> p = rot, q = null;
        int cmp = 0;

        while (p != null) {
            q = p;
            cmp = comp.compare(verdi, p.verdi);

            if (cmp < 0) {
                p.vAntall++;
                p = p.venstre;
            } else
                p = p.høyre;
        }

        p = new Node<>(verdi);

        if (q == null)
            rot = p;
        else if (cmp < 0)
            q.venstre = p;
        else
            q.høyre = p;

        return true;
    }

    public int antall() {
        Node<T> p = rot;
        int antall = 0;
        while (p != null) {
            antall = (p.vAntall + 1);
            p = p.høyre;
        }

        return antall;
    }

    public boolean tom() {
        return antall() == 0;
    }

    public void settvAntall() {
        // kode mangler - skal lages
    }

    public T preorden(int indeks) {
        // kode mangler - skal lages
    }

} // SBinTre
