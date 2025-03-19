package Trees;
import java.util.*;
class SegmentTree{
    static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        Node(int start, int end){
            startInterval = start;
            endInterval = end;
        }
    }

    static Node root;

    public static void segmenttree(int[] arr){
        root = constructTree(arr,0,arr.length-1);
    }

    private static Node constructTree(int[] arr, int start, int end){
        if(start==end){
            Node leafNode = new Node(start, end);
            leafNode.data = arr[start];
        }

        Node newn = new Node(start, end);
        int mid = (start + end)/2;

        newn.left = constructTree(arr, start, mid);
        newn.right = constructTree(arr, mid+1, end);

        newn.data = newn.left.data + newn.right.data;

        return newn;
    }

    public static int query(int qsi, int qei){
        return query(root, qsi, qei);
    }

    private static int query(Node node, int qsi, int qei){
        if(node.startInterval>= qsi && node.endInterval<=qei){
            return node.data;
        }
        else if(node.startInterval>qei || node.endInterval<qsi){
            return 0;
        }
        else{
            return query(node.left, qsi, qei) + query(node.right , qsi, qei);
        }
    }

    public static void update(int index, int value){
        root.data = update(root, index, value);
    }

    private static int update(Node node, int index, int value){
        if(index>=node.startInterval && index<=node.endInterval){
            if(index == node.startInterval && index == node.endInterval){
                node.data = value;
                return node.data;
            }
            else{
                int left = update(node.left, index, value);
                int right = update(node.right, index, value);
                node.data = left + right;
                return node.data;
            }
        }

        return node.data;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 8, 2, 7, 16};
        segmenttree(arr);
        update(3, 5);

        
    }
}