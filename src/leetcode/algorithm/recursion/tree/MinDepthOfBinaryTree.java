package leetcode.algorithm.recursion.tree;

public class MinDepthOfBinaryTree {
	
	public int minDepth(TreeNode root) {
		// 空节点
		if (root == null)
        	return 0;
        // 左右子节点有一个为空时，返回不为空子节点的深度
        if (root.left == null || root.right == null) 
        	return minDepth(root.left) + minDepth(root.right) + 1;
        // 左右孩子节点都不为空时，返回左右最小深度+1
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
	
	public static void main(String[] args) {
		TreeNode node3 = new TreeNode(3);
		TreeNode node9 = new TreeNode(9);
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node7 = new TreeNode(7);
		node20.left = node15;
		node20.right = node7;
		node3.left = node9;
		node3.right = node20;
		MinDepthOfBinaryTree solution = new MinDepthOfBinaryTree();
		int minDepth = solution.minDepth(node3);
		System.out.println(minDepth);
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		node1.left = node2;
		System.out.println(solution.minDepth(node1));
		
	}
}
