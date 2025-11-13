## Edge Removal from a Minimum Spanning Tree (Bonus Task)

### This project demonstrates how to:

Build a Minimum Spanning Tree (MST) from a weighted graph
- Display all MST edges
- Remove an edge from the MST
- Show the resulting connected components
- Efficiently find a replacement edge that reconnects the graph while keeping it a valid MST
- Display the final updated MST

The task showcases both MST construction and correct handling of edge removal and reconnection.

### How to Run
Build and run using Maven
```bash
mvn package
```

```bash
mvn exec:java -Dexec.mainClass="com.mst.Main"
```

### Project Structure
```
src/
 └── main/
      └── java/
           └── com/mst/
                ├── Main.java
                ├── Edge.java
                ├── UnionFind.java
                └── KruskalMST.java
```

### How the Program Works
1. Build the MST (Kruskal's Algorithm)

- Sort edges by weight
- Use Union-Find to avoid cycles
- Add edges to construct MST

2. Remove One Edge

The program removes a chosen edge from the MST.

3. Show Components

Using Union-Find, the program determines which nodes belong to which components after the removal.

4. Find a Replacement Edge

- From all original graph edges:
- Select edges whose endpoints lie in different components
- Choose the smallest weight among them → this is the replacement edge

5. Final Output

The program prints the new MST after reconnection.

### Example Output
Initial MST:
1 - 2 (1)
1 - 3 (2)
3 - 4 (2)
0 - 2 (3)
4 - 5 (6)

Removed edge: 1 - 3 (2)

Components:
Node 0 -> component 0
Node 1 -> component 1
Node 2 -> component 0
Node 3 -> component 3
Node 4 -> component 3
Node 5 -> component 3

Replacement edge: 3 - 4 (2)

New MST:
1 - 2 (1)
3 - 4 (2)
3 - 1 (2)
0 - 2 (3)
4 - 5 (6)

### Technologies Used

- Java 17
- Maven
- Kruskal’s Algorithm
- Union-Find (Disjoint Set Union)

### Author
A student of AITU completing the DAA Bonus Task - Zhambyl Dulat, from group - SE-2421