package leetcode.algorithm.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrderOfBinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			this.val = x;
		}
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root != null)
			queue.offer(root);
		int layerCount = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			int nodeCount = 0;
			LinkedList<Integer> layer = new LinkedList<>();
			while (nodeCount < size) {
				TreeNode node = queue.poll();
				if (layerCount % 2 == 0) 
					layer.addLast(node.val);
				else
					layer.addFirst(node.val);;
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null) 
					queue.offer(node.right);
				nodeCount++;
			}
			res.add(layer);
			layerCount++;
		}
		return res;
	}
	
}
