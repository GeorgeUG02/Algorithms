package com.company;

public class Main {
    public static void main(String[] args) {
         HashTable<String,Integer> ht= new HashTable<>(10);
         ht.put("a",5);
         ht.put("b",8);
         ht.put("c",4);
         ht.display();
         ht.remove("b");
         int v = ht.find("c");
         System.out.println(v);
         ht.display();
    }
}
