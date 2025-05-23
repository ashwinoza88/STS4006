package Graphs;
import java.util.*;
class BFS{

    static void bfs(LinkedList<LinkedList<Integer>> l, int sr, int v){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[v];

        if(vis[sr]==false){
            q.add(sr);
            vis[sr] = true;

            while(!q.isEmpty()){
                int t = q.poll();
                System.out.print(t + " ");
                for(int adj : l.get(t)){
                    if(vis[adj] == false){
                        q.add(adj);
                        vis[adj] = true;
                    }
                }
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

        int sr = sc.nextInt();
        bfs(l, sr, v);
    }
}