package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.tree.TreeNode;

import org.junit.Assert;
import org.junit.Test;


//TODO - implement with one dequeue,no recursion
public class MaximumDepthOfBinaryTree {
	// recursive
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public int maxDepthNoRecursive_listPerLevel(TreeNode root) {
		if (root == null) {
			return 0;
		}
		List<TreeNode> currentLevel = new ArrayList<TreeNode>();
		currentLevel.add(root);

		int levels = 0;
		while (!currentLevel.isEmpty()) {
			levels++;
			List<TreeNode> nextLevel = new ArrayList<TreeNode>();
			for (TreeNode node : currentLevel) {
				if (node.left != null)  nextLevel.add(node.left);
				if (node.right != null) nextLevel.add(node.right);
			}
			
			currentLevel = nextLevel;
		}

		return levels;
	}

	@Test
	public void test() {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);

		t1.left = t2;
		t1.right = t3;

		t2.left = t4;
		t2.right = t5;

		Assert.assertEquals(3, maxDepth(t1));
		Assert.assertEquals(3, maxDepthNoRecursive_listPerLevel(t1));

	}
}
