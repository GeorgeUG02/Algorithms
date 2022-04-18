package com.company;

public interface Tree<E extends Comparable<? super E>> {

    enum TraversMode {
        IN_ORDER, PRE_ORDER, POST_ORDER
    }

    boolean contains(E value);

    InsertedAndLevel add(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    void display();

    void traverse(TraversMode mode);
    public static class InsertedAndLevel{
        public boolean inserted;
        public int level;
        public InsertedAndLevel(boolean inserted,int level){
            this.inserted=inserted;
            this.level=level;
        }
    }
}