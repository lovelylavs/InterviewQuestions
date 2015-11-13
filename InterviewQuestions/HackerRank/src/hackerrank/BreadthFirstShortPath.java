/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hackerrank;
import java.util.*;
/**
 *
 * @author Lavanya
 */
public class BreadthFirstShortPath {
    private static Map<Integer,List<Integer>> graph;
    private static boolean[] visit;
    private static int[] shortestDistance;
    
    private static void addEdge(Integer vertex1, Integer vertex2){
        List<Integer> adjacent = graph.get(vertex1);
        
        if(adjacent == null){
            adjacent = new ArrayList<>();
            graph.put(vertex1,adjacent);              
        }
        adjacent.add(vertex2);
    }
    
    private static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        shortestDistance[start]=0; //to find the shortest distance from start to each node
        visit[start]=true; //kepp track of visits
        queue.add(start); //Add the start node first into the queue
        
        while(!queue.isEmpty()){
            //get the vertex from queue
            int vertex = queue.poll();
            
            //get all the adjacent vertex from start
            for(int nextVertex : graph.get(vertex)){
                
                //if the vertex is not visitied get the shortest distance and mark node as visited
                if(!visit[nextVertex]){
                    shortestDistance[nextVertex]=shortestDistance[vertex]+6;
                    visit[nextVertex]=true;
                    queue.add(nextVertex);
                }
            }
        }
            
    }
    
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
          int n = sc.nextInt();
          int m = sc.nextInt();
          graph = new HashMap<>();
          visit = new boolean[n + 1];
          shortestDistance = new int[n + 1];
          for (int v = 1; v < n + 1; v++) {
            shortestDistance[v] = -1;
          }
          for (int j = 0; j < m; j++) {
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            addEdge(vertex1, vertex2);
            addEdge(vertex2, vertex1);
          }
          int start = sc.nextInt();
          bfs(start);
          for (int vertex = 1; vertex < shortestDistance.length; vertex++) {
            if (shortestDistance[vertex] == 0) {
              continue;
            }
            System.out.print(shortestDistance[vertex] + " ");
          }
          System.out.println("");
        }
    }
}
