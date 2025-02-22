package Trees;
import java.util.*;
class BoundaryTraversal{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BT{
        Node root;

        Node create(){
            Scanner sc = new Scanner(System.in);
            int rnd = sc.nextInt();
            if(rnd==-1){
                return null;
            }
            root = new Node(rnd);

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                Node curr = q.poll();
                int ld = sc.nextInt();
                if(ld!=-1){
                    Node newn = new Node(ld);
                    curr.left = newn;
                    q.add(newn);
                }
                int rd = sc.nextInt();
                if(rd!=-1){
                    Node newn = new Node(rd);
                    curr.right = newn;
                    q.add(newn);
                }
            }
            return root;
        }
    }

    static void LB(Node root, ArrayList<Integer> al){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }

        al.add(root.data);

        if(root.left!=null){
            LB(root.left, al);
        }
        else{
            LB(root.right, al);
        }
    }

    static void leaf(Node root, ArrayList<Integer> al){

        if(root==null){
            return;
        }

        if(root.left==null && root.right == null){
            al.add(root.data);
            return;
        }

        leaf(root.left, al);
        leaf(root.right, al);
    }

    static void RB(Node root, Stack<Integer> st ){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }

        st.add(root.data);

        if(root.right!=null){
            RB(root.right, st);
        }
        else{
            RB(root.left, st);
        }
    }

    public static void main(String[] args) {
        BT t = new BT();
        Node root = t.create();
        ArrayList<Integer> al = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        LB(root, al);
        leaf(root, al);
        RB(root.right, st);

        while(!st.isEmpty()){
            int temp = st.pop();
            al.add(temp);
        }

        System.out.println(al);
    }


}