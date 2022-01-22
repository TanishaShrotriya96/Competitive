package BasicDS;
class LinkedList {

  Node head;

  class Node {

    int data;
    Node next;

    Node(int d) {
      data=d;
    }
  }


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

  // Delete a node by data value
  public void deleteKey(int key) {

    Node temp=head;
    Node prev= null;

    if(temp!=null && temp.data == key) {

      head = temp.next;
      // don't need to explicitly do temp = null as java has garbage collection
      // remember to add a return.
      return;
    }

    while(temp!=null && temp.data!=key) {

      prev=temp;
      temp=temp.next;

    }

    if(temp==null) return;

    prev.next=temp.next;
    // don't need to explicitly do temp = null as java has garbage collection
  }

  // Delete a node at given position
  public void deleteByPosition(int pos) {

    Node temp = head;
    Node prev = null;

    if(temp!=null && pos ==1){
      head =temp.next;
      return;
    }


    while(temp!=null && --pos > 0) {

      prev=temp;
      temp=temp.next;

    }

    if(temp==null) {
      System.out.print("\n Position not found");
      return;
    }

    prev.next=temp.next;

  }

  // Delete a Linked List
  public void deleteLL() {

    Node temp=null;

    while(head!=null) {

      temp=head;
      head=temp.next;
      temp.next = null;

    }

  }

  // count number of nodes iteratively
  public int countNodes() {

    Node temp=head;
    int cnt = 0;

    while(temp!=null) {
      temp=temp.next;
      cnt++;
    }

    return cnt;

  }

  // count number of nodes recursively
  public int countNodes(Node temp){

    // always consider the end condition
    // which is single occurence over a repeat occurence.
    // here temp == null over temp != null
    if(temp==null){
      return 0;
    }

    return 1+countNodes(temp.next);

  }

  // search for an element

  public boolean find(int d){

    Node temp=head;
    while(temp!=null && temp.data!=d){
      temp=temp.next;
    }

    if(temp==null) return false;

    else return true;
  }

  // search for an element recursive
  public boolean find(int d, Node temp) {

    if(temp == null ){
      return false;
    }

    else if(d!=temp.data){
      return find(d,temp.next);
    }

    return true;
  }

  // get the Nth node of a linked list iterative approach
  public int getNodeAt(int pos) {

    Node temp=head;

    while(temp!=null && --pos > 0) {
      temp=temp.next;
    }

    if(temp == null) return -1;

    return temp.data;
  }

  // get the Nth node of a linked list recursive approach
  public int getNodeAt(int pos,Node temp){

    if(temp == null) {
      return -1;
    }
    else if(pos == 1){
      return temp.data;
    }

    return getNodeAt(pos-1,temp.next);
  }

  // get the Nth node from the end of a linked list
  public int getEndNodeAt(int pos) {
    Node temp = head;
    Node temp_n = null;

    while(pos > 0 && temp!=null) {
      temp=temp.next;
      pos = pos -1;
    }

    if(pos == 0){

      temp_n=head;

      while(temp!=null){
        temp=temp.next;
        temp_n=temp_n.next;
      }

      return temp_n.data;
    }

    return -1;

  }
}

class Solution {

  public static void main(String[] args) {

    LinkedList l1 = new LinkedList();

    for(int i=0;i<10;i++) {
      l1.insert(i);
    }

    l1.display();
    l1.deleteKey(0);
    l1.display();
    l1.deleteByPosition(3);
    l1.display();
    l1.deleteByPosition(1);
    l1.display();
    l1.deleteByPosition(12);
    l1.display();
    l1.deleteLL();
    l1.display();

    for(int i=0;i<10;i++) {
      l1.insert(i);
    }

    System.out.println(l1.countNodes());
    System.out.println(l1.countNodes(l1.head));

    System.out.println(l1.find(5));
    System.out.println(l1.find(-1));
    System.out.println(l1.find(-1,l1.head));
    System.out.println(l1.find(9,l1.head));
    l1.display();
    System.out.print("\n "+l1.getNodeAt(4));
    System.out.print("\n "+l1.getNodeAt(1));
    System.out.print("\n "+l1.getNodeAt(12));

    System.out.print("\n "+l1.getNodeAt(4,l1.head));
    System.out.print("\n "+l1.getNodeAt(1,l1.head));
    System.out.print("\n "+l1.getNodeAt(10,l1.head));

    // please work things out on paper first, it is always a good idea.
    System.out.print("\n "+l1.getEndNodeAt(1));
    System.out.print("\n "+l1.getEndNodeAt(10));
    System.out.print("\n "+l1.getEndNodeAt(4));
    System.out.print("\n "+l1.getEndNodeAt(12));



  }

}
//output
// 
// 0 1 2 3 4 5 6 7 8 9
//  1 2 3 4 5 6 7 8 9
//  1 2 4 5 6 7 8 9
//  2 4 5 6 7 8 9
//  Position not found
//  2 4 5 6 7 8 9
//  Empty list
// 10
// 10
// true
// false
// false
// true
//
//  0 1 2 3 4 5 6 7 8 9
//  3
//  0
//  -1
//  3
//  0
//  9
//  9
//  0
//  6
//  -1
