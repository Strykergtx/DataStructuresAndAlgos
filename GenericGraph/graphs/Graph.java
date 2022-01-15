package com.example.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<V,E> {


    private Map<V, List<E>> map = new HashMap<>();

    public void addVertex(V v)
    {
        map.put(v, new LinkedList<E>());
    }

    public void addEdge(V v,E e)
    {

        if (!map.containsKey(v))
            addVertex(v);
        else
         map.get(v).add(e);
    }


    public String printState()
    {
        StringBuilder builder = new StringBuilder();

        for (V v : map.keySet()) {
            builder.append(v.toString()).append(": ");
            for (E e : map.get(v)) {
                builder.append(e.toString()).append(" ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }

}
