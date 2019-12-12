package leetcode.algorithm.recursion.tree;

public class MaxDepthOfBinaryTree {
	
	public int maxDepth(TreeNode root) {
        if (root == null)
        	return 0;
        if (root.left == null && root.right == null)
        	return 1;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
		MaxDepthOfBinaryTree solution = new MaxDepthOfBinaryTree();
		int maxDepth = solution.maxDepth(node3);
		System.out.println(maxDepth);
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		node1.left = node2;
		System.out.println(solution.maxDepth(node1));
		
	}
	
}
