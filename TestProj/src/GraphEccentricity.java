import java.util.*;
import java.io.File;

public class GraphEccentricity {
    /*
     * 
     * In a weighted directed graph G = (V, E), the eccentricity of a vertex v ∈ V is defined by
     *                      ecc(v) = max{δ(v, u) | u ∈ V },
     * where δ(v, u) is the weight of a shortest path from v to u (in other words ecc(v) is the smallest
     * distance to the vertex u that is the furthest from v).
     * 
     * This is a Java program that computes the eccentricity of every vertex of an undirected weighted graph.
     * 
     */

    // Initiate a class edge to store graph edge
    static class Edge {
        int src, dest, weight;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }
    
    // Initiate a class node to store a heap node
    static class Node {
        int vertex, weight;
        public Node(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }
    }

    // Initiate a graph class to represent the object
    static class Graph {
        int v;
        ArrayList<ArrayList<Edge>> adjList;
        Graph(int V) {
            this.v = V;
            adjList = new ArrayList<>(v);

            for (int i = 0; i < v; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        // Adds a weighted edge from the source to destination
        public void addEdge(int src, int dest, int weight) {
            Edge edge = new Edge(src, dest, weight);
            adjList.get(src).add(edge);
        }

        // This will print the Adjacency List representation of a weighted graph 
        // from the Vertex to each destination and their weight/distance
        public void printWeightedGraph() {
            System.out.println("This Adjacency List represents '(Vertex) --> (Destination, Weight of Edge)'");
            for (int i = 0; i < v; i++) {
                ArrayList<Edge> list = adjList.get(i);
                System.out.println("\nAdjacency list of Vertex " + i);
                System.out.print("(head)");
                for (int j = 0; j < adjList.get(i).size(); j++) {
                    System.out.print(" --> (" + list.get(j).dest + ", " + list.get(j).weight + ")");
                }
                System.out.println();
            }
        }
    }

    // Using dijkstra to find the shortest weight/distance from v --> u and store the total weight/distance in dist
    // This method will return the Eccentricity of Vertex[i]
    public static int dijkstraShortestPath(Graph graph, int n, int s) {

        // Initializing dist and prev arrays
        int[] dist = new int[n];
        int[] prev = new int[n];
        
        /* 
            PriorityQueue used to create a min_heap
            Each item is a Node pair of (vertex, weight)
            Weight/distance is used for comparison
        */
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        
        // Set dist[i] to INFINITY and prev[i] to -1
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }

        // Initialize distance from source to itself to 0
        dist[s] = 0;

        // Push source node to PriorityQueue with a distance of 0
        minHeap.add(new Node(s, 0));

        // dijkstra algorithm
        while(!minHeap.isEmpty()) {

            // Remove and return the next best vertex
            Node node = minHeap.poll();

            // get vertex number
            int u = node.vertex;

            for (Edge edge: graph.adjList.get(u)) {
                int v = edge.dest;
                int w = edge.weight;
                
                // Storing shortest distance found from v --> u in dist[v]
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;

                    /*  
                        Priority Queue doesn't support Decrease Key so instead we don't update
                        the key and instead add one more copy of it.

                        Whenever vertex distance is reduced, another instance of the vertex is
                        added to Priority Queue. 
                        
                        Only the instance with minimum distance is considered and
                        other instances will be ignored.
                     */
                    minHeap.add(new Node(v, dist[v]));
                    prev[v] = u;
                }
            }
        }

        // Initializing Eccentricity Value
        int ecc = 0;

        /* 
            Dist array stores the shortest weight/distance from src --> dest
            We do this to get the max weight/distance stored 
            and update Eccentricity value if dist[i] is greater
        */
        for (int i = 0; i < dist.length; i++) {
            if (ecc < dist[i]) {
                ecc = dist[i];
            }
        }

        return ecc;
    }

    // Method to print the Eccentricity of each vertex
    public static void printEccentricity(Graph graph, int n) {
        System.out.println("[Eccentricity of Each Vertex]");

        // We get each Vertex[i] and update the value of eccentricity for each Vertex[i]
        for (int i = 0; i < n; i++) {
            int ecc = dijkstraShortestPath(graph, n, i);
            System.out.println("ecc(" + i + ") = " + ecc);
        }
    }
    
    // Method to convert the input array into a matrix
    public static int[][] convertToMatrix(ArrayList<Integer> arr, int n) {
		int[][] mat = new int[n][n];
		int row,col;
		int i = 0;
		for (row = 0; row < n; row++) {
			for (col = 0; col < n; col++) {
				mat[row][col] = arr.get(i);
				i++;
			}
		}
		return mat;
	}

    // Method to create a weighted graph where -1 means there is no edge found
    public static Graph createGraph(int[][] adjMatrix, int n) {
        Graph graph = new Graph(n);
        int i,j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {

                // If -1 is found then there is no edge to be added, else add an edge
                if (adjMatrix[i][j] != -1) {
                    graph.addEdge(i, j, adjMatrix[i][j]);
                }
            }
        }
        return graph;
    }

    public static void main(String[] args) throws Exception {

        // Initializing a list to store input from a file as an array
        ArrayList<Integer> inputList = new ArrayList<>();

        // The first line of the file which is the number of vertices in the graph
        int n = 0;

        // Scan the file for integers and add it into the input array
        Scanner sc = new Scanner(new File("input-10-1.txt")); // Change input files here
        while (sc.hasNext()) {
            n = sc.nextInt();
            while (sc.hasNextInt()) {
                inputList.add(sc.nextInt());
            }
        }

        // Convert input to matrix
        int[][] adjMatrix = convertToMatrix(inputList, n);
        System.out.println();

        // Create the graph using the matrix
        Graph graph = createGraph(adjMatrix, n);
        
        // Printing Graph
        graph.printWeightedGraph();
        System.out.println();

        // Printing out the Eccentricity of each vertex of the graph
        printEccentricity(graph, n);
    }
}
