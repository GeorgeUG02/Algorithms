package com.company;

public class Main {
    public static void main(String[] args) {
         Graph.Vertex [] vertexList = {new Graph.Vertex('A'),new Graph.Vertex('B'),new Graph.Vertex('C'),new Graph.Vertex('D'),new Graph.Vertex('E'),
                 new Graph.Vertex('F'),new Graph.Vertex('G'),new Graph.Vertex('H'),new Graph.Vertex('I'),new Graph.Vertex('J')};
         Graph g = new Graph(vertexList);
         g.addEdge(0,1,3);
         g.addEdge(0,2,2);
         g.addEdge(0,3,5);
         g.addEdge(1,4,4);
         g.addEdge(2,5,6);
         g.addEdge(3,6,4);
         g.addEdge(4,9,7);
         g.addEdge(5,7,4);
         g.addEdge(6,8,5);
         g.addEdge(7,9,1);
         g.addEdge(8,9,2);
         int d = g.findShortestPath(0,9);
         System.out.println("Кратчайшее расстояние между вершинами A и J : " + d);
    }
}
