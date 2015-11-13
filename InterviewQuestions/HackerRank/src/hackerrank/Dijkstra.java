/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 *
 * @author Lavanya
 */
class Edge {
  public int vertex1;
  public int vertex2;
  public int lenEdge;
}

public class Dijkstra {
    private static Map<Integer,ArrayList<Edge>> graph;
    private static boolean[] visit;
    private static int[] shortestDistance;
      private static final int INFINITY = Integer.MAX_VALUE;
    
    private static void addEdge(Integer vertex1, Integer vertex2,int lenEdge){
        ArrayList<Edge> adjacent = graph.get(vertex1);
        
        if(adjacent == null){
            adjacent = new ArrayList<Edge>();            
        }
        
        //Add the new edge
        Edge edge = new Edge();
        edge.vertex1 = vertex1;
        edge.vertex2 = vertex2;
        edge.lenEdge = lenEdge;
        adjacent.add(edge);
        graph.put(vertex1,adjacent);
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
            for(Edge adj : graph.get(vertex)){
                if (shortestDistance[adj.vertex2] > shortestDistance[vertex] + adj.lenEdge) {
                      shortestDistance[adj.vertex2] = shortestDistance[vertex] + adj.lenEdge;
                    }
                //if the vertex is not visitied get the shortest distance and mark node as visited
                if(!visit[adj.vertex2]){
                    visit[adj.vertex2]=true;
                    queue.add(adj.vertex2);
                }
            }
        }
            
    }
    
    private static boolean hasPathTo(int v) {
    return visit[v];
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
          int n = sc.nextInt();
          int m = sc.nextInt();
          graph = new HashMap<Integer, ArrayList<Edge>>();
          shortestDistance = new int[n + 1];
          visit = new boolean[n + 1];
            
          for (int v = 1; v < shortestDistance.length; v++) {
            shortestDistance[v] = INFINITY;
          }
          sc.nextLine();
            
          for (int j = 0; j < m; j++) {
            String[] lines = sc.nextLine().split(" ");
            int x = Integer.parseInt(lines[0]);
            int y = Integer.parseInt(lines[1]);
            int r = 0;
            if (lines.length == 3) {
              r = Integer.parseInt(lines[2]);
            }
            addEdge(x, y, r);
            addEdge(y, x, r);
          }
          int s = sc.nextInt();
          bfs(s);
            
          for (int vertex = 1; vertex < shortestDistance.length; vertex++) {
            if (shortestDistance[vertex] == 0) {
              continue;
            }
            if (hasPathTo(vertex)) {
              System.out.print(shortestDistance[vertex]);
            } else {
              System.out.print("-1");
            }
            System.out.print(" ");
          }
        }
    }
}
