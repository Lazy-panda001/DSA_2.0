class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // mentioned the datatype adj
        // Initialise adj
        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // making adjacency list
        for(int[] edge: prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }

        // create indreee array for each vertices
        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            for(int next : adj.get(i)) {
                indegree[next]++;
            }
        }

        // add all vertices with indergee==0 into a queue
        Queue<Integer> qu = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) {
                qu.add(i);
            }
        }

        int[] result = new int[numCourses]; // return result
        int index = 0;                      // storing result index
        int count = 0;

        while(!qu.isEmpty()) {
            int top = qu.poll();

            result[index++] = top;
            count++;

            for(int next: adj.get(top)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    qu.add(next);
                }
            }

        }

        if(count == numCourses) {
            return result;
        }
        return new int[0];


    }
}
