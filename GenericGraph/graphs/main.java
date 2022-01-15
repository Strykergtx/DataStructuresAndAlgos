package com.example.graphs;

public class main {


    public static void addToGraph(int sourceVertexId,int edgeWeight,int destinationVertexId,Graph<Vertex,Edge> g)
    {
        Vertex sourceVertex = new Vertex(sourceVertexId);

        Edge edge = new Edge(edgeWeight,destinationVertexId);

        g.addEdge(sourceVertex,edge);

    }


    public static void main(String args[]) {

        Graph<Vertex,Edge> g = new Graph<Vertex,Edge>();

        addToGraph(1,20,7,g);
        addToGraph(1,45,2,g);
        addToGraph(1,35,5,g);
        addToGraph(1,22,6,g);
        addToGraph(1,15,9,g);

        addToGraph(2,15,8,g);
        addToGraph(2,15,15,g);
        addToGraph(2,15,10,g);

        System.out.println(g.printState());
    }
}