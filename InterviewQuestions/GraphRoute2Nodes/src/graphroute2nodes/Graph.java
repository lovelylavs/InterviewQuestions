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

public class Graph 
{
    private Node vertices[];
    public int count;
    
    //constructor
    public Graph()
    {
        vertices = new Node[6];
        count =0;
    }
    
    //Add a node to the graph
    public void addNode(Node x)
    {
        if(count < 30)
        {
            vertices[count] = x;
            count++;
        }
        else
        {
            System.out.println("Graph Full");
        }
    }
    
    //Get the nodes of the graph
    public Node[] getNodes()
    {
        return vertices;
    }
    
   
}
