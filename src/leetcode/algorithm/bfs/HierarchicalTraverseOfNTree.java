package leetcode.algorithm.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HierarchicalTraverseOfNTree {
	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> levelOrder = new ArrayList<List<Integer>>();
		if (root != null) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			while (!queue.isEmpty()) {
				List<Integer> level = new ArrayList<Integer>();
				int n = queue.size();
				int i = 0;
				while (i < n) {
					Node node = queue.poll();
					level.add(node.val);
					for (Node child : node.children) {
						if (child != null)
							queue.add(child);
					}
					i++;
				}
				levelOrder.add(level);
			}
		}
		return levelOrder;
	}

}
