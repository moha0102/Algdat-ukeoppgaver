package Uke36.ForelesningTirsdag;

public class Binærtsortering {
 public static void main(String[] args) {
     int[] values = {1,6,3,2,5,8,7,9};
     int index1 = binarySearch(values, 9);
     System.out.println("Fant tallet 9 på " + index1);

     int index2 = binarySearchRecursive(values, 9, 0, values.length-1);
     System.out.println( "Fant tallet 9 på " + index2);
 }   

 public static int binarySearch(int[] values, int search_values) {
    //Intervaller:
    //Halvåpent intervall:
    //[8,10) => 8, 9
    //(8,10] => 9, 10
    //Lukket intervall:
    //[8,10] => 8, 9, 10

    //Søk etter 6
    //[ l       m         r ]
    //[ a b c d 9 f g h i j ]
    //[ 0 1 2 3 4 5 6 7 8 9 ]

    //[ l m  r              ]
    //[ a 2 c d 9 f g h i j ]
    //[ 0 1 2 3 4 5 6 7 8 9 ]

    //[     l r             ]
    //[ a 2 5 d 9 f g h i j ]
    //[ 0 1 2 3 4 5 6 7 8 9 ]
    //(l+r)/2 //(2+3)/2 = 2

    //[       l r           ]
    //[ a 2 5 7 9 f g h i j ]
    //[ 0 1 2 3 4 5 6 7 8 9 ]
    //(l+r)/2 //(2+3)/2 = 2

    //values.length = 10
    // l = 0 //left index 0
    // r = 9 //right index 9
    // (l + r) / 2 //m = ( 9 + 0 ) / 2 = 4 //middle 
    //midten = (values.length-1)/2


    int l = 0;
    int r = values.length - 1;
    int m = (l+r) / 2;

    while(l <= r) {        
        m = (l+r)/2;
        if (values[m] > search_values) {
            r = m - 1;
        } else if (values[m] < search_values) {
            l = m + 1;
        } else if (values[m] == search_values) {
            return m;
        } else {
            System.out.println("Something wrong!;");
        }
        //Fant ikke verdien
        
    }
    return -1;
 }

    public static int binarySearchRecursive(int[] values, int search_values, int l, int r) {
        int m = (l+r) / 2;

        if(values[m] > search_values) {
            r = m - 1;
            return binarySearchRecursive(values, search_values, l, r);
        } else if (values[m] < search_values) {
            l = m+1;
            return binarySearchRecursive(values, search_values, l,r);
        } else if (values[m] == search_values) {
            return m;
        }
        return -1;
    }
}
