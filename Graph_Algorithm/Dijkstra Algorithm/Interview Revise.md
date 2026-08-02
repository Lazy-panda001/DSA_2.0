# Dijkstra Algorithm - Revision Cheat Sheet

This is the sequence you should remember during interviews and coding rounds.

---

# Step 1: Create Adjacency List

If input is an **edge list**, convert it into an adjacency list.

Example:

```java
adj.get(u).add(new Pair(v, weight));
adj.get(v).add(new Pair(u, weight));   // Only for undirected graph
```

---

# Step 2: Create Distance Array

Initially, every node is unreachable.

```java
int[] distance = new int[V];
Arrays.fill(distance, Integer.MAX_VALUE);
```

Source distance is always 0.

```java
distance[source] = 0;
```

---

# Step 3: Create Min Heap (Priority Queue)

The priority queue should always return the node having the **minimum distance**.

```java
PriorityQueue<Pair> pq =
    new PriorityQueue<>((a, b) -> a.distance - b.distance);
```

Store either:

```text
(node, distance)
```

or

```text
(distance, node)
```

Either is fine, just be consistent.

---

# Step 4: Push Source

```java
pq.offer(new Pair(source, 0));
```

Initially, only the source is known.

---

# Step 5: Start BFS-like Loop

```java
while (!pq.isEmpty()) {
```

This loop continues until every reachable node has been processed.

---

# Step 6: Remove Minimum Distance Node

```java
Pair current = pq.poll();

int node = current.node;
int dist = current.distance;
```

Unlike BFS (FIFO Queue),

Dijkstra always processes the **minimum-distance node first**.

---

# Step 7: Skip Outdated Entries (Very Important)

Sometimes the same node gets inserted multiple times into the priority queue.

Ignore outdated ones.

```java
if (dist > distance[node]) {
    continue;
}
```

This is an important optimization and is present in most interview solutions.

---

# Step 8: Visit Every Neighbour

```java
for (Pair neighbour : adj.get(node)) {
```

Extract

```java
int nextNode = neighbour.node;
int weight = neighbour.distance;
```

---

# Step 9: Relaxation (Most Important Step)

Ask:

> Can I reach this neighbour with a smaller distance?

```java
if (distance[node] + weight < distance[nextNode]) {

    distance[nextNode] = distance[node] + weight;

    pq.offer(new Pair(nextNode, distance[nextNode]));
}
```

This is called **Relaxation**.

---

# Step 10: Return Distance Array

After the priority queue becomes empty,

```java
return distance;
```

contains the shortest distance from the source to every node.

---

# Complete Flow

```text
Edge List
      │
      ▼
Build Adjacency List
      │
      ▼
Create Distance[]
(All = INF)
      │
      ▼
distance[source] = 0
      │
      ▼
Create Min Heap
      │
      ▼
Push Source
      │
      ▼
while PQ not empty
      │
      ▼
Pop Minimum Distance Node
      │
      ▼
Skip outdated entry
      │
      ▼
Visit all neighbours
      │
      ▼
Relax every edge
      │
      ▼
Push updated neighbour
      │
      ▼
Repeat
      │
      ▼
Return Distance[]
```

---

# Code Skeleton (Easy to Memorize)

```java
// 1. Build adjacency list

// 2. Distance array
Arrays.fill(distance, Integer.MAX_VALUE);
distance[source] = 0;

// 3. Min Heap
PriorityQueue<Pair> pq =
new PriorityQueue<>((a,b)->a.distance-b.distance);

// 4. Push source
pq.offer(new Pair(source,0));

// 5. Start Dijkstra
while(!pq.isEmpty()){

    Pair current = pq.poll();

    int node = current.node;
    int dist = current.distance;

    // 6. Skip outdated entries
    if(dist > distance[node])
        continue;

    // 7. Visit neighbours
    for(Pair neighbour : adj.get(node)){

        int next = neighbour.node;
        int weight = neighbour.distance;

        // 8. Relaxation
        if(distance[node] + weight < distance[next]){

            distance[next] = distance[node] + weight;

            pq.offer(new Pair(next, distance[next]));
        }
    }
}
```

---

# Interview Checklist ✅

Before writing Dijkstra, quickly ask yourself:

* ✅ Is the graph **weighted**?
* ✅ Are **all edge weights non-negative**?
* ✅ Build adjacency list (if input is an edge list).
* ✅ Initialize all distances to `INF`.
* ✅ Set `distance[source] = 0`.
* ✅ Use a **Min Heap (PriorityQueue)**.
* ✅ Always pop the node with the **smallest distance**.
* ✅ Skip outdated entries using `if (dist > distance[node]) continue;`.
* ✅ Perform **edge relaxation**.
* ✅ Push the updated neighbour back into the priority queue.

---

# One-Line Memory Trick

```text
Build Graph
      ↓
Distance[] = INF
      ↓
Source = 0
      ↓
Min Heap
      ↓
Pop Minimum
      ↓
Relax Neighbours
      ↓
Update Distance
      ↓
Push Again
      ↓
Repeat
```

This 9-step sequence is enough to reconstruct Dijkstra's algorithm from memory in almost any interview.
