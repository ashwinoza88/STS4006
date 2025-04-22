package DP;
import java.util.*;

public class RodCuttingProblem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p[] = new int[n];
        for(int i=0; i<n; i++){
            p[i] = sc.nextInt();
        }

        System.out.println(funWithRecursion(p,n-1,n));

        int[][] dp = new int[n][n+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        System.out.println(funWithMemoization(p, n-1, n, dp));
    }

    public static int funWithMemoization(int[] p, int i, int n, int[][] dp){
        if(i==0) return n*p[i];
        if(dp[i][n]!=-1){
            return dp[i][n];
        }

        int exclude = 0 + funWithMemoization(p,i-1,n,dp);
        int include = 0;
        int rodlen = i+1;
        if(rodlen<=n){
            include = p[i] + funWithMemoization(p, i, (n-rodlen),dp);
        }
        return dp[i][n] = Math.max(exclude, include);
    }

    public static int funWithRecursion(int[] p, int i, int n){
        if(i==0) return n*p[i];
        int exclude = 0 + funWithRecursion(p,i-1,n);
        int include = 0;
        int rodlen = i+1;
        if(rodlen<=n){
            include = p[i] + funWithRecursion(p, i, (n-rodlen));
        }
        return Math.max(exclude, include);
    }
}