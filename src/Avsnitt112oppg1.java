public class Avsnitt112oppg1 {
    public static void main(String[] args) {
        int[] values = {8,4,17,10,6,20,1,11,15,3,18,9,2,7,19};
        min(values);

        int minValue = min(values);
        System.out.println(minValue);

    }

    static int min(int[] values) {

        int minValue = values[0];
        int pos = 0;

        for (int i = 1; i < values.length; i++) {
            if (minValue > values[i]) {
                minValue = values[i];
                pos = i;
            }
        }
        return minValue;
    }
}
