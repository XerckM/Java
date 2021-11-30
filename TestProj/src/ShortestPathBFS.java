import java.util.Scanner;
import java.io.File;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class ShortestPathBFS {
    public static void main(String[] args) throws Exception {

        // initiate list
        ArrayList<Integer> list = new ArrayList<>();

        // this is the size of the graph taken from the input file
		int n = 0;

        // initiate scan
		Scanner sc = new Scanner(new File("g2.txt")); // change input files here

        // this checks the first line for the size of the graph and
        // checks the second line for the adjacency input
		while (sc.hasNext()) {
			n = sc.nextInt();
			while (sc.hasNextInt()) {
				list.add(sc.nextInt());
			}
		}
        
        // we convert the initiated list into a matrix after getting the inputs
        int[][] mat = convertToMatrix(list, n);

        // create a graph using given file Adj_List_Graph.java
		Adj_List_Graph graph = createAdjListGraph(mat, n);
        //graph.printGraph();
        System.out.println();

        // run method to find the shortest path and the number of shortest path
        shortestPathBFS(graph, 1, n);
    }

    // this creates a graph based off the Adj_List_Graph.java file given
    public static Adj_List_Graph createAdjListGraph(int[][] g, int n) {
		Adj_List_Graph graph = new Adj_List_Graph(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (g[i][j] == 1) {
					graph.addEdge(i, j);
				}
			}
		}
		return graph;
	}

    // method to convert input array into matrix form
    public static int[][] convertToMatrix(ArrayList<Integer> arr, int n) {
		int[][] mat = new int[n][n];
		int row,col;
		int i=0;
		for (row = 0; row < n; row++) {
			for (col = 0; col < n; col++) {
				mat[row][col] = arr.get(i);
				i++;
			}
		}
		return mat;
	}

    // modifed method of BFS to find the shortest path and the number of shortest path from 's --> v'
    // the shortest path exists in dist[n-1] and the number of shortest paths exists in npath[n-1]
    // this method also prints out all the shortest paths that were traversed
    public static void shortestPathBFS(Adj_List_Graph graph, int s, int n) {

        // initiate values
        int dest = n-1;
        int[] dist = new int[n];
        int[] npath = new int[n];
        Queue<Integer> q = new LinkedList<>();

        // initializing set of arrays to to get all the shortest paths
        ArrayList<ArrayList<Integer>> trackedPath = new ArrayList<>();
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            trackedPath.add(new ArrayList<>());
        }

        trackedPath.get(s).add(-1);
        dist[s] = 0;
        npath[s] = 1;
        q.add(s);

        // modified BFS algorithm
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v: graph.adj.get(u)) {
                if (dist[v] > dist[u] + 1) { // this means that there is a path that goes from 's --> v'
                    dist[v] = dist[u] + 1; // with a smaller length than the previous distance found
                    npath[v] = npath[u]; // at the same time the path's value for 'v' will be updated to the path's value of 'u'
                    q.add(v);
                    trackedPath.get(v).add(u); // shortest path found added to trackedPath
                }
                else if (dist[v] == dist[u] + 1) { // this means that all the shortest paths that go from 's --> v'
                    npath[v] = npath[v] + npath[u]; // will be added to the number of shortest paths of 'v'
                    trackedPath.get(v).add(u); // another shortest path found added to trackedPath
                }
            }
        }

        // find all shortest paths and add it into pathList
        findAllShortestPaths(pathList, trackedPath, path, s, dest);

        // printing all the shortest paths traversed in pathList
        printAllShortestPaths(pathList);

        // we print out the shortest path and number of paths from 's --> v'
        System.out.println("dist[" + dest + "] = " + dist[dest] + ", npath[" +  dest + "] = " + npath[dest]); 
    }

    // recursively finding all the shortest paths
    public static void findAllShortestPaths(ArrayList<ArrayList<Integer>> pathList, ArrayList<ArrayList<Integer>> trackedPath, ArrayList<Integer> path, int s, int dest) {
        if (dest == -1) {
            pathList.add(new ArrayList<>(path));
            return;
        }
        for(int d: trackedPath.get(dest)) {
            path.add(dest);
            findAllShortestPaths(pathList, trackedPath, path, s, d);
            path.remove(path.size()-1);
        }
    }

    // method to print all the shortest paths
    public static void printAllShortestPaths(ArrayList<ArrayList<Integer>> pathList) {
        for (ArrayList<Integer> v: pathList) {
            Collections.reverse(v);
            System.out.println(Arrays.toString(v.toArray()).replace("[","").replace(","," -->").replace("]",""));
        }
        System.out.println();
    }
}
