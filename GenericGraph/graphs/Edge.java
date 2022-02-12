package com.example.graphs;

public class Edge {

    int weight;
    int toVertexId;

    Edge(int weight,int toVertexId)
    {
        this.weight =weight;
        this.toVertexId = toVertexId;
    }

    @Override
    public String toString()
    {
        return (" Edge to vertex :"+toVertexId+" with weight"+weight +", ");
    }
}
