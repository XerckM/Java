import java.util.LinkedList; 
import java.util.Queue;
import java.util.Arrays;
public class TestPath {
    public static class pair{
        public int first;
        public int second;
        public pair(int f,int s){
            first = f;
            second = s;
        }
    }
    public static int ans = 0;
    //function to count number of shortest path between given two nodes
    public static void npathf(int [][] arr,int n,int s,int v,int []npath,int []dist,int []visited,int d){
        visited[s] = 1;
        if(s == v){
            if(d == dist[v]){
                ans+=1;
            }
        }else{
            for(int i = 0;i<n;i++){
                if(visited[i] == 0 && arr[s][i] == 1){
                    npathf(arr,n,i,v,npath,dist,visited,d+1);
                }
            }
        }
        visited[s] = 0;
    }
    //function to get length of shortest path between given 2 nodes
    public static void BFS(int [][] arr,int n,int s,int v,int []dist,int []npath){
        int []visited = new int[n];
        for(int i = 0;i<n;i++){
            visited[i] = 0;
        }
        Queue<pair> q = new LinkedList<>();
        pair p = new pair(s,0); 
        q.add(p); //adding first element to queue
        visited[p.first] = 1;
        //iterating till queue become empty
        while(!q.isEmpty()){
            pair sudo = q.peek();
            q.remove();
            if(sudo.first == v){
                dist[v] = sudo.second;
                break;
            }
            //checking all connected vertices
            for(int i = 0;i<n;i++){
                if(visited[i] == 0 && arr[sudo.first][i] == 1){
                    pair pq = new pair(i,sudo.second+1);
                    q.add(pq);
                    visited[i] = 1;
                }
            }
        }   
        for(int i = 0;i<n;i++){
            visited[i] = 0;
        }
        npathf(arr,n,s,v,npath,dist,visited,0); //calling npath to get number of shortest paths
    }
    public static void print2D(int[][] matrix){
		for (int[] row : matrix)
		  	System.out.println(Arrays.toString(row));
    }
    public static void main(String args[]) {
        int[][] arr = new int[8][8]; 
        int []dist = new int[8];
        int []npath = new int[8];
        for(int i = 0;i<8;i++){
            npath[i] = 0;
        }
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                arr[i][j] = 0;
            }
        }
        //creating g1
        arr[1][2] = 1;
        arr[1][3] = 1;
        arr[1][4] = 1;
        arr[2][1] = 1;
        arr[3][1] = 1;
        arr[4][1] = 1;
        arr[2][5] = 1;
        arr[3][5] = 1;
        arr[4][6] = 1;
        arr[5][7] = 1;
        arr[6][7] = 1;
        arr[5][2] = 1;
        arr[5][3] = 1;
        arr[6][4] = 1;
        arr[7][5] = 1;
        arr[7][6] = 1;
        print2D(arr);
        BFS(arr,8,1,7,dist,npath);
        System.out.println(ans);
        System.out.println("G1: \ndist[7]: "+dist[7]+", npath[7] : "+ans);
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                arr[i][j] = 0;
            }
        }
        //creating g2
        arr[1][2] = 1;
        arr[1][3] = 1;
        arr[1][4] = 1;
        arr[1][5] = 1;
        arr[1][6] = 1;
        arr[2][1] = 1;
        arr[3][1] = 1;
        arr[4][1] = 1;
        arr[5][1] = 1;
        arr[6][1] = 1;
        arr[2][7] = 1;
        arr[3][7] = 1;
        arr[4][7] = 1;
        arr[5][7] = 1;
        arr[6][7] = 1;
        arr[7][2] = 1;
        arr[7][3] = 1;
        arr[7][4] = 1;
        arr[7][5] = 1;
        arr[7][6] = 1;
        ans = 0;
        BFS(arr,8,1,7,dist,npath);
        print2D(arr);
        System.out.println("G2: \ndist[7]: "+dist[7]+", npath[7] : "+ans);
    }
}