package Trees;
import java.util.*;

class RandLView {

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
    
        void RV(Node root, int l, ArrayList<Integer> al){
            if(root==null){
                return;
            }
            if(al.size()==l){
                al.add(root.data);
            }
            if(root.right !=null){
                RV(root.right, l+1, al);
            }
            if(root.left!=null){
                RV(root.left, l+1, al);
            }   
        }
    
        void LV(Node root, int l, ArrayList<Integer> al){
            if(root==null){
                return;
            }
            if(al.size()==l){
                al.add(root.data);
            }
            if(root.left !=null){
                LV(root.left, l+1, al);
            }
            if(root.right!=null){
                LV(root.right, l+1, al);
            }   
        }
    }
    public static void main(String[] args) {
        BT t = new BT();
        Node root = t.create();
        ArrayList<Integer> alLeft = new ArrayList<>();
        ArrayList<Integer> alRight = new ArrayList<>();

        t.RV(root, 0, alRight);
        t.LV(root, 0, alLeft);

        System.out.println("The left view of the BT is : ");
        System.out.println(alLeft);
        System.out.println("The right view of the BT is : ");
        System.out.println(alRight);
    }
}
