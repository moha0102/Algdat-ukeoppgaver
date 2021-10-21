package Uke37.ForelesningMandag;

public class Ternaryif {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int a = i;
            int b = myTernaryIfTest(a);
            System.out.println(b);
        }

        int a = 17;
        //int b = (value < 5) ? 0 : 98;
    }

    public static int myTernaryIfTest(int value) {
        return (value < 5) ? 0 : 98;
    }
}
