package com.company;

public interface TwoSidesLinkedList<E> {
    void insertLast(E value);
    E getLast();
    void insertFirst(E value);

    E removeFirst();
    E removeLast();
    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    E getFirst();

    class Node<E> {
        E value;
        Node<E> prev;
        Node<E> next;

        public Node(E value,Node<E> prev, Node<E> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
