package leetcode.algorithm.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HierarchicalTraverseOfBinaryTreeII {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null)
        	queue.offer(root);
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	int count = 0;
        	List<Integer> layer = new ArrayList<>();
        	while (count < size) {
        		TreeNode node = queue.poll();
        		layer.add(node.val);
        		if (node.left != null)
        			queue.offer(node.left);
        		if (node.right != null)
        			queue.offer(node.right);
        		count++;
        	}
        	res.addFirst(layer);
        }
        return res;
    }
	
}
