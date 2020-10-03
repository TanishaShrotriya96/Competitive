import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

  //https://www.geeksforgeeks.org/bfs-vs-dfs-binary-tree/?ref=lbp

  // display DFS Traversal -
  public void inOrder(Node temp) {

    if(temp.left != null) inOrder(temp.left);
    System.out.print(temp.data+" ");
    if(temp.right != null) inOrder(temp.right);

  }

  public void preOrder(Node temp){

    System.out.print(temp.data+" ");
    if(temp.left != null) inOrder(temp.left);
    if(temp.right != null) inOrder(temp.right);

  }

  public void postOrder(Node temp) {

    if(temp.left != null) inOrder(temp.left);
    if(temp.right != null) inOrder(temp.right);
    System.out.print(temp.data+" ");
  }

  // display BFS Traversal

  public void bfsTraversal(Node temp) {

    if(temp==null)return ;

    Queue<Node> q = new LinkedList<Node>();
    q.add(temp);

    while(q.isEmpty() == false) {

      temp=q.peek();
      q.remove();

      if(temp.left!=null) q.add(temp.left);
      if(temp.right!=null) q.add(temp.right);

      System.out.print(temp.data+" ");
    }

  }

  // search
  public boolean bfsSearch(int key) {


    if(root==null) return false;

    Queue<Node> q = new LinkedList<Node>();
    q.add(root);
    Node temp=null;

    while(q.isEmpty() == false){

      temp=q.peek();
      q.remove();

      if(temp.data!=key){
        if(temp.left!=null) q.add(temp.left);
        if(temp.right!=null) q.add(temp.right);
      }

      else{
        return true;
      }
    }

    return false;
  }

  // dfsSearch with recursion
  public boolean dfsRecursive(int key,Node temp){

    if(temp == null) return false;

    if(temp.data!=key){

      boolean match = false;
      if(temp.left!=null){
        match = dfsRecursive(key,temp.left);
      }

      if(match==false && temp.right!=null){
          match=dfsRecursive(key,temp.right);
      }
      return match;

    }

    return true;
  }

  //dfsSearch iterative
  public boolean dfsIterative(int key) {
    if(root == null ) return false;

    Stack<Node> s = new Stack<Node>();
    s.push(root);
    Node temp=null;

    while(s.isEmpty() == false) {

      temp = s.pop();

      if(temp.data!=key){

        if(temp.right!=null) s.push(temp.right);
        if(temp.left!=null) s.push(temp.left);

      }

      else return true;

    }
    return false;
  }


  //insertion based on user choice

  public void insertAt(int parentData, String child,int nodeData) {

    if(root == null) {
      System.out.println("Tree is empty data added at root");
      root = new Node(nodeData);
      return;
    }

    Node temp=returnNodeAt(parentData);
    if(temp!=null){

      if(child == "left") {
        if(temp.left == null ){
          temp.left = new Node(nodeData);
          return;
        }
        temp.left.data = nodeData;
        return;
      }

     if(child == "right") {

        if(temp.right== null ){
          temp.right = new Node(nodeData);
          return;
        }
        temp.right.data = nodeData;
        return;
      }
    }

    System.out.print(" Node with data "+ parentData+" was not found");

  }

  public Node returnNodeAt(int key){

    if(root == null ) return null;

    Stack<Node> s = new Stack<Node>();
    s.push(root);
    Node temp=null;

    while(s.isEmpty() == false) {

      temp = s.pop();

      if(temp.data!=key){

        if(temp.right!=null) s.push(temp.right);
        if(temp.left!=null) s.push(temp.left);

      }

      else return temp;

    }
    return null;
  }

  // delete by shrinking bottommost right node.
  public boolean deleteNode(int data) {

    if(root == null) return false;

    Node toDelete = returnNodeAt(data);

    Node temp = root;

  }
}

class Solution {

  public static void main(String[] args) {

    BinaryTree t1 = new BinaryTree();

    for(int i=0;i<10;i++) {
     t1.insert(t1.root,i);
    }

    // display
    t1.inOrder(t1.root);
    System.out.println();
    t1.preOrder(t1.root);
    System.out.println();
    t1.postOrder(t1.root);
    System.out.println();
    t1.bfsTraversal(t1.root);

    System.out.print("\nBFS Search: ");
    System.out.print(t1.bfsSearch(1)+" ");
    System.out.print(t1.bfsSearch(12)+" ");
    System.out.print(t1.bfsSearch(4)+" ");
    System.out.println(t1.bfsSearch(-1));

    System.out.print("DFS Recursive: ");
    System.out.print(t1.dfsRecursive(1,t1.root)+" ");
    System.out.print(t1.dfsRecursive(4,t1.root)+" ");
    System.out.print(t1.dfsRecursive(12,t1.root)+" ");
    System.out.println(t1.dfsRecursive(-1,t1.root)+" ");

    System.out.print("DFS Iterative: ");
    System.out.print(t1.dfsIterative(1)+" ");
    System.out.print(t1.dfsIterative(4)+" ");
    System.out.print(t1.dfsIterative(12)+" ");
    System.out.println(t1.dfsIterative(-1)+" ");

    t1.insertAt(5,"right",15);
    //below is a testcase
    t1.insertAt(5,"right",15);
    t1.bfsTraversal(t1.root);
    System.out.println();

    t1.insertAt(5,"right",10);
    t1.bfsTraversal(t1.root);
    System.out.println();
    t1.insertAt(10,"right",11);
    t1.bfsTraversal(t1.root);
    System.out.println();
    t1.insertAt(11,"right",12);
    t1.bfsTraversal(t1.root);
    System.out.println();
    t1.insertAt(12,"left",15);
    t1.bfsTraversal(t1.root);
    System.out.println();

    t1.insertAt(9,"left",13);
    t1.bfsTraversal(t1.root);
    System.out.println();
    t1.insertAt(13,"left",14);
    t1.bfsTraversal(t1.root);
    System.out.println();

    t1.insertAt(6,"left",16);
    t1.bfsTraversal(t1.root);
    System.out.println();

  }

}
