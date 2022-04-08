package com.company;

public interface Deque<E> {
    boolean insertLeft(E value);
    boolean insertRight(E value);
    E removeLeft();
    E removeRight();
    E pickFirst();
    E pickLast();
    int size();
    boolean isEmpty();
    boolean isFull();
    void display();
}
