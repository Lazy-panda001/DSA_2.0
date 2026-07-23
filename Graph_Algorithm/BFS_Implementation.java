// Link : https://leetcode.com/discuss/post/2360573/become-master-in-graph-by-hi-malik-o4xy/

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();  // store bfs of a graph
        boolean vis[] = new boolean[V + 1];          // visited (mark as 1) or not visited (mark as 0) 
        Queue<Integer> q = new LinkedList<>();       // Data structure we need
                
                q.add(0);
                vis[0] = true;
                
                while(!q.isEmpty()){
                    Integer node = q.poll();
                    bfs.add(node);
                    
                    for(Integer it : adj.get(node)){
                        if(vis[it] == false){
                            q.add(it);
                            vis[it] = true;
                        }
                    }
                }
        return bfs;
    }
}

