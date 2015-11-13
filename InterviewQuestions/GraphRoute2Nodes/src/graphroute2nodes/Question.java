/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphroute2nodes;

import java.util.LinkedList;

/**
 *
 * @author Lavanya
 */
public class Question
{
    public enum State
    {
        Unvisited, Visited, Visiting;
    }
    
    public static void main(String[] a)
    {
        Graph g = createNewGraph();
        Node[] n = g.getNodes();
        Node start = n[3];
        Node end = n[5]; 
        
            StringBuffer s = new StringBuffer();
            for (Node v: n) 
                s.append("\n    " + v.getVertex() + " -> " + v.getadjacent().toString());
                          
        System.out.println(s);
        System.out.println(search(g, start, end));
    }
    
    public static Graph createNewGraph()
    {
        Graph g = new Graph();
        
        Node[] temp = new Node[6];
        temp[0] = new Node("a",3);
        temp[1] = new Node("b",0);
        temp[2] = new Node("c",0);
        temp[3] = new Node("d",1);
        temp[4] = new Node("e",1);
        temp[5] = new Node("f",0);
        
        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
                g.addNode(temp[i]);
        }
        return g;
    }
    
    public static boolean search(Graph g, Node start, Node end)
    {
        LinkedList<Node> que = new LinkedList<>();
        
        //Mark all nodes as unvisited initially
        for(Node u : g.getNodes())
        {
            u.state = State.Unvisited;
        }
        
        start.state = State.Visiting;
        
        que.add(start);
        
        Node u;
        while(!que.isEmpty())
        {
            u = que.removeFirst();
            if( u != null)
            {
                for(Node v : u.getadjacent())
                {
                    if(v.state == State.Unvisited)
                    {
                        if(v == end)
                        {
                            return true;
                        }
                        else
                        {
                            v.state = State.Visiting;
                            que.add(v);
                        }
                    }
                }
                
                u.state = State.Visited;
            }
        }
        
        return false;
    }
}
