package Graphs;

import java.util.LinkedList;
import java.util.Scanner;

public class DFSSimple {

    public static void dfs(LinkedList<LinkedList<Integer>> l, int sr, boolean[] vis){
        vis[sr] = true;
        System.out.print(sr + " ");  // Print the node when visiting

        for (int adj : l.get(sr)) {
            if (!vis[adj]) { // Corrected condition
                dfs(l, adj, vis);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // Number of vertices
        int e = sc.nextInt(); // Number of edges

        LinkedList<LinkedList<Integer>> l = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            l.add(new LinkedList<>());
        }

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            l.get(s).add(d);
            l.get(d).add(s); // Since the graph is undirected
        }

        boolean[] vis = new boolean[v];

        int sr = sc.nextInt(); // Start node for DFS
        dfs(l, sr, vis);

        sc.close(); // Close scanner to prevent resource leak
    }
}
