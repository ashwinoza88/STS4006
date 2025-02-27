package Trees;
import java.util.*;
class VerticalOrderTraversal{
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class Qnode{
        Node tnode;
        int v;
        int l;

        Qnode(Node tnode, int v, int l){
            this.tnode = tnode;
            this.v = v;
            this.l = l;
        }
    }

    static class BST{
        Node root = null;
        Node create(Node root, int d){
            if(root == null){
                return new Node(d);
            } else if(d<root.data){
                root.left = create(root.left, d);
            } else{
                root.right = create(root, d);
            }

            return root;
        }

        void vertical(Node root){
            if(root==null){
                return;
            }
            TreeMap<Integer,TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();
            Queue<Qnode> q = new LinkedList<>();
            q.add(new Qnode(root, 0, 0));
            while(!q.isEmpty()){
                Qnode curr = q.poll();
                int ver = curr.v;
                int lev = curr.l;
                map.putIfAbsent(ver, new TreeMap<>());
                map.get(ver).putIfAbsent(lev, new ArrayList<>());
                map.get(ver).get(lev).add(curr.tnode.data);

                if(curr.tnode.left!=null){
                    q.add(new Qnode(curr.tnode, ver-1, lev+1));
                }
                if(curr.tnode.right!=null){
                    q.add(new Qnode(curr.tnode.right, ver+1, lev+1));
                }
            }

            for(TreeMap<Integer, ArrayList<Integer>> level : map.values()){
                for(ArrayList<Integer> al : level.values()){
                    for(int n:al){
                        System.out.println(n + " ");
                    }
                }
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            BST tree = new BST();
            System.out.println("Enter the no of nodes");
            int n = sc.nextInt();
            System.out.println("Enter the node values");
            for(int i=0; i<n; i++){
                int value = sc.nextInt();
                tree.root = tree.create(tree.root, value);
            }
            System.out.println("Vertical Order Traversal:");
            tree.vertical(tree.root);
        }


    }
}