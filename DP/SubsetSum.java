package DP;
import java.util.*;
public class SubsetSum {
    public static boolean subsetRecursion(int ind, int target, int[] arr){
        if(target==0) return true;
        if(ind==0) return arr[0] == target;

        boolean exclude = subsetRecursion(ind-1, target, arr);
        boolean include = false;
        if(arr[ind]<=target){
            include = subsetRecursion(ind-1, target-arr[ind], arr);
        }

        return include || exclude;

    }

    public static boolean subsetMemoization(int ind, int target, int[] arr, int dp[][]){
        if(target==0) return true;
        if(ind==0) return arr[0] == target;

        if(dp[ind][target]!=-1) return dp[ind][target] == 1;

        boolean exclude = subsetRecursion(ind-1, target, arr);
        boolean include = false;
        if(arr[ind]<=target){
            include = subsetRecursion(ind-1, target-arr[ind], arr);
        }

        dp[ind][target] = (include || exclude) ? 1 : 0;

        return dp[ind][target]==1;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(subsetRecursion(n-1, target, arr));
        int[][] dp1 = new int[n][target+1];
        
        for(int[] i : dp1){
            Arrays.fill(i,-1);
        }

        // System.out.println(subsetMemoization(n-1, target, arr, dp1));


        //tabulation
        boolean[][] dp2 = new boolean[n][target+1];
        for(int i=0; i<=n-1; i++){
            dp2[i][0]=true;
        }
        dp2[0][arr[0]] = true;

        for(int i=1; i<=n-1; i++){
            for(int j = 0; j<=target; target++){
                boolean exclude = dp2[i-1][j];
                boolean include = false;

                if(arr[i]<=target){
                    include = dp2[i-1][j-arr[i]];
                }

                dp2[i][j] = include || exclude;
            }
        }

        System.out.println(dp2[n-1][target]);
    }
}
