package com.company;

public class Producer implements Comparable<Producer>{
    int pr;
    Producer(int p){
        if (p<0|| p>4) throw new IllegalArgumentException();
        pr=p;
    }
    @Override
    public int compareTo(Producer o) {
        if (pr>o.pr) return 1;
        else if (pr<o.pr) return -1;
        else return 0;
    }
    @Override
    public String toString(){
        String [] s = {"Xamiou","Eser","MacNote","Asos","Lenuvo"};
        return s[pr];
    }
}

