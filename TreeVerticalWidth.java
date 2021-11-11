import java.util.HashSet;
import java.util.Set;

public class TreeVerticalWidth {
    
// A Binary Tree Node
static class Node
{
	int data;
	Node left, right;
};

static int maximum = 0, minimum = 0;
// ===========================================================================
// METHOD 1: Imagine root is your  (0,0) and if you flatten the tree on the x-axis 
// then left side nodes are on -ve x-axis and right ones are on the positive x-axis.

// get vertical width
static void lengthUtil(Node root, int curr)
{
	if (root == null)
		return;

	// traverse left
	lengthUtil(root.left, curr - 1);

	// if curr is decrease then get
	// value in minimum
	if (minimum > curr)
		minimum = curr;

	// if curr is increase then get
	// value in maximum
	if (maximum < curr)
		maximum = curr;

	// traverse right
	lengthUtil(root.right, curr + 1);
}

static int getLength(Node root)
{
	maximum = 0; minimum = 0;
	lengthUtil(root, 0);

	// 1 is added to include root in the width
	return (Math.abs(minimum) + maximum) + 1;
}

//===============================================================================
// METHOD 2:  hd is global here, so you are basically tracking each subtree that you cover, once you hit the root of it.

static void fillSet(Node root,Set<Integer> set,int hd)
{
    if(root == null) return;
    fillSet(root.left,set,hd - 1);
    set.add(hd);
    fillSet(root.right,set,hd + 1);
}

static int verticalWidth(Node root)
{
    Set<Integer> set = new HashSet<Integer>();
    
    // Third parameter is horizontal distance
    fillSet(root,set,0);
    return set.size();
}
// Utility function to create a new tree node
static Node newNode(int data)
{
	Node curr = new Node();
	curr.data = data;
	curr.left = curr.right = null;
	return curr;
}

// Driver Code
public static void main(String[] args)
{
	Node root = newNode(1);
	root.left = newNode(2);
	root.right = newNode(3);
	root.left.left = newNode(4);
	root.left.right = newNode(5);
	root.right.left = newNode(6);
	root.right.right = newNode(7);
	root.right.left.right = newNode(8);
	root.right.right.right = newNode(9);
	System.out.println(getLength(root));
    System.out.println(verticalWidth(root));
}
}