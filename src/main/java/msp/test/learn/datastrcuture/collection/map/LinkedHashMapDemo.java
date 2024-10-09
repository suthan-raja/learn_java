package msp.test.learn.datastrcuture.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

    public static void main(String[] args) {

        Map<String , Integer> hashMap = new LinkedHashMap<>();

        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.put("C", 3);
        hashMap.put("D", 4);
        hashMap.put("E", 5);
        hashMap.put(null, 6);

        System.out.println("HashMap : "+hashMap);
        hashMap.remove(null , 6);

        System.out.println("After Remove : "+hashMap);
        hashMap.putIfAbsent("Z", 26);

        System.out.println("After putIfAbsent : "+hashMap);
        hashMap.putIfAbsent("Z", 29);

        System.out.println("After Put Same Key Diff Values : "+hashMap);

        // Loop Values In HashMap

        // Way - 1

        for( Map.Entry<String , Integer> val : hashMap.entrySet() ){
            System.out.println(val.getKey() + " : " + val.getValue());
        }

        // Way - 2

        for( String keys : hashMap.keySet()){
            System.out.println(keys + " : " + hashMap.get(keys));
        }

        // Way - 3

        for( Integer values : hashMap.values()){
            System.out.println(values);
        }
    }

}
