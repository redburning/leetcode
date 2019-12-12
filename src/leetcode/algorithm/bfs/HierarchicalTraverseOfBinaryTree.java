package leetcode.algorithm.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HierarchicalTraverseOfBinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				List<Integer> level = new ArrayList<Integer>();
				int n = queue.size();
				int i = 0;
				while (i < n) {
					TreeNode node = queue.poll();
					level.add(node.val);
					if (node.left != null)
						queue.offer(node.left);
					if (node.right != null)
						queue.offer(node.right);
					i++;
				}
				levelOrder.add(level);
			}
		}
		return levelOrder;
	}

}
