package Graphs;

import java.util.Scanner;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<n-k; i++){
            int max = Integer.MIN_VALUE;
            for(int j= i; j<k+i; j++){
                if(arr[j]>max){
                    max = arr[j];
                }
            }
            System.out.print(max + " ");
        }
        System.out.println();
    }
}
