package LinkedList.SingleLL;

import java.util.Scanner;

public class FloydsCycleAlgo {
    static class Node{
        int data;
        Node next;

        Node(int d){
            this.data = d;
            this.next = null;
        }
    }
    static Node insert(Node head, int d){
        if(head == null){
            return new Node(d);
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = new Node(d);
        return head;
    }
    

    static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    static boolean detectLoop(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of elements to enter");
        int n = sc.nextInt();
        System.out.println("Enter the elements one by one");
        Node head = null;
        for(int i=0; i<n; i++){
            head = insert(head, sc.nextInt());
        }

        System.out.println("The entered LL is given below");
        display(head);

        System.out.println("Enter the index of the node where you want to create the loop");
        int l = sc.nextInt();
        Node temp = head;
        for(int i=0; i<=l; i++){
            temp = temp.next;
        }
        Node LastNode = head;
        while(LastNode.next!=null){
            LastNode = LastNode.next;
        }

        LastNode.next = temp;

        if(detectLoop(head)){
            System.out.println("The LinkedList has a loop");
        }else{
            System.out.println("The LinkedList doesn't have a loop");
        }


    }
}
