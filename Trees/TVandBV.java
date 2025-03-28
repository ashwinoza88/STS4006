package Trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TVandBV {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }
    
    static class BT{
        Node root;
    
        Node create(){
            Scanner sc = new Scanner(System.in);
            int rd = sc.nextInt();
            if(rd==-1){
                return null;
            }
            root = new Node(rd);
    
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                Node curr = q.poll();
                
                int ld = sc.nextInt();
                if(ld!=-1){
                    Node newn = new Node(ld);
                    curr.left = newn;
                    q.add(newn);
                }
                int rnd = sc.nextInt();
                if(rnd!=-1){
                    Node newn = new Node(rnd);
                    curr.right = newn;
                    q.add(newn);
                }
            }
            return root;
        }
    
        void BV(Node root, ArrayList<Integer> al){
            if(root==null){
                return;
            }
            if(root.left==null && root.right == null){
                al.add(root.data);
                return;
            }
            BV(root.left, al);
            BV(root.right, al);
        }
    
        void TV(Node root, ArrayList<Integer> al){
            if(root==null){
                return;
            }
            Stack<Integer> st = new Stack<>();
            ArrayList<Integer> temp = new ArrayList<>();
            
            onlyLeft(root, st);
            onlyRight(root.right, temp);

            while(!st.isEmpty()){
                al.add(st.pop());
            }

            for(int i=0; i<temp.size(); i++){
                al.add(temp.get(i));
            }
        }

        void onlyLeft(Node root, Stack<Integer> st){
            if(root==null){
                return;
            }
            st.add(root.data);
            onlyLeft(root.left, st);
        }

        void onlyRight(Node root, ArrayList<Integer> al){
            if(root==null){
                return;
            }
            al.add(root.data);
            onlyRight(root.right, al);
        }
    }
    public static void main(String[] args) {
        BT t = new BT();
        Node root = t.create();
        ArrayList<Integer> altop = new ArrayList<>();
        ArrayList<Integer> albottom = new ArrayList<>();

        t.BV(root, albottom);
        t.TV(root, altop);

        System.out.println("The top view of the BT is : ");
        System.out.println(altop);
        System.out.println("The bottom view of the BT is : ");
        System.out.println(albottom);
    }

}
