package com.company;

public class Knapsack {
    public boolean[] takenThings;
    public int sumPrice;
    public int sumWeight;
    public Knapsack(boolean[] takenThings,int sumPrice,int sumWeight){
        this.takenThings=takenThings;
        this.sumPrice=sumPrice;
        this.sumWeight=sumWeight;
    }
}
