package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    public static class Vertex{
        public char label;
        public boolean wasVisited;
        public int d = 0;
        public Vertex(char label) {
            this.label = label;
            this.wasVisited = false;
        }
    }
    private int size;
    private int[][] adjMatrix;
    private Vertex[] vertexList;
    public Graph(Vertex[] vertexList){
        this.vertexList = vertexList;
        adjMatrix = new int[vertexList.length][vertexList.length];
        size= vertexList.length;
    }
    public int size(){
        return size;
    }
    public void addEdge(int start, int end, int weight){
        adjMatrix[start][end] = weight;
    }
    public void displayVertex(int vertex){
        System.out.println(vertexList[vertex].label);
    }
    private int getAdjUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if(adjMatrix[ver][i] > 0 && ((vertexList[i].wasVisited == false)||((vertexList[i].wasVisited == true)&& (vertexList[ver].d +adjMatrix[ver][i] <vertexList[i].d)))){
                return i;
            }
        }
        return -1;
    }
    public int findShortestPath(int source, int finish){
        vertexList[source].wasVisited = true;
        displayVertex(source);
        Queue<Integer> queue= new LinkedList<Integer>();
        queue.add(source); // Вставка в конец очереди
        int v2;
        while(!queue.isEmpty()){
            int v1 = queue.remove();
            if (v1==finish) continue;
            while((v2=getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].wasVisited = true;// Пометка
                vertexList[v2].d = vertexList[v1].d + adjMatrix[v1][v2];
                displayVertex(v2);// Вывод
                queue.add(v2);
            }
        }
        int d = vertexList[finish].d;
        for(int i=0; i<size; i++) {// Сброс флагов
            vertexList[i].d = 0;
            vertexList[i].wasVisited = false;
        }
        return d;
    }
}
