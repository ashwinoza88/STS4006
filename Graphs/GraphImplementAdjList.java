package Graphs;
import java.util.*;
class GraphImplementAdjList{
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

        for(int i=0; i<v; i++){
            System.out.println("vertex " + i + " :");
            for(int j=0; j<l.get(i).size(); j++){
                System.out.print(l.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}