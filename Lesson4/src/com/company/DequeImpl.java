package com.company;

import java.util.Iterator;

public class DequeImpl<E> implements Deque<E>,Iterable<E>{
    protected final TwoSidesLinkedListImpl<E> data;
    DequeImpl(){
        this.data=new TwoSidesLinkedListImpl<E>();
    }
    @Override
    public boolean insertLeft(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E removeLeft() {
        return data.removeFirst();
    }

    @Override
    public E removeRight() {
        return data.removeLast();
    }

    @Override
    public E pickFirst() {
        return data.getFirst();
    }

    @Override
    public E pickLast() {
        return data.getLast();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }
}
