package Uke35.Section123;

public class oppgave1 {
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

    public static void vhKontroll(int tablengde, int v, int h) {
        if (v < 0) { 
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");
        }  
        if (h >= tablengde) {
            throw new ArrayIndexOutOfBoundsException("h(" + h + ") >= tablengde(" + tablengde + ")");
        }

        if (v > h + 1) {
            throw new IllegalArgumentException("v = " + v + ", h = " + h);
        }
}

/*
   * Checks that fromIndex and toIndex are in
   * the range and throws an exception if they aren't.
   */
  public static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
    if (fromIndex > toIndex) {
      throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
    }

    if (fromIndex < 0) {
      throw new ArrayIndexOutOfBoundsException(fromIndex);
    }

    if (toIndex > arrayLength) {
      throw new ArrayIndexOutOfBoundsException(toIndex);
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


  public static void main(String[] args) {
      int[] a = {12,0,5,9,4,2,7,1};
      int[] b = null;
      //a = null;
      //oppgave1.maks(a,0,10);
      //oppgave1.maks(a,0,11);
      //oppgave1.maks(a,10,0);
      //oppgave1.maks(a,0,0);
      //oppgave1.maks(b,0,0);
  }
}
