package Uke35;

public class nestMaks {
    public static void main(String[] args) {
        int[] a = {3,9,11,5,7,17,4};

        System.out.println(finnNestMaks(a, 3, 6));
    }
    
    // Finner største og nest største tall i et array ved å kjøre gjennom array ved bruk av en for loop
    // Starter med int i = 2, fordi vi har allerede initialisert nestMaks og Maks til de to første verdiene i arrayet
    // Hvis a[i] er større enn nestMaks, vil vi sjekke om den er større enn maks, hvis den er det, setter vi maks = a[i]
    // Ellers setter vi a[i] = nestMaks
    static int finnNestMaks(int[] a, int fra, int til) {
        if (til - fra < 2) {
            throw new ArrayIndexOutOfBoundsException("Ikke nok tall");
        }
        if (fra < 0) {
            throw new ArrayIndexOutOfBoundsException("Et negativt tal");
        }
        if (til > a.length -1) {
            throw new ArrayIndexOutOfBoundsException("Til er ikke lang nok");
        }

        int nestMaks = Math.min(a[fra],a[fra+1]);
        int maks = Math.max(a[fra],a[fra+1]);
        
        for (int i = fra + 2; i < til; i++) {
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
