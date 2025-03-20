package Trees;

import java.util.Scanner;

public class WinnerTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int size = 2*k-1;
        int[] tree = new int[size];
        for(int i=k-1; i<size; i++){
            tree[i] = sc.nextInt();
        }
        for(int i=k-2; i>=0; i--){
            if(tree[2*i+1]<tree[2*i+2]){
                tree[i] = tree[2*i+1];
            }else{
                tree[i] = tree[2*i+2];
            }
        }
        System.out.println(tree[0]);
    }
}