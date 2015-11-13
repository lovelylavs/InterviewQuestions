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
public class Prim {
    
    //Vertex class
     private static class Vertex  {
        private Integer id;
        private List<Edge> edges = new ArrayList<>();
        public void addEdge(Edge edge) { edges.add(edge); }
        public Vertex(Integer id) { this.id = id; };

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (id == null) {
                if (other.id != null)
                    return false;
            } else if (!id.equals(other.id))
                return false;
            return true;
        }

    }
     
    //Edge class
    private static class Edge implements Comparable<Edge> {
        private Vertex destination;
        private int weight;
        public Edge(Vertex destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
        //implement the Comparable interface
        @Override
        public int compareTo (Edge other) {
            return Integer.compare(weight, other.weight);
        }

    }

    private static int getMstSum(Vertex start, Map<Integer, Vertex> vertices) {
        int cost = 0;
        //List of vertices not visited
        List<Vertex> unvisited = new ArrayList<>(vertices.values());
        
        //The start vertex
        Vertex vertex = start;
        
        //remove the unvisited vertex
        unvisited.remove(vertex);
        
        // The elements of the priority queue are ordered according to their natural ordering, or by a Comparator provided at queue construction time, depending on which constructor is used
        PriorityQueue<Edge> vertexQueue = new PriorityQueue<>();

        //Loop until they are not any more unvisited vertices , which means the list is empty
        while (!unvisited.isEmpty()) {
            for (Edge e : vertex.edges) {
                if (unvisited.contains(e.destination)) {
                    vertexQueue.add(e);
                }
            }
            //Get each edge from priority queue where edges are in natural order
            //poll gives the minimum edge
            Edge e = vertexQueue.poll();
            if (unvisited.contains(e.destination)) {
                cost += e.weight;
            }
            vertex = e.destination; 
            unvisited.remove(vertex); 
        }
        return cost;
    }

    private static Map<Integer, Vertex> initializeVertices(int m) {
        Map<Integer, Vertex> vertices = new TreeMap<>();
        for (int i = 1; i <= m; i++) {
            Vertex vertex = new Vertex(i);
            vertices.put(i, vertex);
        }
        return vertices;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        
        int n = in.nextInt(); // node
        int m = in.nextInt(); // edges
        
        //Initialize vertices and create a map of vertices
        Map<Integer, Vertex> vertices = initializeVertices(n);
        
        //Loop until number of edges
        for (int j = 0; j < m; j++) {
            Vertex vertexA = vertices.get(in.nextInt());
            Vertex vertexB = vertices.get(in.nextInt());
            int weight = in.nextInt();
            //Add the edges from input
            //vertexa-weight
            //vertexb-weight
            Edge a = new Edge(vertexA, weight);
            Edge b = new Edge(vertexB, weight);
            vertexA.addEdge(b);  
            vertexB.addEdge(a);
        }
        int start = in.nextInt();
        
        //get the vertex which is given as start point for MST
        Vertex startVertex = vertices.get(start);
        System.out.println(getMstSum(startVertex, vertices));
    }
}
