## Question asks:
Whenever you see --> 
Minimum moves, 
Minimum operations, 
Shortest path, 
Unweighted graph, 
Minimum number of turns. --> Think ✅ BFS

# 🚀 BFS (Breadth-First Search) - Complete Revision Sheet

> A one-stop revision guide for **BFS patterns**, **templates**, **interview recognition**, and **important LeetCode problems**.

---

# 📌 When Should You Think of BFS?

Whenever a question asks for:

- ✅ Minimum moves
- ✅ Minimum steps
- ✅ Minimum operations
- ✅ Shortest path
- ✅ Shortest distance
- ✅ Shortest transformation
- ✅ Reach destination in minimum time

## ⭐ Golden Rule

```text
Minimum + Unweighted Graph
            ↓
          BFS
```

---

# 📚 Types of BFS

```text
                     BFS
                      |
     -------------------------------------
     |              |                    |
 Graph BFS      Grid BFS          State Space BFS
                      |
              Multi-Source BFS
```

---

# 1️⃣ Graph BFS

## Recognition

The question contains:

- Graph
- Vertices
- Edges
- Adjacency List
- Connected Components

## Java Template

```java
Queue<Integer> queue = new LinkedList<>();

queue.offer(source);
visited[source] = true;

while (!queue.isEmpty()) {

    int node = queue.poll();

    for (int neighbour : adj.get(node)) {

        if (!visited[neighbour]) {

            visited[neighbour] = true;
            queue.offer(neighbour);
        }
    }
}
```

## Common Problems

- BFS Traversal
- Valid Path
- Connected Components
- Cycle Detection (BFS)
- Bipartite Graph

---

# 2️⃣ Grid BFS

## Recognition

Question contains:

- Matrix
- Grid
- Cell
- Island
- Distance

Example

```text
0 1 1
1 0 1
1 1 0
```

Each cell acts like a graph node.

---

## 4 Directions

```java
int[][] directions = {
    {-1,0},
    {1,0},
    {0,-1},
    {0,1}
};
```

---

## 8 Directions

```java
int[][] directions = {
    {-1,-1}, {-1,0}, {-1,1},
    {0,-1},           {0,1},
    {1,-1},  {1,0},   {1,1}
};
```

---

## Pair Class

```java
static class Pair{
    int row;
    int col;

    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
```

---

## Grid BFS Template

```java
Queue<Pair> queue = new LinkedList<>();

queue.offer(new Pair(sr, sc));
visited[sr][sc] = true;

while (!queue.isEmpty()) {

    Pair curr = queue.poll();

    for (int[] dir : directions) {

        int nr = curr.row + dir[0];
        int nc = curr.col + dir[1];

        if (validCell) {

            visited[nr][nc] = true;
            queue.offer(new Pair(nr, nc));
        }
    }
}
```

---

## Common Problems

- Number of Islands
- Flood Fill
- Shortest Path in Binary Matrix
- Rotten Oranges
- 01 Matrix
- As Far From Land As Possible

---

# 3️⃣ Multi-Source BFS

Instead of starting BFS from **one source**, start from **multiple sources simultaneously**.

Example

```text
0 1 1
0 1 1
0 0 1
```

Initial Queue

```text
(0,0)
(1,0)
(2,0)
(2,1)
```

All sources expand together.

---

## Recognition

Question contains words like:

- Nearest
- Closest
- Distance from all sources
- Minimum distance

---

## Java Template

```java
Queue<Pair> queue = new LinkedList<>();

// Push ALL sources first
for (...) {

    if (isSource) {

        queue.offer(new Pair(i, j));
        visited[i][j] = true;
    }
}

while (!queue.isEmpty()) {

    Pair curr = queue.poll();

    for (int[] dir : directions) {

        ...

    }
}
```

---

## Common Problems

- Rotten Oranges
- 01 Matrix
- As Far From Land As Possible

---

# 4️⃣ State Space BFS

One of the most important interview patterns.

Instead of graph nodes,

**Every state itself becomes a graph node.**

Examples

```text
0000
1234
abcd
hit
```

Neighbour states are generated dynamically.

No adjacency list required.

---

## Recognition

Question contains:

- Number
- String
- Word

Each move changes:

- One digit
- One character

Need:

- Minimum transformations
- Minimum moves

---

## Generic Flow

```text
Start State
      ↓
Push into Queue
      ↓
Pop Current State
      ↓
Reached Target?
      ↓
Generate All Neighbours
      ↓
Skip Invalid States
      ↓
Skip Visited States
      ↓
Push Valid States
```

---

## Common Problems

- Open the Lock
- Word Ladder
- Minimum Genetic Mutation
- Sliding Puzzle
- K Similar Strings

---

# 📏 Level Order BFS (`queue.size()`)

One of the most important BFS concepts.

---

## ✅ Use `queue.size()` when the problem asks:

- Minimum distance
- Minimum steps
- Minimum operations
- Minimum moves
- Minimum minutes
- Minimum time

Example

```java
while (!queue.isEmpty()) {

    int size = queue.size();

    while (size-- > 0) {

        // Process one BFS level

    }

    level++;
}
```

### Why?

One BFS Level = One Move

---

### Example 1

Rotten Oranges

```text
Level 0 → Initially Rotten

↓

Level 1 → Fresh oranges become rotten

↓

Level 2 → More oranges become rotten
```

Each level = 1 minute

---

### Example 2

Shortest Path Binary Matrix

Each level = Path Length

---

### Example 3

Open Lock

Each level = One wheel rotation

---

### Example 4

Word Ladder

Each level = One word transformation

---

# ❌ When NOT to use `queue.size()`

If the question only asks for traversal.

Simply use

```java
while (!queue.isEmpty()) {

    int node = queue.poll();

    ...

}
```

Examples

- BFS Traversal
- Valid Path
- Connected Components

---

# 🔥 Single Source vs Multi Source BFS

## Single Source

```text
S

↓

Neighbours

↓

Neighbours
```

Examples

- Open Lock
- Valid Path
- Shortest Path Binary Matrix

---

## Multi Source

```text
S1

S2

S3

↓

Expand Together
```

Examples

- Rotten Oranges
- 01 Matrix
- As Far From Land As Possible

---

# 🎯 BFS Recognition Sheet

## If question says

```text
Minimum Moves
```

👉 Think **BFS**

---

## If question says

```text
Grid / Matrix
```

👉 Think **Grid BFS**

---

## If question says

```text
Nearest / Closest
```

👉 Think **Multi-Source BFS**

---

## If question says

```text
Word / String / Number Transformation
```

👉 Think **State Space BFS**

---

## If question says

```text
Shortest Path
```

👉

- Equal Weight → BFS
- Weighted Graph → Dijkstra

---

# ❌ When NOT to use BFS

If graph edges have different weights

```text
A --5--> B

A --2--> C

C --1--> B
```

Need shortest path?

👉 Use **Dijkstra**

NOT BFS.

---

# ⏱️ Time Complexity

## Graph BFS

```
O(V + E)
```

Space

```
O(V)
```

---

## Grid BFS

```
O(R × C)
```

Space

```
O(R × C)
```

---

## State Space BFS

```
O(Number of States × Neighbours)
```

Example

Open Lock

```
10000 × 8
```

---

# ⚠️ Common Mistakes

### ❌ Forgetting Visited Array

Infinite Loop

---

### ❌ Mark Visited After Pop

Wrong

Always mark visited while pushing.

```java
visited[next] = true;
queue.offer(next);
```

---

### ❌ Forget Boundary Check

Grid BFS crashes.

---

### ❌ Forget Dead/Blocked Cells

Wrong Answer.

---

### ❌ Using BFS on Weighted Graph

Use Dijkstra.

---

# 📚 Important LeetCode Problems

| Problem | BFS Type |
|----------|----------|
| BFS Traversal | Graph BFS |
| Valid Path | Graph BFS |
| Bipartite Graph | Graph BFS |
| Number of Islands | Grid BFS |
| Flood Fill | Grid BFS |
| Shortest Path in Binary Matrix | Grid BFS + Level BFS |
| Rotten Oranges | Multi-Source BFS |
| 01 Matrix | Multi-Source BFS |
| As Far From Land As Possible | Multi-Source BFS |
| Open the Lock | State Space BFS |
| Word Ladder | State Space BFS |
| Minimum Genetic Mutation | State Space BFS |
| Sliding Puzzle | State Space BFS |

---

# 🧠 Final BFS Decision Tree

```text
Need Minimum?

        │
        ▼

Graph?

        │
        ├────────────► Equal Weight?
        │                   │
        │                   ▼
        │                 BFS
        │
        ▼

Grid?

        │
        ├────────────► Multiple Sources?
        │                   │
        │                   ▼
        │            Multi-Source BFS
        │
        ▼

Number / String / Word?

        │
        ▼

Change One Character / Digit?

        │
        ▼

Target?

        │
        ▼

Minimum Moves?

        │
        ▼

State Space BFS
```

---

# 💡 One-Line Memory Tricks

- ✅ Minimum + Unweighted Graph → **BFS**
- ✅ Grid + Distance → **Grid BFS**
- ✅ Nearest / Closest → **Multi-Source BFS**
- ✅ Word/String/Number Transformation → **State Space BFS**
- ✅ Shortest Path + Weighted Graph → **Dijkstra**
- ✅ Need Time/Steps/Distance → **Level Order BFS (`queue.size()`)**
- ✅ Need Only Traversal → **Simple BFS (No `queue.size()`)**

---

# 🚀 Master These BFS Problems

### Graph BFS

- BFS Traversal
- Valid Path
- Bipartite Graph
- Cycle Detection

### Grid BFS

- Number of Islands
- Flood Fill
- Shortest Path in Binary Matrix

### Multi-Source BFS

- Rotten Oranges
- 01 Matrix
- As Far From Land As Possible

### State Space BFS

- Open the Lock
- Word Ladder
- Minimum Genetic Mutation
- Sliding Puzzle

---

> ⭐ **Interview Tip:**  
> Whenever you hear **"minimum"**, **"shortest"**, or **"least number of operations"**, your first instinct should be:
>
> **"Can I model this as an unweighted graph and solve it using BFS?"**
