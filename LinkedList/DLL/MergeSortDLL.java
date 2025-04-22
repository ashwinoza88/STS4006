package LinkedList.DLL;
import java.util.*;
public class MergeSortDLL {
    static class Node{
        int data;
        Node next;
        Node prev;
        
        Node(int d){
            this.data = d;
            this.next = null;
            this.prev = null;
        }
    }

    static Node head = null;
    static Node tail = null;

    static void display(Node head){
        if(head==null){
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }

    static void insert(int d){
        if(head==null){
            head = new Node(d);
            tail = head;
        }else{
            Node newn = new Node(d);
            newn.prev = tail;
            tail.next = newn;
            tail = tail.next;
        }
    }

    static Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast.next!= null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node sortDoubly(Node head){
        if(head==null || head.next == null) return head;

        Node mid = findMid(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;
        right.prev = null;

        left = sortDoubly(left);
        right = sortDoubly(right);

        Node result = merge(left,right);
        return result;
    }

    static Node merge(Node left, Node right){
        if(left == null) return right;
        if(right == null) return left;

        Node ans = new Node(-1);
        Node temp = ans;

        while(left!=null && right!=null){
            if(left.data<right.data){
                temp.next = left;
                left.prev = temp;
                left = left.next;
                temp = temp.next;

            }
            else{
                temp.next = right;
                right.prev = temp;
                right = right.next;
                temp = temp.next;
            }
        }

        while(left!=null){
            temp.next = left;
            left.prev = temp;
            temp = temp.next;
            left = left.next;
        }

        while (right!=null) {
            temp.next = right;
            right.prev = temp;
            temp = temp.next;
            right = right.next;
        }

        ans = ans.next;
        ans.prev = null;

        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of element to enter in the DLL");
        int n = sc.nextInt();
        System.out.println("Enter the elements one by one");
        for(int i=0; i<n; i++){
            insert(sc.nextInt());
        }
        display(head);

        Node newHead = sortDoubly(head);
        System.out.println("DLL after applying Merge Sort");
        display(newHead);
    }


}
