package EksamenV2015;

import java.util.Comparator;
import java.util.Objects;

public class SBinTre<T> implements Iterable<T>
{
  private static final class Node<T>        // en indre nodeklasse
  {
    private T verdi;                        // nodens verdi
    private Node<T> venstre, høyre;         // venstre og høyre barn
    private int forekomster;                // antall av denne verdien

    private Node(T verdi)                   // nodekonstruktør
    {
      this.verdi = verdi;
      venstre = høyre = null;
      forekomster = 1;
    }
  }   // class Node

  private Node<T> rot;                       // peker til rotnoden
  private int antall;                        // antall verdier i treet
  private int tommeNoder;                    // antall tomme noder
  private final Comparator<? super T> comp;  // komparator

  public SBinTre(Comparator<? super T> c)   // konstruktør
  {
    rot = null;
    antall = tommeNoder = 0;
    comp = c;
  }

  public int antall()
  {
    return antall;
  }

  public boolean tom()
  {
    return antall == 0;
  }

  public int inneholder(T verdi) {
    if (antall == 0) {
        return 0;
    }
    Node<T> p = rot;

    while (p != null) {
        int cmp = comp.compare(verdi, p.verdi);
        if (cmp < 0) {
            p = p.venstre;
        } else if (cmp > 0) {
            p = p.høyre;
        } else {
            return p.forekomster;
        }
    }

    return 0;


  }

  public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi, "Verdien kan ikke være null");
        Node<T> p = rot;
        Node<T> q = null;
        int cmp = 0;

        while (p != null) {
            q = p;
            cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) {
                p = p.venstre;
            } else if (cmp > 0) {
                p = p.høyre;
            } else {
                break;
            }
        }

        if (p == null) { //Sjekker om verdien er null etter while loopen er kjørt, om den er det, lager vi en ny node på p.
            p = new Node<>(verdi);
            if (q == null) {
                rot = p;
            } else if (cmp < 0) {
                q.venstre = p;
            } else {
                q.høyre = p;
            }
        } else {
            if (p.forekomster == 0) {
                tommeNoder--;
            }
            p.forekomster++;
        }
        antall++;
        return true;
        
  }

  public boolean fjern(T verdi)
  {
    Node<T> p = rot;                               // starter i roten  
    while (p != null)
    {
      int cmp = comp.compare(verdi, p.verdi);      // sammenligner
      if (cmp < 0) p = p.venstre;                  // til venstre
      else if (cmp > 0) p = p.høyre;               // til høyre
      else break;                                  // verdi ligger i noden
    }

    if (p == null) return false;               // verdi ligger ikke i treet
    if (p.forekomster == 0) return false;      // en tom node regnes ikke med

    p.forekomster--;                           // reduserer nodens antall
    if (p.forekomster == 0) tommeNoder++;      // en ny tom node

    antall--;          // én verdi mindre i treet
    return true;       // en forekomst av verdi er fjernet
  }



  public Iterator<T> iterator()
  {
    return new InordenIterator();
  }

  private class InordenIterator implements Iterator<T>  // en iteratorklasse
  {
    private Node<T> p;  // hjelpevariabel

    // andre aktuelle variabler skal inn her

    // aktuelle hjelpestrukturer skal inn her

    // aktuelle hjelpemetoder skal inn her

    private InordenIterator()   // konstruktør
    {
      // kode mangler - skal lages
    }

    public boolean hasNext()
    {
      return p != null;
    }

    public T next()
    {
      // kode mangler - skal lages
    }

  } // InordenIterator

}  // SBinTre
