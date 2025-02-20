package Trees;
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;

    Node(int d){
        data = d;
        this.left = null;
        this.right = null;
    }
}
class BT{
    Node root = null;

    Node create(){
        Scanner sc = new Scanner(System.in);
        int rd = sc.nextInt();
        if(rd==-1){
            return null;
        }

        root = new Node(rd);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node curr = q.poll();
            int ld = sc.nextInt();
            if(ld!=-1){
                Node lnode = new Node(ld);
                curr.left = lnode;
                q.add(lnode);
            }
            int rnd = sc.nextInt();
            if(rnd!=-1){
                Node rnode = new Node(rnd);
                curr.right = rnode;
                q.add(rnode);
            }
        }
        return root;
    }

    void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root==null){
            return;
        }

        q.add(root);

        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }

    }
}

class BTImplementation{
    public static void main(String[] args) {
        BT t = new BT();
        t.root = t.create();
        t.levelOrder(t.root);
    }
}