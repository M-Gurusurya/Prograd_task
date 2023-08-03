import java.util.Scanner;

class Node
{
    int value;
    Node next;
    Node(int value)
    {
        this.value=value;
    }
}
public class CircularLinkedList {
    Node head;
    Node tail;
    int length;
    CircularLinkedList(int value)
    {
        Node newNode=new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }
    void prepend(int value)
    {
        Node newNode = new Node(value);
        if(length==0)
        {
            head=newNode;
            tail=newNode;
        }
        else
        {
            tail.next=newNode;
            newNode.next=head;
            head=newNode;
        }
    }
    void append(int value)
    {
        Node newNode=new Node(value);
        if(length==0)
        {
            head=newNode;
            tail=newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
            newNode.next=head;
        }
        length++;
    }
    Node removeFirst()
    {
        if(length==0)
        {
            return null;
        }
        Node temp=head;
        head=head.next;
        temp.next=null;
        tail.next=head;
        length--;
        if(length==0)
        {
            tail=null;
        }
        return temp;
    }
    Node removeLast() {
        if (length == 0)
        {
            return null;
        }
        else
        {
            Node temp = head;
            Node prev = head;
            while (temp.next != head)
            {
                prev = temp;
                temp = temp.next;
            }
            tail = prev;
            tail.next = head;
            length--;
            if (length == 0) {
                head = null;
                tail = null;
            }
            return temp;
        }
    }
    void print()
    {
        System.out.print(head.value+"->");
        Node temp=head.next;
        while (temp!=head)
        {
            System.out.print(temp.value+"->");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        CircularLinkedList cll=new CircularLinkedList(10);
        cll.append(20);
        cll.append(30);
        //cll.append(40);
        cll.prepend(5);
        cll.removeFirst();
        cll.removeLast();
        cll.print();
    }
}
