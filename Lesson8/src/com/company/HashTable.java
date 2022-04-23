package com.company;

public class HashTable <K,V>{
    static class Node<K,V>{
        public K key;
        public V value;
        public Node next;
        public Node(K key,V value){
            this.key=key;
            this.value=value;
            this.next=null;
        }
        public String toString(){
            return key.toString() + " -> "+value.toString();
        }
    }
    private Node[] data;
    private int size;
    public HashTable(int capacity){
        data = new Node[capacity];
    }
    public int getSize(){
        return size;
    }
    public boolean put(K key,V value){
        if (key==null) return false;
        int i = hashFunction(key);
        Node<K,V> n = data[i];
        if (n==null) data[i] = new Node<K,V>(key,value);
        else {
            while (n.next != null) {
                n = n.next;
            }
            n.next = new Node<K, V>(key, value);
        }
        size++;
        return true;
    }
    public V find(K key){
        if (key==null) return null;
        int i = hashFunction(key);
        Node<K,V> n = data[i];
        while (n!=null){
            if (n.key.equals(key)) return n.value;
            n=n.next;
        }
        return null;
    }
    public boolean remove(K key){
        if (key==null) return false;
        int i = hashFunction(key);
        Node<K,V> n = data[i];
        Node<K,V> prev=null;
        while (n!=null){
            if (n.key.equals(key)) break;
            prev=n;
            n=n.next;
        }
        if (n==null) return false;
        else {
            if (prev==null) data[i]=null;
            else {
                prev.next=n.next;
            }
        }
        return true;
    }
    public void display(){
        for (int i=0;i< data.length;i++){
            Node<K,V> n = data[i];
            while (n!=null){
                System.out.println(n);
                n=n.next;
            }
        }
    }
    private int hashFunction(K key){
        return key.hashCode()% data.length;
    }
}
