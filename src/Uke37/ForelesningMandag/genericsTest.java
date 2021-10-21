package Uke37.ForelesningMandag;

import java.lang.reflect.Constructor;

public class genericsTest {
    public static void main(String[] args) {
        Integer[] a = {1,8,9,18,98,2,3,9};
        Character[] b = {'A','C','K','Z','L','Y','M'};
        String[] c = {"ASF", "Kari", "poteter", "lammelår", "eple", "Petter"};
        Person[] d = {new Person("Petter", "Pettesen"), new Person("Kari", "Pettersen"), new Person("Nils", "Abrahamsen")};

        System.out.println("Maks av int-tabell");
        System.out.println(maks(a));

        System.out.println("Maks av char-array");
        System.out.println(maks(b));

        System.out.println("Generic Maks av int-array");
        System.out.println(maks_generic(a));

        System.out.println("Generic Maks av char-array");
        System.out.println(maks_generic(b));

        System.out.println("Generic Maks av string-array");
        System.out.println(maks_generic(c));

        System.out.println("Generic Maks av person-array");
        System.out.println(maks_generic(d));
    }

    public static class Person implements Comparable<Person> {
        String firstName;
        String lastName;

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public int comparTo(Person other) {
            //if this.lastName < other.lastName {return -1};
            int lastCompare = this.lastName.compareTo(other.lastName);

            if (lastCompare == 0) {
                return this.firstName.compareTo(other.firstName);
            } else {
                return lastCompare;
            }
        }

        @Override
        public int compareTo(Person o) {
            // TODO Auto-generated method stub
            return 0;
        }
    }

    public static <T extends Comparable <? super T>> int maks_generic (T[] values) {
        T currentMax = values[0];
        int currentIndex = 0;

        for (int i = 1; i < values.length; i++) {
            //if (values[i] > currentMax) {
            if (values[i].compareTo(currentMax) > 0 ) {
                currentMax = values[i];
                currentIndex = i;
            }
        }
        return currentIndex;
    }

    public static int maks (Integer[] values) {
        int currentMax = values[0];
        int currentIndex = 0;

        for (int i = 1; i < values.length; i++) {
            if (values[i] > currentMax) {
                 currentMax = values[i];
                 currentIndex = i;
            }
        }
        return currentIndex;
    }

    public static int maks (Character[] values) {
        char currentMax = values[0];
        int currentIndex = 0;

        for (int i = 1; i < values.length; i++) {
            if (values[i] > currentMax) {
                 currentMax = values[i];
                 currentIndex = i;
            }
        }
        return currentIndex;
    }
}
