import java.util.*;
// Interview question, uses important java concepts of interface and inner class.
/* Given a binary tree, Retrieve its edges
 * eg            5
 *          2          8
 *        1   3     6     11
 *       0         8 7       13
 *
 *
 * Left edge - [5, 2, 1, 0]
 * Right edge - [5, 8, 11, 13]
 * Bottom edge - [0, 3, 8, 7, 13]
 *
 *
 * Implementation notes -
 * There is a test case that will check if the tree has only been traversed 'Once'
 * i.e. you were able to retrieve all the edges by traversing the tree once in a single pass.
 * You get bonus points for making that test case pass.
 * However, we recommend that you get other tests to pass before attempting to do it in single pass.
 */

public class TreeEdgeRetriever
{

    // You do not need to modify this interface
    public static interface Node {

        public Integer getValue();

        public Node getLeftChild();

        public Node getRightChild();
    }


    // A result class to hold onto the leftEdge, rightEdge and bottomEdge generated by your implementation
    // You do not need to modify this class
    public static class Result {
        public List<Integer> leftEdge;
        public List<Integer> rightEdge;
        public List<Integer> bottomEdge;

        private Result() { } // hide default constructor

        private Result(List<Integer> leftEdge, List<Integer> rightEdge, List<Integer> bottomEdge) {
            this.leftEdge = leftEdge;
            this.rightEdge = rightEdge;
            this.bottomEdge = bottomEdge;
        }

        public static Result from(List<Integer> leftEdge, List<Integer> rightEdge, List<Integer> bottomEdge) {
            return new Result(leftEdge, rightEdge, bottomEdge);
        }
    }

    // This method is where your implementation goes. Feel free to add private members to this class if you need to.
    public static Result getEdges(Node root) {
        // Provide your implementation to retrieve the leftEdge, rightEdge and bottomEdge here.
        // Use the lists for the edges to create and return a Result object as shown below.
        // At the moment we are using empty lists to create the result object
        Result r = new Result(List.of(), List.of(),List.of());
        
        
        Node n = root;
        
        if(n==null){return r.from(List.of(), List.of(),List.of());}
            
        if(n.getLeftChild() == null && n.getRightChild() == null) {
           r.bottomEdge.add(n.getValue());
           
        }
        System.out.println(r);
        
    

        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);

       while(q.isEmpty() == false) {

      temp=q.peek();
      q.remove();

      if(temp.left!=null) q.add(temp.left);
      if(temp.right!=null) q.add(temp.right);

      System.out.print(temp.data+" ");
    }
        
        return r.from(List.of(), List.of(),List.of());
    }
    
    
    // This method is to help you test your code in the IDE you are working with. The test cases won't run this method
    // Grading will not happen on the basis of contents of this method.
    public static void main(String args[]) {
        // trivial implementation of the Node interface
        class TreeNode implements Node {
            private Node leftChild;
            private Node rightChild;
            private int value;

            public TreeNode(int value, Node leftChild, Node rightChild) {
                this.value = value;
                this.leftChild = leftChild;
                this.rightChild = rightChild;
            }

            @Override
            public Integer getValue() {
                return value;
            }

            @Override
            public Node getLeftChild() {
                return leftChild;
            }

            @Override
            public Node getRightChild() {
                return rightChild;
            }
        }
        /* setup a test tree of the following shape
                  5
               2     8
         */
        Node leftChild = new TreeNode(2, null, null);
        Node rightChild = new TreeNode(8, null, null);
        Node root = new TreeNode(5, leftChild, rightChild);

        // run the implementation of getEdges against the test tree.
        Result edges = getEdges(root);

        // check if the result object has correct values
        if(edges.leftEdge.containsAll(List.of(5, 2))) {
            System.out.println("Left edge has correct values");
        } else {
            System.out.println("Left edge should have 5 and 2. We found " + edges.leftEdge);
        }
        if(edges.rightEdge.containsAll(List.of(5, 8))) {
            System.out.println("Right edge has correct values");
        } else {
            System.out.println("Right edge should contain 5 and 8. We found " + edges.rightEdge);
        }
        if(edges.bottomEdge.containsAll(List.of(2, 8))) {
            System.out.println("Bottom edge has correct values");
        } else {
            System.out.println("bottom edge should contain 2 and 8. We found " + edges.bottomEdge);
        }
    }

}