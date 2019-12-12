package leetcode.algorithm.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideViewOfBinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
        	queue.offer(root);
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	int count = 0;
        	while (count < size) {
        		count++;
        		TreeNode node = queue.poll();
        		if (node.left != null)
        			queue.offer(node.left);
        		if (node.right != null)
        			queue.offer(node.right);
        		if (count == size)
        			res.add(node.val);
        	}
        }
        return res;
    }

}
