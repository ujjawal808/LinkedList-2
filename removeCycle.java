public class removeCycle {
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
    public  void isRemove(){
        // Detect cycle
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
                 break;
            }
        }
        if(cycle==false){
            return;
        }
        // find meeting point.
        slow=head;
        Node prev=null;//last node
        while(slow!=fast){
            prev=fast;
        slow=slow.next;//+1
        fast=fast.next;//+1
        
        }
         // remove cycle
        prev.next=null;
    }
        public void print(){
            if(head==null){
                System.out.println();
                return ;
            }
            Node temp= head;
            while(temp!=null){
                System.out.print(temp.data + "->");
                temp=temp.next;
            }
            System.out.println("null");
        

    }
    public static void main(String args[]){
        removeCycle ll=new removeCycle();
        ll.head = new Node(1);
        Node temp=new Node(2);
        ll.head.next=temp;
        ll.head.next.next=new Node(3);
        ll.head.next.next.next=temp;//1->2->3->1 cycle exists.
        // ll.print();
        ll.isRemove();
        ll.print();



    }
    
}
/* 
   Cycle detection:
Floyd’s algorithm (slow and fast) correctly detects the cycle.

Cycle removal:
After detection, you reset slow = head and move both pointers one step at a time until they meet.

prev tracks the node before fast.

When slow == fast, you’re at the start of the cycle.

prev.next = null breaks the cycle.

Printing after removal:
Now the list is linear again, so print() terminates properly.
*/

