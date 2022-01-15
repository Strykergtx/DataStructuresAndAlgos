package com.example.graphs;

import java.util.Objects;

public class Vertex {
    int id;
    String name;
    String age;
    String profession;

    Vertex(int id)
    {
        this.id = id;

    }

    Vertex(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    Vertex(int id, String name, String profession)
    {
        this.id = id;
        this.name = name;
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return id == vertex.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString()
    {
        return ("SourceVertexId: "+this.id);
    }
}
