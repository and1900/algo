package leetcode.tree;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {

	public static void main(String[] args) {
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode c = new TreeNode(3);
		TreeNode b = new TreeNode(2, d, e);
		TreeNode a = new TreeNode(1,b,c);
		
		//preOrder(a);
		System.out.println(postOrderNoRecusive(a));
		
		
	}
	
	public static void preOrder(TreeNode root) {
		if(root!=null){
			System.out.print(root.val + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
		
	}
	
	public static ArrayList<Integer> preOrderNoRecusive(TreeNode root) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode next = root;
		while( next!=null || !stack.isEmpty()){
			if(next != null){
				list.add(next.val);  // read value
				stack.push(next);
				next = next.left;
			} else {
				next = stack.pop();
				next = next.right;
			}
			
		}
		
		return list;
	}
	
	public static ArrayList<Integer> inOrderNoRecusive(TreeNode root) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode next = root;
		while( next!=null || !stack.isEmpty()){
			if(next != null){
				stack.push(next);
				next = next.left;
			} else {
				next = stack.pop();
				list.add(next.val);  // read value
				next = next.right;
			}
			
		}
		
		return list;
	}
	
	//different
	public static ArrayList<Integer> postOrderNoRecusive(TreeNode root) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode next = root;
		TreeNode previousRight = null;
		while( next!=null || !stack.isEmpty()){
			if(next != null){
				//push root
				stack.push(next);
				next = next.left;
				
			} else if(stack.peek().right != previousRight) {  
				//if the top node's right child is same with previous processed node, then it means right child tree is done.
				//otherwise, process it
				next = stack.peek().right;
				previousRight = null;
				
			} else {
				// pop root and read value
				previousRight = stack.pop();
				list.add(previousRight.val);
			}
		}
		
		return list;
	}
}


