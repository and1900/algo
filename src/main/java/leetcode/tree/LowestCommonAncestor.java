package leetcode.tree;
/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestor {
    // essencially it is looking for a sub tree that has both values
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode temp = root;
        while( true ){
            if(temp.val > p.val && temp.val > q.val){ // is it in left sub tree
                temp = temp.left;
            } else if(temp.val < p.val && temp.val < q.val){ // is it in right sub tree
                temp = temp.right;
            } else { // not in left or right? this is it
                break;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(8);
        root.left = n1;
        root.right = n2;

        TreeNode n3 = new TreeNode(1);
        n1.left = n3;

        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(root, n1, n3));
    }
}
