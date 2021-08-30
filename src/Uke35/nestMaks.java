package Uke35;

public class nestMaks {
    public static void main(String[] args) {
        int[] a = {3,9,11,5,14,17,4};

        System.out.println(finnNestMaks(a));
    }

    static int finnNestMaks(int[] a) {
        int nestMaks = Math.min(a[0],a[1]);
        int maks = Math.max(a[0],a[1]);

        for (int i = 2; i < a.length; i++) {
            if (a[i] > nestMaks) {
                if (a[i] > maks) {
                    nestMaks = maks;
                    maks = a[i];
                } else {
                    nestMaks = a[i];
                }
            } 
        }
        return nestMaks;
    }
    
}
