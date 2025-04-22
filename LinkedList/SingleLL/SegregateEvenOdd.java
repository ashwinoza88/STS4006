package LinkedList.SingleLL;

import java.util.*;

public class SegregateEvenOdd {

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

    static Node segregate(Node head){
        Node temp = head;
        Node evenHead = new Node(-1);
        Node oddHead = new Node(-1);
        Node ptr1 = evenHead;
        Node ptr2 = oddHead;

        if(head== null || head.next == null) return head;

        while(temp!=null){
            if(temp.data %2 == 0){
                ptr1.next = new Node(temp.data);
                ptr1 = ptr1.next;
            }
            else{
                ptr2.next = new Node(temp.data);
                ptr2 = ptr2.next;
            }
            temp = temp.next;
        }
        if(ptr1== evenHead){
            return oddHead.next;
        }
        else if(ptr2==oddHead){
            return evenHead.next;
        }
        else{
            ptr1.next = oddHead.next;
        }

        return evenHead.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of elements to enter");
        int n = sc.nextInt();
        Node head = null;
        System.out.println("Enter the elements one by one ");
        for(int i=0; i<n; i++){
            head = insert(head, sc.nextInt());
        }

        System.out.println("The entered LL is:");
        display(head);

        System.out.println("LL after segregating even and odd");
        Node newHead = segregate(head);
        display(newHead);
    }
}
