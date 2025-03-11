package Graphs;

import java.util.LinkedList;
import java.util.Scanner;

public class DFSSimple {

    public static void dfs(LinkedList<LinkedList<Integer>> l, int sr, boolean[] vis){
        vis[sr] = true;
        for(int adj:l.get(sr)){
            if(vis[adj]!=true){
                System.out.print(sr+" ");
                dfs(l,adj,vis);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        LinkedList<LinkedList<Integer>> l = new LinkedList<>();
        for(int i=0; i<v; i++){
            l.add(new LinkedList<>());
        }

        for(int i=0; i<e; i++){
            int s = sc.nextInt();
            int d = sc.nextInt();

            l.get(s).add(d);
            l.get(d).add(s);

        }

        boolean[] vis = new boolean[v];

        int sr = sc.nextInt();
        dfs(l,sr,vis);
    }
}
