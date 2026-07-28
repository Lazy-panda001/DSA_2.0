// Detect Cycle in a Directed Graph == Direct Acyclic Graph == using BFS == Kahn's Algoritm
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // mentioned the data type adj
        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]); // Dependency linking 
        }

        int[] indegree = new int[numCourses]; // indegree array
        for(int i=0; i<numCourses; i++) {
            for(int next : adj.get(i)) {
                indegree[next]++;
            }
        }

        // add all indegree==0 vertices in the queue
        Queue<Integer> qu = new LinkedList<>();
        int count = 0;

        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) {
                qu.add(i);
            }
        }

        // Kahn's algorithm == BFS
        while(!qu.isEmpty()) {
            int top = qu.poll();
            count++;
            for(int next: adj.get(top)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    qu.add(next);
                }
            }

        }

        if(count == numCourses) {
            return true;
        }
        return false;
    }
}
