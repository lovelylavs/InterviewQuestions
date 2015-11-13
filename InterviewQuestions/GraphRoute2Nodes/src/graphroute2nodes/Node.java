/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphroute2nodes;

/**
 *
 * @author Lavanya
 */
public class Node {
    
    private Node adjacent[];
    public int adjacentCount;
    private String vertex;
    public Question.State state;
     
    public Node(String vertex, int adjacentLen)
    {
        this.vertex = vertex;
        this.adjacentCount = 0;
        adjacent = new Node[adjacentLen];
    }
    
    public void addAdjacent(Node x)
    {
        if(adjacentCount < 30)
        {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        }
        else
        {
            System.out.println("No more adjacent nodes can be added");
        }
    }
    
    public Node[] getadjacent()            
    {
        return adjacent;
    }
    
    public String getVertex()
    {
        return vertex;
    }
}
