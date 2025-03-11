package Graphs;

import java.util.*;
public class BellManFord {

    static class edge{
        int u,v,w;
        edge(int u,int v,int w)
        {
            this.u=u;
            this.v=v;
            this.w=w;
        }

    }

    static void bellman(ArrayList<edge> al,int v,int s)
    {
        int dis[]=new int[v];
        for(int i=0;i<v;i++)
        {
            dis[i]=Integer.MAX_VALUE;
        }
        dis[s]=0;
        for(int i=0;i<v-1;i++)
        {
            for(edge e:al)
            {
                if(dis[e.u]!=Integer.MAX_VALUE && dis[e.u]+e.w<dis[e.v])
                {
                    dis[e.v]=dis[e.u]+e.w;
                }
            }
        }
         for(edge e:al)
            {
                if(dis[e.u]!=Integer.MAX_VALUE && dis[e.u]+e.w<dis[e.v])
                {
                    System.out.print("Negative cycle");
                    return;
                }
            }
            for(int i=0;i<v;i++)
            {
                System.out.print((dis[i] == Integer.MAX_VALUE ? "INF" : dis[i]) + " ");
            }
            System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        ArrayList<edge> al=new ArrayList<>();
        for(int i=0;i<e;i++)
        {
            int eu=sc.nextInt();
            int ev=sc.nextInt();
            int ew=sc.nextInt();
            al.add(new edge(eu,ev,ew));
        }
        bellman(al,v,0);

    }
}
