package leetcode.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValueOfBinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) {
			this.val = x;
		}
	}
	
	public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
        	queue.offer(root);
        int bottomLeftVal = 0;
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	int count = 0;
        	while (count < size) {
        		TreeNode node = queue.poll();
        		if (count == 0)
        			bottomLeftVal = node.val;
        		if (node.left != null)
        			queue.offer(node.left);
        		if (node.right != null)
        			queue.offer(node.right);
        		count++;
        	}
        }
        return bottomLeftVal;
    }
	
}
