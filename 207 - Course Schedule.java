/*  207 - Course Schedule - From @ LeetCode.com
    
    There are a total of n courses you have to take, labeled from 0 to n-1.

    Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
    which is expressed as a pair: [0,1]

    Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

    Example 1:

    Input: 2, [[1,0]] 
    Output: true
    Explanation: There are a total of 2 courses to take. 
                 To take course 1 you should have finished course 0. So it is possible.

    Example 2:

    Input: 2, [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take. 
                 To take course 1 you should have finished course 0, and to take course 0 you should
                 also have finished course 1. So it is impossible.

    Note:

        The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
        Read more about how a graph is represented.
        You may assume that there are no duplicate edges in the input prerequisites.

    
    Solution by @ Davis Ching, 2020.
 */
 
 class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] edges = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            if (edges[from] == null)
                edges[from] = new ArrayList<>();
            edges[from].add(to);
            indegree[to] += 1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.offer(i);
        
        int counter = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (edges[cur] == null) {
                counter += 1;
                continue;
            }
            for (int to : edges[cur]) {
                if (--indegree[to] == 0)
                    queue.offer(to);
            }
            counter += 1;
        }
        
        return counter == numCourses;
    }
}
