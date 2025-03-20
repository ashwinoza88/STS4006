package Graphs;
import java.util.*;
class DialsAlgorithm{
    static class edge{
        int v;
        int w;
        edge(int v,int w)
        {
            this.v=v;
            this.w=w;
        }
    }
    static void dials(ArrayList<ArrayList<edge>> al,int v,int max,int sr)
    {
        int dis[]=new int[v];
        for(int i=0;i<v;i++)
        {
            dis[i]=Integer.MAX_VALUE;
        }
        dis[sr]=0;
        ArrayList<Queue<Integer>> l=new ArrayList<>();
        for(int i=0;i<(v*max);i++)
        {
            l.add(new LinkedList<>());
        }
        l.get(0).add(sr);
        int ind=0;
        while(ind<l.size())
        {
            while(!l.get(ind).isEmpty())
            {
                int u=l.get(ind).poll();
                for(edge e:al.get(u))
                {
                    if(dis[u]+e.w<dis[e.v])
                    {
                        dis[e.v]=dis[u]+e.w;
                        l.get(dis[e.v]).add(e.v);
                    }
                }
            }
            ind++;
        }
        System.out.print(Arrays.toString(dis));
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
      int e=sc.nextInt();
      ArrayList<ArrayList<edge>> al=new ArrayList<>();
      for(int i=0;i<n;i++)
      {
          al.add(new ArrayList<>());
      }
      for(int i=0;i<e;i++)
      {
          int u=sc.nextInt();
          int v=sc.nextInt();
          int w=sc.nextInt();
          al.get(u).add(new edge(v,w));
      }
      int max=sc.nextInt();
      dials(al,n,max,0);
    }   
}
