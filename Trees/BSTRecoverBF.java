package Trees;

import java.util.*;

class BSTRecoverBF{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            data = d;
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
                int ln = sc.nextInt();
                if(ln!=-1){
                    Node newn = new Node(ln);
                    curr.left = newn;
                    q.add(newn);
                }
                int rn = sc.nextInt();
                if(rn!=-1){
                    Node newn = new Node(rn);
                    curr.right = newn;
                    q.add(newn);
                }
            }
            return root;
        }
        
        void inOrderTraversal(Node root, ArrayList<Node> nodes, ArrayList<Integer> values){
            if(root == null){
                return;
            }
            inOrderTraversal(root.left, nodes, values);
            nodes.add(root);
            values.add(root.data);
            inOrderTraversal(root.right, nodes, values);
        }

        void recoverBST(Node root){
            ArrayList<Node> nodes = new ArrayList<>();
            ArrayList<Integer> values = new ArrayList<>();
            inOrderTraversal(root, nodes, values);
            Collections.sort(values);
            for(int i=0; i<nodes.size(); i++){
                if(nodes.get(i).data != values.get(i)){
                    nodes.get(i).data = values.get(i);
                }
            }
        }

        void levelOrder(){
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
            System.out.println();
        }
        
    }

    public static void main(String[] args) {
        BT t = new BT();
        Node root = t.create();
        System.out.println("The level order of input tree");
        t.levelOrder();
        t.recoverBST(root);
        System.out.println("The level order of recovered BST");
        t.levelOrder();
    }
}