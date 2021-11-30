import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.LinkedList; 
import java.util.Queue;

public class ShortestPathGraph {
	public static int npath = 0; // final npath value npath[v]
	public static class Pair{
        public int first;
        public int second;
        public Pair(int f,int s){
            first = f;
            second = s;
        }
    }
    public static void main(String[] args)throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		int n = 0;
		Scanner sc = new Scanner(new File("g1.txt")); // change input files here
		while (sc.hasNext()) {
			n = sc.nextInt();
			while (sc.hasNextInt()) {
				list.add(sc.nextInt());
			}
		}
		int v = n-1;
		int s = n-v;
		int[][] mat = convertToMatrix(list, n);
		Adj_List_Graph graph = createAdjListGraph(mat, n);
		graph.printGraph();
		System.out.println();
		BFS(mat,n,s,v);
    }

	/*public static void print2D(int[][] matrix){
		for (int[] row : matrix)
		  	System.out.println(Arrays.toString(row));
    }*/

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

	// Convert input file to a matrix
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

	// function to get the shortest path and update npath value
	public static void shortestPath(int[][] arr,int n,int s,int v,int[] vis, int[] dist, int d){
        vis[s] = 1;
        if(s == v){
            if(d == dist[v]){
                npath+=1;
            }
			
        }
		else {
            for(int i = 0; i < n; i++){
                if(vis[i] == 0 && arr[s][i] == 1){
                    shortestPath(arr,n,i,v,vis,dist,d+1);
                }
            }
        }
        vis[s] = 0;
    }

    // modified BFS to get the shortest path between the given 2 nodes
    public static void BFS(int[][] arr,int n,int s,int v){
        int[] vis = new int[n];
		int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            vis[i] = 0;
        }

        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(s,0); 
        q.add(p); // add the first element to queue
        vis[p.first] = 1;

        while (!q.isEmpty()){
            Pair p2 = q.peek();
            q.remove();
            if(p2.first == v) {
                dist[v] = p2.second;
                break;
            }
            for(int i = 0; i < n; i++){ // check all connected vertices
                if(vis[i] == 0 && arr[p2.first][i] == 1){
                    Pair p3 = new Pair(i,p2.second + 1);
                    q.add(p3);
                    vis[i] = 1;
                }
            }
        }   
        for (int i = 0; i < n; i++){
            vis[i] = 0;
        }
        shortestPath(arr,n,s,v,vis,dist,0); // run shortest path after doing BFS

		// print dist[v] and which is the length of shortest path from s --> v and 
		// npath[v] which is the number of shortest path from s --> v
		System.out.println("dist["+ v +"] = " + dist[v] + ", npath[" + v +"] = " + npath); 
    }
}