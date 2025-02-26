package Trees;
import java.util.*;
public class BSTWithTraversal
{
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

    static class BST{
        Node root;
    
        Node insert(Node root, int val){
            if(root == null){
                return new Node(val);
            }
            
            else if(val<root.data){
                root.left = insert(root.left, val);
            }
            else{
                root.right = insert(root.right, val);
            }
        
            return root;
        }
    
        void preOrder(Node root){
            if(root == null) return;
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    
        void postOrder(Node root){
            if(root == null) return;
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    
        void inOrder(Node root){
            if(root == null) return;
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
	
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    BST t = new BST();
	    System.out.println("Enter the no node to be entered in the BST");
	    int n = sc.nextInt();
	    System.out.println("Enter the value one by one");
	    for(int i=0; i<n; i++){
	        int d = sc.nextInt();
	        t.root = t.insert(t.root, d);
	    }
	    t.preOrder(t.root);
	    System.out.println();
	    t.postOrder(t.root);
	    System.out.println();
	    t.inOrder(t.root);
	}
}
