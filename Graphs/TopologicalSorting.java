package Graphs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSorting {

    public static void dfs(ArrayList<ArrayList<Integer>> al, int v){
        boolean[] vis = new boolean[v];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<v; i++){
            if(vis[i]== false){
                helper(al,i,vis,st);
            }
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void helper(ArrayList<ArrayList<Integer>> al, int i, boolean[] vis, Stack<Integer> st){
        vis[i] = true;
        for(int adj:al.get(i)){
            if(vis[adj]== false){
                helper(al, adj, vis, st);
            }
        }
        st.push(i);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0; i<v; i++){
            al.add(new ArrayList<>());
        }

        for(int i=0; i<e; i++){
            int s = sc.nextInt();
            int d = sc.nextInt();
            al.get(s).add(d);
        }

        dfs(al, v);
    }
}
