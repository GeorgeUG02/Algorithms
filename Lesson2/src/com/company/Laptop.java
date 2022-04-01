package com.company;

public class Laptop implements Comparable<Laptop>{
    int price;
    int ram;
    Producer producer;
    Laptop(int pr,int r,Producer prod){
        price=pr;
        ram=r;
        producer=prod;
    }
    @Override
    public String toString(){
        return price + " " + ram + " " + producer.toString();
    }
    public static void insertionSort (Laptop [] laptops){
        int in, out;
        for(out = 1;out < laptops.length; out++){
            Laptop temp = laptops[out];
            in = out;
            while(in > 0 && laptops[in-1].compareTo(temp) > 0){
                laptops[in] = laptops[in-1];
                --in;
            }
            laptops[in] = temp;
        }
    }
    @Override
    public int compareTo(Laptop l) {
        if (price >l.price) return 1;
        else if (price<l.price) return -1;
        else {
            if (ram>l.ram) return 1;
            else if (ram<l.ram) return -1;
            else return producer.compareTo(l.producer);
        }
    }
}
