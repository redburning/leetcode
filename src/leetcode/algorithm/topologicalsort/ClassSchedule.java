package leetcode.algorithm.topologicalsort;

import java.util.Stack;

public class ClassSchedule {

	public int[] findDegree(int numCourses, int[][] prerequisites) {
		int[] degree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			degree[prerequisites[i][0]]++;
		}
		return degree;
	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = findDegree(numCourses, prerequisites);
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < numCourses; i++) {
        	if (degree[i] == 0)
        		st.push(i);
        }
        int count = 0;
        while (!st.isEmpty()) {
        	int pre = st.pop();
        	count++;
        	for (int i = 0; i < prerequisites.length; i++) {
        		int next = prerequisites[i][0];
        		if (prerequisites[i][1] == pre && --degree[next] == 0)
        			st.push(next);
        	}
        }
        return count == numCourses ? true : false;
    }
	
	public static void testCase1() {
		int numCourses = 2;
		int[][] prerequisites = {{1, 0}, {0, 1}};
		ClassSchedule schedule = new ClassSchedule();
		boolean finish = schedule.canFinish(numCourses, prerequisites);
		System.out.println(finish);
	}
	
	public static void testCase2() {
		int numCourses = 2;
		int[][] prerequisites = {{1, 0}};
		ClassSchedule schedule = new ClassSchedule();
		boolean finish = schedule.canFinish(numCourses, prerequisites);
		System.out.println(finish);
	}
	
	public static void main(String[] args) {
		testCase1();
		testCase2();
	}

}
