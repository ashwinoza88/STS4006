package Trees;
import java.util.*;
class AVL{
    static class Node{
        int data;
        Node left;
        Node right;
        int height;

        Node(int d){
            data = d;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    static int height(Node n){
        if(n==null) return 0;
        return n.height;
    }
    
    static Node rightRotation(Node y){
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return x;
    }

    static Node leftRotation(Node x){
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    static int getBalance(Node n){
        if(n==null) return 0;
        return height(n.left) - height(n.right);
    }

    static Node insert(Node root, int d){
        if(root==null){
            return new Node(d);
        }

        if(d<root.data){
            root.left = insert(root.left, d);
        }
        else if(d>root.data){
            root.right = insert(root.right, d);
        }
        else{
            return root;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int bal = getBalance(root);

        if(bal>1 && d < root.left.data){
            return rightRotation(root);
        }
        if(bal<-1 && d> root.right.data){
            return leftRotation(root);
        }
        if(bal>1 && d>root.left.data){
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
        if(bal<-1 && d<root.right.data){
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        return root;
    }

    static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 60);

        System.out.println("Pre Order Traversal : ");
        preOrder(root);
    }
}