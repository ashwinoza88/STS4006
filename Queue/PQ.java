package Queue;
import java.util.*;
public class PQ {
    static class Node{
        int data;
        Node next;
        Node prev;
        int p;

        Node(int d, int p){
            this.data = d;
            this.p = p;
        }
    }

    static Node front = null;
    static Node rear = null;

    static void display(Node front){
        Node temp = front;
        while(temp!=null){
            System.out.println(temp.data+" "+ temp.p);
        }
    }
    void insert(int d, int p){
        Node newn = new Node(d, p);
        if(front == null){
            front = rear = newn;
        }else if(p<=front.p){
            newn.next = front;
            front.prev = newn;
            front  = newn;
        }else{
            Node temp = front;
            while(temp.next !=null && temp.next.p<=p){
                temp = temp.next;
            }
            if(temp.next!=null){
                newn.next = temp.next;
                temp.next.prev = newn;
                temp.next = newn;
                newn.prev = temp;
            }else {
                temp.next = newn;
                newn.prev = temp;
                rear = newn;
            }
        }
    }
}
