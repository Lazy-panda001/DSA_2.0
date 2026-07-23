class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> dfsStore = new ArrayList<>();
        boolean vis[] = new boolean[V + 1];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                dfs(i, vis, adj, dfsStore);
            }
        }
        return dfsStore;
    }
    public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsStore){
        dfsStore.add(node);
        vis[node] = true;
        
        for(Integer i : adj.get(node)){
            if(vis[i] == false){
                dfs(i, vis, adj, dfsStore);
            }
        }
    }
}
