package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static int[] prices = {40000,5000,100,37000,10000};
    public static int[] weights = {4,1,5,3,2};
    public static int maxWeight = 5;
    public static ArrayList<Knapsack> knapsacks= new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(pow(4.2,5));
        System.out.println(pow(-3.7,-2));
        Knapsack k = knapsackSolve();
        System.out.println("taken things " + Arrays.toString(k.takenThings) + " ,sumPrice " + k.sumPrice + " ,sumWeight " + k.sumWeight);
    }
    public static Knapsack knapsackSolve(){
        boolean [] ts = new boolean[prices.length];
        int sumP=0;
        int sumW=0;
        for (int i=0;i<prices.length;i++){
            sumP=sumP+prices[i];
            sumW=sumW+weights[i];
            ts[i]=true;
        }
        if (sumW>maxWeight) removeThings(sumP,sumW,ts);
        else knapsacks.add(new Knapsack(ts,sumP,sumW));
        boolean [] ts2 = new boolean[prices.length];
        Knapsack k =new Knapsack(ts2,0,0);
        for (int i=0;i<knapsacks.size();i++){
             if (k.sumPrice<knapsacks.get(i).sumPrice) k = knapsacks.get(i);
        }
        return k;
    }
    public static void removeThings(int sumP,int sumW,boolean [] ts){
        for (int i=0;i<ts.length;i++){
            if (ts[i]==true){
                sumP=sumP-prices[i];
                sumW=sumW-weights[i];
                ts[i]=false;
                if (sumW>maxWeight) removeThings(sumP,sumW,ts);
                else {
                    boolean [] ts2=new boolean[ts.length];
                    for (int j=0;j<ts.length;j++){
                        ts2[j]=ts[j];
                    }
                    knapsacks.add(new Knapsack(ts2,sumP,sumW));
                }
                ts[i]=true;
                sumP=sumP+prices[i];
                sumW=sumW+weights[i];
            }
        }
    }
    public static double pow(double b, int n){
        if (b==0) {
            if (n<=0) throw new ArithmeticException("деление на ноль");
            else return 0;
        }
        if (b==1) return 1;
        if (n==0) return 1;
        double r;
        if (n>0){
            r = b;
            for (int i=1;i<n;i++){
               r=r*b;
            }
        }
        else{
            r = 1 / b;
            for (int i=1;i<-n;i++){
                r=r/b;
            }
        }
        return r;
    }
}
