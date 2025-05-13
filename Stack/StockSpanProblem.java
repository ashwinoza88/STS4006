package Stack;
import java.util.*;
public class StockSpanProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = i+1;
            }else{
                ans[i] = i - st.peek();
            }

            st.push(i);
        }

        System.out.println(Arrays.toString(ans));
    }
}
