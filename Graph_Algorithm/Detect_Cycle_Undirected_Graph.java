import java.util.*;

class Solution {

  // making pair of {node,parent}
    static class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    private boolean bfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {

        Queue<Pair> queue = new LinkedList<>(); // BFS
        queue.add(new Pair(src, -1));
        vis[src] = true;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            int node = current.node;
            int parent = current.parent;

            for (int neighbour : adj.get(node)) {

                if (!vis[neighbour]) {
                    vis[neighbour] = true;
                    queue.add(new Pair(neighbour, node));
                } else if (neighbour != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCycle(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        // Handle disconnected components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
