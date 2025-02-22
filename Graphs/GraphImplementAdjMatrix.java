package Graphs;
import java.util.*;
class GraphImplementAdjMatrix{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        int[][] adj = new int[v][v];

        for(int i=0; i<e; i++){
            int s = sc.nextInt();
            int d = sc.nextInt();

            adj[s][d] = 1;
            adj[d][s] = 1;

        }

        System.out.println("Following is the adjacency matrix :");
        for(int i=0; i<adj.length; i++){
            for(int j=0; j<adj[0].length; j++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}