package DP;
import java.util.*;
public class LISDP{
    static int LIS(int a[],int i,int p,int dp[][])
    {
        if(i==a.length)
        {
            return 0;
        }
        if(dp[p+1][i]!=-1)
        {
            return dp[p+1][i];
        }
        int exclude=0+LIS(a,i+1,p,dp);
        int include=0;
        if(p==-1 || a[i]>a[p])
        {
            include=1+LIS(a,i+1,i,dp);
        }
        return dp[p+1][i]= Math.max(exclude,include);
    }
    public static void main(String aeg[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        int dp[][]=new int[n][n+1];
        for(int[] i: dp)
        {
            Arrays.fill(i,-1);
        }
        System.out.println(LIS(a,0,-1,dp));
        

        //tabulation

        int[][] dp1 = new int[n+1][n+1];
        
        for(int ind = n-1; ind >= 0; ind--){
            for(int prev = ind-1; prev >= -1; prev--){
                // not take
                int notTake = dp1[ind+1][prev+1];

                // take
                int take = 0;
                if(prev == -1 || a[ind] > a[prev]){
                    take = 1 + dp1[ind+1][ind+1];
                }

                dp1[ind][prev+1] = Math.max(take, notTake);
            }
        }
        
        System.out.println(dp1[0][0]);
    }
}