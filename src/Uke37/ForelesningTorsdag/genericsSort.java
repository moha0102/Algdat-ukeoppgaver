package Uke37.ForelesningTorsdag;

import java.util.Arrays;

public class genericsSort {
    public static void main(String[] args) {
        Integer[] values = {1,9,2,8,6,4,7,3};

        System.out.println("Indexen til den største verdien mellom intervallene er: " + maxValue(values,2,values.length-1));
        //Halvåpent intervall: (2,3]
        System.out.println("Største tallet mellom intervallene er: " + values[maxValue(values,2,3)]);
        sort(values);
        System.out.println(Arrays.toString(values));

        Character[] charValues = {'a','b','c','k','u','4'};
        int index1 = maxValue(charValues, 0, charValues.length);
        System.out.println("Største verdi er på index " + index1);
        sort(charValues);
        System.out.println(Arrays.toString(charValues));
    }

    
    //Denne funksjonen finner indeksen til største heltall
    //Innenfor intervalled [begin,end]
    public static <T extends Comparable <? super T>> void sort(T[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            int maxIndex = maxValue(values, i, values.length);

            T temp = values[i];
            values[i] = values[maxIndex];
            values[maxIndex] = temp;
        }
    }


    public static <T extends Comparable <? super T>> int maxValue(T[] values, int begin, int end) {
        T currentMax = values[begin];
        int currentIndex = begin;

        for (int i = begin + 1; i < end; i++) {
            if (values[i].compareTo(currentMax) > 0) {
                currentMax = values[i];
                currentIndex = i;
            }
        }
        return currentIndex;
    }
    
}
