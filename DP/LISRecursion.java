import java.util.*;
class LISRecursion {

    public static int helper(int[] arr, int i, int p){
        if(i==arr.length) return 0;
        int exclude = 0 + helper(arr, i+1, p);
        int include = 0;
        if(p==-1 || arr[i]>arr[p]){
            include = 1 + helper(arr, i+1, p);
        }
        return Math.max(include, exclude);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt;
        int[] arr = new int[n];
        System.out.println(helper(arr, 0, -1));

    }
}
