package leetcode.tree;

import leetcode.tree.TreeNode;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p!=null && q!=null) { //both not null
			return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else if(p==q){ //both null
			return true;
		} else { //only one null
			return false;
		}
	}
}
