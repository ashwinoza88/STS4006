package Stack;

import java.util.Scanner;
import java.util.Stack;

public class StackPermutation {
    public static void stackPermutation(int[] A, int[] B, int n) {
        Stack<Integer> st = new Stack<>();
        int j=0;
        for (int i = 0; i < n; i++) {
            st.push(A[i]);

            while(!st.isEmpty() && B[j] == st.peek()){
                st.pop();
                j++;
            }

        }

        if(st.isEmpty()){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }

        stackPermutation(A,B,n);
    }
}
