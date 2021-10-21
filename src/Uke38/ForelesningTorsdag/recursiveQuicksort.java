package Uke38.ForelesningTorsdag;

public class recursiveQuicksort {
    public static void main(String[] args) {
        
    }

    public static void quickSort(int[] values, int left, int right) {
        // (1) Bytt midterste verdi i arrayet til slutten
            // - Se på verdien, dette er skilleverdien/vippepunkt (pivot)
            int m = (left+right)/2;
            int pivot = values[m];
            values[m] = values[right];
            values[right] = pivot;
        // (2) Partisjoner arrayet fra start til "nest siste verdi" (siste kort er midt kortet)
            // - Flytt alt som er større enn eller lik skilleverdi til høyre
            // - Flytt alt som er mindre enn skilleverdi til venstre
            // - Ta vare på indexen til den siste verdien som er mindre enn pivoten
            int index = partition(values, pivot, left, right-1);


        // (3) Flytt skilleverdien (sist i arrayet) tilbake til riktig sortert plass
            // - Rett til høyre for siste verdi som er mindre enn skilleverdi i punkt 2
            int temp = values[index+1];
            values[index+1] = values[right];
            values[right] = temp;
        // (4) Gjenta for høyere sub-array og venstre sub-array

    }

    /**
     * Partisjonerer arrayet basert på en skilleverdi
     * Vi plasserer alle verdier som er mindre enn pivot til venstre
     * Og alle verdier som er større eller lik pivot til høyre
     * Vi returnerer indeksen til slutt
     * @param values
     * @param pivot
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] values, int pivot,int left, int right) {
        
        return -1;
    }
}
