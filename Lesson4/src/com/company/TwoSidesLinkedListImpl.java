package com.company;

import java.util.Iterator;

public class TwoSidesLinkedListImpl<E> implements TwoSidesLinkedList<E>,Iterable<E>{
    protected Node<E> first;
    protected Node<E> last;
    protected int size;
    @Override
    public void insertLast(E value) {
        size++;
        if (isEmpty()){
            first =new Node<E>(value,null,null);
            last=first;
            return;
        }
        last.next = new Node<E>(value,last,null);
        last=last.next;
    }

    @Override
    public E getLast() {
        return last.value;
    }

    @Override
    public void insertFirst(E value) {
        size++;
          if (isEmpty()){
              first = new Node<E>(value,null,null);
              last = first;
              return;
          }
          first.prev = new Node<E>(value,null,first);
          first = first.prev;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        E e = first.value;
        first = first.next;
        size--;
        if (size > 0) {
            first.prev.next=null;
            first.prev = null;
        }
        return e;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        E e = last.value;
        last=last.prev;
        size--;
        if (size > 0) {
            last.next.prev=null;
            last.next = null;
        }
        return e;
    }

    @Override
    public boolean remove(E value) {
        Node<E> n = findLeft(value);
        if (n==null) return false;
        if (n.equals(first)) {
            removeFirst();
        }
        else if (n.equals(last)){
            removeLast();
        }
        else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            size--;
        }
        return true;
    }

    @Override
    public boolean contains(E value) {
        return findLeft(value)!=null;
    }
    public Node<E> findLeft(E value){
        Node<E> current = first;

        while (current != null) {
            if (current.value.equals(value)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }
    public Node<E> findRight(E value){
        Node<E> current = last;

        while (current != null) {
            if (current.value.equals(value)) {
                return current;
            }
            current = current.prev;
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void display() {
         System.out.println(this);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node<E> current = first;

        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.append("]").toString();

    }
    @Override
    public E getFirst() {
        return first.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>(this);
    }
    class LinkedListIterator<E> implements Iterator<E>{
        protected Node<E> current;
        protected TwoSidesLinkedListImpl<E> list;
        LinkedListIterator (TwoSidesLinkedListImpl<E> l) {
            list = l;
            current=l.first;
        }
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public E next() {
            E e = current.value;
            current=current.next;
            return e;
        }
    }
}
