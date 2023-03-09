package pp1305;

public class CustomerQueue {

    private Node head;
    private int length;

    public void enqueue(Customer newCustomer){
        Node newNode = new Node(newCustomer);
        if(head == null){
            head = newNode;
            length = 1;
            return;
        }
        newNode.next = null;
        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = newNode;
        length++;
    }

    public void dequeue(){
        if(head == null){
            System.out.println("The line is already empty");
            return;
        }
        head = head.next;
        length--;
    }
    public int getLength() {
        return length;
    }
    public Customer getHead() { return this.head.getCustomer(); }


    public String toString(){
        String result = "";
        Node indexNode = head;
        if(head == null){//nothing to print when empty
            return " ";
        }else if(head != null){//just print the first customer in queue
            result += indexNode.customer.getName() + "\n";
        }
        while(indexNode.next != null){//
            result += indexNode.next.customer.getName() + "\n";
            indexNode = indexNode.next;
        }
        result += "\n";
        return result;
    }

    private class Node{
        private Customer customer;
        Node next;
        Node(Customer customer){
            this.customer = customer;
            next = null;
        }

        private Customer getCustomer(){ return this.customer; }
    }

}
