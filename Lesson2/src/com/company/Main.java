package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n = 10000;
        int[] prices = generatePrices(n);
        int[] rams = generateRams(n);
        int[] producers = generateProducers(n);
        Laptop[] laptops = new Laptop[n];
        for (int i=0;i<n;i++){
            laptops[i] = new Laptop(prices[i],rams[i],new Producer(producers[i]));
        }
        Laptop.insertionSort(laptops);
    }

    private static int[] generateProducers(int n) {
        int [] prod = new int[n];
        Random r = new Random();
        for (int i=0;i<n;i++){
            prod[i]=r.nextInt(5);
        }
        return prod;
    }

    private static int[] generateRams(int n) {
        int [] rams = new int[n];
        Random r = new Random();
        for (int i=0;i<n;i++){
            rams[i]=4+r.nextInt(6)*4;
        }
        return rams;
    }

    private static int[] generatePrices(int n) {
        int [] p = new int[n];
        Random r = new Random();
        for (int i=0;i<n;i++){
            p[i]=50+r.nextInt(40)*50;
        }
        return p;
    }
}