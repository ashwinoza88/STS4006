package Trees;
import java.util.*;
public class RecoverBST {
    static class Node{
        int data;
        Node left, right;

        Node(int d){
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    static class BT{
        Node root = null;
        Node first = null;
        Node mid = null;
        Node last = null;
        Node prev = null;

        Node create(){
            Scanner sc = new Scanner(System.in);
            int rnd = sc.nextInt();
            if(rnd == -1){
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

        void recoverBST(Node root){
            if(root==null){
                return;
            }

            inOrder(root);
            if(first!=null && last !=null){
                int temp = first.data;
                first.data =  last.data;
                last.data = temp;
            }
            else{
                int temp = mid.data;
                mid.data = first.data;
                first.data = temp;
            }
        }

        void inOrder(Node root){
            if(root== null){
                return;
            }
            inOrder(root.left);
            if(prev!=null && prev.data>root.data){

                if(first == null){
                    first = prev;
                    mid = root;
                }
                else{
                    last = root;
                }
            }
            prev = root;
            inOrder(root.right);
            
        }

        void levelOrder(Node root){
            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                Node curr = q.poll();
                System.out.print(curr.data + " ");

                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BT t = new BT();
        t.root = t.create();
        t.recoverBST(t.root);
        t.levelOrder(t.root);
    }

}
