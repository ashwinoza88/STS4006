package LinkedList.DLL;

import java.util.Scanner;

public class SortTheBitonicDLL {
    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int d){
            this.data = d;
            this.prev = null;
            this.next = null;
        }
    }

    static Node head = null;

    static Node tail = null;

    static void insert(int d){
        if(head == null){
            Node newn = new Node(d);
            head = newn;
            tail = newn;
        }
        else{
            Node newn = new Node(d);
            tail.next = newn;
            newn.prev = tail;
            tail = tail.next;
        }
    }

    static void display(Node head){
        Node temp = head;
        while(temp.next!=null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }

    static Node sort(Node head){
        if(head==null || head.next == null) return head;

        Node last = head;
        while(last.next!=null){
            last = last.next;
        }

        Node front = head;
        Node result = new Node(-1);
        Node tail = result;

        while(front!=null && last!=null && front!=last && last.next!=front){
            Node newn;
            if(front.data<last.data){
                newn = new Node(front.data);
                front = front.next;
            }
            else{
                newn = new Node(last.data);
                last = last.prev;
            }
            tail.next = newn;
            newn.prev = tail;
            tail = tail.next;
            
        }

        
        if(front==last){
            Node newn = new Node(front.data);
            tail.next = newn;
            newn.prev = newn;
            tail = tail.next;
        }

        return result.next;
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

        Node newHead = sort(head);
        System.out.println("DLL after bitonic sort");
        display(newHead);
    }
}
