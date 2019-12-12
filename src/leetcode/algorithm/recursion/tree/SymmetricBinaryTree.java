package leetcode.algorithm.recursion.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class SymmetricBinaryTree {

	public boolean isMirror(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		return (t1.val == t2.val) && (isMirror(t1.right, t2.left)) && (isMirror(t1.left, t2.right));
	}
	
	public boolean isSymmetric(TreeNode root) {
		return isMirror(root, root);
	}
	
	public boolean isSymmetricII(TreeNode root) {
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				List<Integer> values = new ArrayList<Integer>();
				int n = queue.size();
				int i = 0;
				while (i < n) {
					TreeNode node = queue.poll();
					if (node.left != null) {
						queue.offer(node.left);
						values.add(node.left.val);
					} else {
						values.add(null);
					}
					if (node.right != null) {
						queue.offer(node.right);
						values.add(node.right.val);
					} else {
						values.add(null);
					}
					i++;
				}
				for (i = 0; i < values.size() / 2; i++)
					if (values.get(i) != values.get(values.size() - 1 - i))
						return false;
			}
		}
		return true;
	}
	
}
