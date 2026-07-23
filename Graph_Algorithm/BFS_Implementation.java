// Link : https://leetcode.com/discuss/post/2360573/become-master-in-graph-by-hi-malik-o4xy/

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();  // store bfs of a graph
        boolean vis[] = new boolean[V + 1];          // visited (mark as 1) or not visited (mark as 0) 
        Queue<Integer> q = new LinkedList<>();       // Data structure we need
                
                q.add(0);                            // initial point, start with 0 or any given index
                vis[0] = true;                       // mark it as visited
                
                while(!q.isEmpty()){
                    Integer node = q.poll();
                    bfs.add(node);
                    
                    for(Integer it : adj.get(node)){  // add all adjacent vertices of current vertex into the queue
                        if(vis[it] == false){         // iff not visited
                            q.add(it);
                            vis[it] = true;           // add to queue and mark it as visited
                        }
                    }
                }
        return bfs;
    }
}

