//Delete without head pointer 
class Deletion {

    public void delete(Node node) {
         
      while(node.next.next!=null){
        
           node.data = node.next.data;
           node = node.next;
        
      }
      //Note:  node.next = null AND NOT node = null
      node.data = node.next.data;
      node.next = null ;
    }
}

class Node {

    int data;
    Node next;

    Node(int d) {
      data=d;
    }
}


class LinkedList {

  Node head;
  

  // insert
  public void insert(int data) {

    Node n = new Node(data);

    if(this.head == null) {
      this.head = n;
      this.head.next=null;
    }

    // remember to add an else. :)
    else {
      Node temp = this.head;

      while(temp.next != null){
        temp = temp.next;
      }
      temp.next=n;
    }
  }

  // display
  public void display(){

    Node temp = head;
    System.out.println("");
    while(temp!=null) {
      System.out.print(" "+temp.data);
      temp=temp.next;
    }

    if(head==null) System.out.println(" Empty list");

  }

  //find key
  public Node findKey(int key) {

    Node temp=head;

    while(temp!=null && temp.data!=key) {

      temp=temp.next;

    }

    if(temp==null) return null;

    return temp;

  }

  
}

class Solution {

  public static void main(String[] args) {

    LinkedList l1 = new LinkedList();

    for(int i=0;i<10;i++) {
      l1.insert(i);
    }

    l1.display();
    Node toDelete = l1.findKey(6);
    Deletion d1 = new Deletion();
    if(toDelete!=null && toDelete.next!=null) {
      d1.delete(toDelete);
    }
    
    l1.display();

  }

}

