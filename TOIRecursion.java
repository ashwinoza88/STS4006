import java.util.Scanner;

public class TOIRecursion {

    static void toi(int n, String src, String helper, String dest){
        if(n==1){
            System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        toi(n-1, src, dest, helper);
        System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
        toi(n-1, helper, dest, src);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        toi(n, "S", "H", "D");
    }
}
