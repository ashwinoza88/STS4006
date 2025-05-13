package Stack;
import java.util.*;
public class MinStack {

    static Stack<Integer> st = new Stack<>();
    static Stack<Integer> mst = new Stack<>();

    public static void push(int d){
        st.push(d);
        if(mst.isEmpty()){
            mst.push(d);
        }else{
            if(mst.peek()>d){
                mst.push(d);
            }
        }
    }

    public static void pop(){
        int temp = st.pop();
        if(temp == mst.peek()) {
            mst.pop();
        }
    }

    public static int getMin(){
        if(mst.isEmpty()){
            return -1;
        }
        else{
            return mst.peek();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            push(arr[i]);
        }

        pop();
        System.out.println(getMin());

        pop();
        System.out.println(getMin());

        pop();
        System.out.println(getMin());


    }
}
