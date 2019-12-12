package leetcode.algorithm.topologicalsort;

import java.util.Stack;

public class ClassScheduleII {

	public int[] findDegree(int numCourses, int[][] prerequisites) {
		int[] degree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			degree[prerequisites[i][0]]++;
		}
		return degree;
	}
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = findDegree(numCourses, prerequisites);
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < numCourses; i++) {
        	if (degree[i] == 0)
        		st.push(i);
        }
        int[] order = new int[numCourses];
        int index = 0;
        while (!st.isEmpty()) {
        	int pre = st.pop();
        	order[index] = pre;
        	index++;
        	for (int i = 0; i < prerequisites.length; i++) {
        		int next = prerequisites[i][0];
        		if (prerequisites[i][1] == pre && --degree[next] == 0)
        			st.push(next);
        	}
        }
        return index == numCourses ? order : new int[0];
    }
	
	public static void testCase1() {
		int numCourses = 2;
		int[][] prerequisites = {{1, 0}};
		ClassScheduleII schedule = new ClassScheduleII();
		int[] order = schedule.findOrder(numCourses, prerequisites);
		for (int i = 0; i < order.length; i++) {
			System.out.print("->" + order[i]);
		}
	}
	
	public static void testCase2() {
		int numCourses = 4;
		int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
		ClassScheduleII schedule = new ClassScheduleII();
		int[] order = schedule.findOrder(numCourses, prerequisites);
		for (int i = 0; i < order.length; i++) {
			System.out.print("->" + order[i]);
		}
	}
	
	public static void main(String[] args) {
		// testCase1();
		testCase2();
	}

}
