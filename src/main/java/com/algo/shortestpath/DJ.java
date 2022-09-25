package com.algo.shortestpath;


import java.util.*;

public class DJ {

}

class Solution {

    int countPaths(int n, List<List<Integer>> roads) {
        Map<Integer, List<Pair>> adj = new HashMap<> ();

        for (int i = 0; i < roads.size (); i++) {
            int u = roads.get (i).get (0);
            int v = roads.get (i).get (1);
            int w = roads.get (i).get (2);

            List<Pair> paths_u = adj.get (u);

            if (paths_u != null && !paths_u.isEmpty ()) {
                paths_u.add (new Pair (v, w));
                adj.put (u, paths_u);
            } else {
                List<Pair> list = new ArrayList<> ();
                list.add (new Pair (v, w));
                adj.put (u, list);
            }

            List<Pair> paths_v = adj.get (v);

            if (paths_v != null && !paths_v.isEmpty ()) {
                paths_v.add (new Pair (u, w));
                adj.put (v, paths_v);
            } else {
                List<Pair> list = new ArrayList<> ();
                list.add (new Pair (u, w));
                adj.put (v, list);
            }
        }


        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<> ();

        //initial node distance
        pq.offer (new Pair (0, dist[0]));

        int ways = 0;
        int mod = 1000000007;

        while (!pq.isEmpty ()) {
            Pair pair = pq.remove ();

            for( Pair p : adj.get (pair.v)) {
                int vertex = p.v;
                int weight = p.wt;

                if( vertex == (n-1)) {
                    if(dist[vertex] == dist[pair.v] + weight)  ways =(ways+1)%mod;
                    continue;
                }

                if( dist[vertex] > dist[pair.v] + weight) {
                    dist[vertex] = dist[pair.v] + weight;
                    pq.add (new Pair (vertex, dist[vertex]));
                }
            }


        }
        return dist[n-1] % mod;
    }

    class Pair implements Comparable<Pair> {

        int wt;
        int v;

        public Pair(int v, int wt) {
            this.wt = wt;
            this.v = v;
        }

        @Override
        public int compareTo(Solution.Pair o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) {
        Integer[][] arr = new Integer[][]{{0,6,7}, {0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        List<List<Integer>> list = new ArrayList<> ();

        for( int i=0; i < arr.length; i++) {
            Integer[] ints = arr[i];
            list.add(Arrays.asList (ints));
        }

        Solution sol = new Solution();
        System.out.println (sol.countPaths (7, list));
    }
}