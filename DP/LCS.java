package DP;

import java.util.Arrays;
import java.util.Scanner;

public class LCS {

    public static int lcs_tabulation(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] dp = new int[t1.length+1][t2.length+1];
        for(int i=0; i<=t1.length; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<=t2.length; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<=t1.length; i++){
            for(int j= 1; j<=t2.length; j++){
                if(t1[i-1] == t2[j-1]) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[t1.length][t2.length];
    }

    public static int lcs_memoization(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] dp = new int[t1.length+1][t2.length+1];
        for(int[] i: dp){
            Arrays.fill(i,-1);
        }
        return helper(text1.length()-1, text2.length()-1,t1, t2, dp);
    }

    public static int helper(int ind1, int ind2, char[] t1, char[] t2, int[][] dp){
        if(ind1 <0 || ind2<0) return 0;

        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(t1[ind1] == t2[ind2]) return 1 + helper(ind1-1,ind2-1, t1,t2,dp);
        return dp[ind1][ind2] = Math.max(helper(ind1-1,ind2,t1,t2,dp), helper(ind1,ind2-1,t1,t2,dp));
    }

    public static int lcs_recursion(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] dp = new int[t1.length+1][t2.length+1];
        for(int i=0; i<=t1.length; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<=t2.length; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<=t1.length; i++){
            for(int j= 1; j<=t2.length; j++){
                if(t1[i-1] == t2[j-1]) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[t1.length][t2.length];
    }

    public static int helper2(int ind1, int ind2, char[] t1, char[] t2, int[][] dp){
        if(ind1 <0 || ind2<0) return 0;

        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(t1[ind1] == t2[ind2]) return 1 + helper(ind1-1,ind2-1, t1,t2,dp);
        return dp[ind1][ind2] = Math.max(helper(ind1-1,ind2,t1,t2,dp), helper(ind1,ind2-1,t1,t2,dp));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text1 = sc.nextLine();
        String text2 = sc.nextLine();
        //tabulation
        System.out.println(lcs_tabulation(text1, text2));

        //memoization
        System.out.println(lcs_memoization(text1, text2));

        //recursion
        System.out.println(lcs_recursion(text1, text2));

        
    }
}
