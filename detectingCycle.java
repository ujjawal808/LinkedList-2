 //In the we have to detect whether a node contains a cycle or not
import java.util.*;
public class detectingCycle{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;//+1;
            fast=fast.next.next;//+2;\
            if(slow==fast){
                System.out.println("Cycle is detected:"+" ");//check if s and f is equal at any point then there is a cycle.
                return true;
                
            } 
        }
        return false;//No cyclen exists.
    }
    public static void main(String args[]){
        detectingCycle ll=new detectingCycle();
        ll.head = new Node(1);
        ll.head.next=new Node(2);
        ll.head.next.next=new Node(3);
        ll.head.next.next.next=head;//1->2->3->1 cycle exists.
        System.out.println(ll.isCycle());



    }
}
