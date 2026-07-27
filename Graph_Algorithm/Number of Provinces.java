class Solution {

    void dfs(int source, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {
        visited[source] = true;

        for(Integer neighbour : adj.get(source)) {
            if(!visited[neighbour]) {
                dfs(neighbour, adj, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // Initialize Adjacency List

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // create adjacency List
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        // visited array
        boolean visited[] = new boolean[n];
        int count = 0;

        // start dfs
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
        }

        return count;

    }
}
