import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class SquareOfGraph {
    public static void main(String[] args)throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		int n = 0;
		Scanner sc = new Scanner(new File("input-9.1"));
		while (sc.hasNext()) {
			n = sc.nextInt();
			while (sc.hasNextInt()) {
				list.add(sc.nextInt());
			}
		}
		int[][] mat = convertToMatrix(list, n);
		Adj_List_Graph g2 = graphSquared(mat, n);
		g2.printGraph();
    }

    // Convert input file to a matrix
	public static int[][] convertToMatrix(ArrayList<Integer> arr, int n) {
		int[][] mat = new int[n][n];
		int row,col;
		int i=0;
		for (row=0;row<n;row++) {
			for (col=0;col<n;col++) {
				mat[row][col] = arr.get(i);
				i++;
			}
		}
		return mat;
	}
	public static Adj_List_Graph graphSquared(int[][] g, int n) {
		Adj_List_Graph graph = new Adj_List_Graph(n);
		int[][] g2 = new int[n][n];

        // getting g^2 of graph if path exists in g(i,j) and g(j,k) then g(i,k)
        // is the path from g(i,j) --> g(j,k)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (g[i][j] == 1) {
					g2[i][j] = 1;
					for (int k = 0; k < n; k++) {
						if (g[j][k] == 1) {
							g2[i][k] = 1;
						}
					}
				}
			}
		}

        // Adding edges of adjacent matrix into Adj_List_Graph
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (g2[i][j] == 1) {
					graph.addEdge(i, j);
				}
			}
		}
		return graph;
	}
}