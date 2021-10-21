package Uke38.ForelesningMandag;

public class Recursion {

    public static int recursiveFuction(int value) {
        System.out.println("Recursive Value: " + value);
        if (value <= 5) {
            return -9;
        } else {
            return recursiveFuction(value - 1);
        }
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n*factorial(n-1);
        }
        
    }
    public static void main(String[] args) {
        int value = 15;
        System.out.println("Main: " + recursiveFuction(value));
        //5! = 5*4*3*2*1;

        int fakulitet = factorial(5);
        System.out.println("5! = " + fakulitet);
        System.out.println("8! = " + factorial(8));
        System.out.println("52! = " + factorial(52));
    }
}
