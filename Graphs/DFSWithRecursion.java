package Graphs;
import java.util.*;
public class DFSWithRecursion{
    static LinkedList<Integer> adj[];
    static class graph{
        graph(int v){
            adj = new LinkedList[v];
            for(int i=0;i<v;i++) adj[i]=new LinkedList<Integer>();
        }
    }
    static void insertedge(int s,int d){
        adj[s].add(d);
        adj[d].add(s);
    }
    static void dfs(int sr,boolean vis[]){
        vis[sr] = true;
        System.out.print(sr+" ");
        for(int i:adj[sr]) if(!vis[i]) dfs(i,vis);
    }
    public static void main(String ar[]){
        Scanner sw = new Scanner(System.in);
        int v = sw.nextInt();
        int e = sw.nextInt();
        graph g = new graph(v);
        for(int i=0;i<e;i++){
            int s = sw.nextInt();
            int d = sw.nextInt();
            insertedge(s,d);
        }
        int sr = sw.nextInt();//from which vertex traversal starts
        boolean vis[]=new boolean[v];
        dfs(sr,vis);
    }
}