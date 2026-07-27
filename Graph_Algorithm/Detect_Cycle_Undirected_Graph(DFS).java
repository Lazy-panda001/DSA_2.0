import java.util.*;

class Solution {

    private boolean dfs(int node, int parent,
                        ArrayList<ArrayList<Integer>> adj,
                        boolean[] vis) {

        vis[node] = true;

        for (int neighbour : adj.get(node)) {

            // If neighbour is not visited, recurse
            if (!vis[neighbour]) {
                if (dfs(neighbour, node, adj, vis)) {
                    return true;
                }
            }
            // If neighbour is visited and is not the parent,
            // then a cycle exists
            else if (neighbour != parent) {
                return true;
            }
        }

        return false;
    }

    public boolean isCycle(int V, int[][] edges) {

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        // Check every connected component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
