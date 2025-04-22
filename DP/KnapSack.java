package DP;
import java.util.Scanner;

public class KnapSack {

    public static int knap(int wt[], int p[], int c, int ind){

        if(ind == 0){
            if(wt[0]<=c){
                return p[0];
            }else{
                return 0;
            }
        }
        int exclude = 0+ knap(wt, p, c, ind-1);
        int include = 0;

        if(wt[ind]<=c){
            include = p[ind] + knap(wt, p, c-wt[ind], ind-1);
        }

        return Math.max(include, exclude);
    }

    public static int knapwithmem(int wt[], int p[], int c, int ind, int dp[][]){

        if(ind==0)
        {
            if(wt[0]<=c)
            {
                return p[0];
            }
            else{
                return 0;
            }
        }
        if(dp[ind][c]!=-1)
        {
            return dp[ind][c];
        }
        int exclude=0+knapwithmem(wt,p,c,ind-1,dp);
        int include=0;
        if(wt[ind]<=c)
        {
            include=p[ind]+knapwithmem(wt,p,c-wt[ind],ind-1,dp);
        }
        return dp[ind][c]=Math.max(include,exclude);
    }

    public static void knapwithtab(int wt[], int p[], int c, int ind, int dp[][]){
        for(int j=wt[0]; j<=c; j++){
            dp[0][j] = wt[0];
        }
        int n = p.length;

        for(int i=1; i<n; i++){
            for(int j=0; j<=c; j++){
                int exclude = 0+dp[i-1][j];
                int include = 0;
                if(wt[i]<=j){
                    include = p[i] + dp[i-1][j-wt[i]];
                }
            }
        }
        System.out.println(dp[n-1][c]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] wt = new int[n];
        int p[] = new int[n];
        for(int i=0; i<n; i++){
            wt[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        int c = sc.nextInt();
        System.out.println(knap(wt, p, c, n-1));
    }

    
}
