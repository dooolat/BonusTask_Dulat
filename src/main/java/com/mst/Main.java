package com.mst;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int n = 6;

        List<Edge> edges = List.of(
                new Edge(0, 1, 4),
                new Edge(0, 2, 3),
                new Edge(1, 2, 1),
                new Edge(1, 3, 2),
                new Edge(2, 3, 4),
                new Edge(3, 4, 2),
                new Edge(4, 5, 6)
        );

        // Build MST
        List<Edge> mst = KruskalMST.findMST(n, new ArrayList<>(edges));
        System.out.println("Initial MST:");
        mst.forEach(System.out::println);

        // Remove one edge
        Edge removed = mst.remove(1);
        System.out.println("\nRemoved edge: " + removed);

        // Components after removal
        UnionFind uf = new UnionFind(n);
        for (Edge e : mst) uf.union(e.u, e.v);

        System.out.println("\nComponents:");
        for (int i = 0; i < n; i++)
            System.out.println("Node " + i + " -> component " + uf.find(i));

        // Replacement edge
        Edge replacement = null;

        for (Edge e : edges) {
            if (uf.find(e.u) != uf.find(e.v)) {
                if (replacement == null || e.weight < replacement.weight)
                    replacement = e;
            }
        }

        System.out.println("\nReplacement edge: " + replacement);

        mst.add(replacement);

        System.out.println("\nNew MST:");
        mst.forEach(System.out::println);
    }
}
