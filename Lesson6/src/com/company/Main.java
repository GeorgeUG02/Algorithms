package com.company;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
         Tree<Integer> t = new TreeImpl<Integer>();
         Random r = new Random();
         int level=0;
         while (level<6){
             Tree.InsertedAndLevel il = t.add(r.nextInt(201)-100);
             level = il.level;
         }
         t.display();
    }
}
