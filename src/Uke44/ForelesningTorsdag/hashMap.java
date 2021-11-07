package Uke44.ForelesningTorsdag;

import java.util.ArrayList;
import java.util.LinkedList;

public class hashMap {
    public static void main(String[] args) {
        System.out.println("Hashmap test");

        int hashmapSize = 7;
        ArrayList<LinkedList<String>> hash_map = new ArrayList<>(hashmapSize);
        
        for (int i = 0; i < hashmapSize; i++) {
            hash_map.add(i, new LinkedList<>());
        }   

        String[] strings = {"Hei", "På deg din gmale sjokolade", "Peder","Test","Hallo"};

        for (int i = 0; i < strings.length; i++) {
            int hash = hash(strings[i]);
            //index der den skal settes inn i listen
            int hashmapindex = computeHashmapIndex(hash, hashmapSize);
            System.out.println("Legger inn " + strings[i] + " med hash " + hash + " på plass " + hashmapindex);
            hash_map.get(hashmapindex).addFirst(strings[i]);
        }

        int hash = hash("Test");
        int hash_map_index = computeHashmapIndex(hash, hashmapSize);
        System.out.println(hash_map.get(hash_map_index));
    }

    public static int computeHashmapIndex(int hash, int hashmapSize) {
        return hash % hashmapSize;
    }

    public static int hash(String data) {
        int hash = 0;

        //Sum av alle bokstavene (ikke optimalt);
        /*
        for (int i = 0; i < data.length(); i++) {
            hash = hash + (int) data.charAt(i);
        }
        */

        for (int i = data.length() - 1; i >= 0; i--) {
            char c = data.charAt(i);
            hash = (hash + c) * 31;
        }

        if (hash < 0) {
            hash = -hash;
        }
        return hash;
    }
    
}
