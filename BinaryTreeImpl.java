import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {

  Node root;

  class Node {

    int data;
    Node left,right;

    Node(int d) {
      data=d;
    }
  }


  // level-order insertion
  public void insert(Node temp,int data) {

    Node n = new Node(data);

    if(temp == null) {
      root=n;
      return;
    }

    Queue<Node> q = new LinkedList<Node>();
    q.add(temp);

    while(q.isEmpty()==false) {

        temp=q.peek();
        q.remove();

        if(temp.left == null) {
          temp.left = n ;
          break;
        }
        q.add(temp.left);

        if(temp.right == null) {
          temp.right = n;
          break;
        }
        q.add(temp.right);


    }

  }



  // display
  public void inOrder(Node temp) {

    if(temp.left != null) inOrder(temp.left);
    System.out.print(temp.data+" ");
    if(temp.right != null)  inOrder(temp.right);

  }

  public void preOrder(Node temp){

    System.out.print(temp.data+" ");
    if(temp.left != null) inOrder(temp.left);
    if(temp.right != null)  inOrder(temp.right);

  }

  public void postOrder(Node temp) {

    if(temp.left != null) inOrder(temp.left);
    if(temp.right != null)  inOrder(temp.right);
    System.out.print(temp.data+" ");
  }

//   // Delete a node by data value
//   public void deleteKey(int key) {

//   }

//   // Delete a node at given position
//   public void deleteByPosition(int pos) {



//   }

//   // Delete a Linked List
//   public void deleteLL() {


//   }

//   // count number of nodes iteratively
//   public int countNodes() {


//   }

//   // count number of nodes recursively
//   public int countNodes(Node temp){



//   }

//   // search for an element

//   public boolean find(int d){


//   }

//   // search for an element recursive
//   public boolean find(int d, Node temp) {


//   }

//   // get the Nth node of a linked list iterative approach
//   public int getNodeAt(int pos) {


//   }

//   // get the Nth node of a linked list recursive approach
//   public int getNodeAt(int pos,Node temp){


//   }

//   // get the Nth node from the end of a linked list
//   public int getEndNodeAt(int pos) {

//   }
}

class BinaryTreeImpl {

  public static void main(String[] args) {

    BinaryTree t1 = new BinaryTree();

    for(int i=0;i<12;i++) {
     t1.insert(t1.root,i);
    }


    t1.inOrder(t1.root);
    System.out.println();
    t1.preOrder(t1.root);
    System.out.println();
    t1.postOrder(t1.root);


  }

}
