package com.company;


public class Main {
    public static void main(String[] args) {
          int [] a = {1, 2 ,3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
          System.out.println(findMissingInteger(a));
          int [] b = {1, 2, 4, 5, 6};
          System.out.println(findMissingInteger(b));
          int [] c = {2, 3, 4, 5, 6, 7, 8};
          System.out.println(findMissingInteger(c));
          int [] d = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
          System.out.println(findMissingInteger(d));
          int [] e = {};
          System.out.println(findMissingInteger(e));
    }
    public static int findMissingInteger(int [] a){
        if (a.length==0) return 1;
        if (a.length ==1) {
            if (a[0]==2) return 1;
            else if (a[0]==1) return 2;
            else throw new RuntimeException("неверные входные данные");
        }
        if ((a[a.length-1]!=(1+a.length))&&(a[a.length-1]!=(a.length))) throw new RuntimeException("неверные входные данные");
        return findMissingInteger(a,0,a.length-1);
    }
    public static int findMissingInteger(int [] a,int start,int end){
        if ((start==end) && a[start]==start + 2) return start+1;
        if ((start==end) && a[start]==start + 1) return start+2;
        if ((start==end) && a[start]!=start + 2 && a[start]!=start+1) throw new RuntimeException("неверные входные данные");
        int middle = (int) Math.floor((end+start)/2.0);
        if ((a[middle]!=middle+1) && (a[middle]!=middle+2)) throw new RuntimeException("неверные входные данные");
        if ((middle==start)&&(a[middle]==middle+2)) return middle+1;
        if (a[middle]==middle+2) return findMissingInteger(a,start,middle);
        if (a[middle]==middle+1) return findMissingInteger(a,middle+1,end);
        return a[a.length-1]+1;
    }
}
