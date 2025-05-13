package Stack;
import java.util.*;
public class TheCelebrityProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            st.push(i);
        }

        while(st.size()>1){
            int x = st.pop();
            int y = st.pop();

            if(arr[x][y]==1){
                st.push(y);
            }else{
                st.push(x);
            }

        }

        int c = st.pop();
        for(int i=0; i<n; i++){
            if(i!=c && (arr[c][i] == 1 || arr[i][c]==0)){
                System.out.println("No celebrity");
                return;
            }
        }
        System.out.println(c);
    }
}
