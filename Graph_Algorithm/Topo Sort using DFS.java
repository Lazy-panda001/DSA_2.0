class Solution {
    
    void DFS(int source, ArrayList<ArrayList<Integer>> adj , boolean visited[], Stack<Integer> stk) {
        visited[source] = true;
        
        // DFS call for child
        for(int next: adj.get(source)) {
            if(visited[next] == false) { 
                DFS(next, adj, visited, stk);
            }
        }
        
        // Push the node after visiting 
        // all its neighbours
        stk.push(node);
    }
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        
        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        
        
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        
        Stack<Integer> stk = new Stack<>();
        
        for(int i=0; i<V; i++) {
            if(visited[i] == false) {
                DFS(i, adj, visited, stk);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        while(!stk.isEmpty()) {
            result.add(stk.pop());
        }
        
        return result;
        
    }
}
