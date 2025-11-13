package com.mst;

import java.util.*;

public class KruskalMST {

    public static List<Edge> findMST(int n, List<Edge> edges) {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(n);

        List<Edge> mst = new ArrayList<>();

        for (Edge e : edges) {
            if (uf.union(e.u, e.v)) {
                mst.add(e);
            }
        }

        return mst;
    }
}
