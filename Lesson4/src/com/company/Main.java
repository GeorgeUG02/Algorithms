package com.company;

public class Main {

    public static void main(String[] args) {
         DequeImpl <Integer> d = new DequeImpl<Integer>();
         d.insertLeft(5);
         d.insertRight(10);
        for (int a:d) {
            System.out.println(a);
        }
        d.removeLeft();
        d.display();
    }
}
