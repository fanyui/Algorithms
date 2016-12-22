/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgraph;

/**
 *
 * @author harisu
 */
public class TestGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] vertices = {"Seattle", "San Francisco", "Los Angeles","Denver", "Kansas City","Chicago","Boston","New York","Atlanta", "Miami","Dallas","Houston"};
        //edge array for graph 
        int[][] edges = { {0,1},{0,3},{0,5},
                           {1,0},{1,2},{1,3},
                           {2,1},{2,3}, {2,4},{2,10},
                           {3,0},{3,1},{3,2},{3,4},{3,5},
                           {4,2},{4,3},{4,5},{4,7},{4,8},{4,10},
                           {5,0},{5,3},{5,4},{5,6},{5,7},
                           {6,5},{6,7},
                           {7,4},{7,5},{7,6},{7,8},
                           {8,4},{8,7},{8,9},{8,10},{8,11},
                           {9,8},{9,11},
                           {10,2},{10,4},{10,8},{10,11},
                           {11,8},{11,9},{11,10}
        };
        Graph<String> graph1 = new UnweightedGraph<>(vertices,edges);
        System.out.println("The number of vertices isn graph1: "+graph1.getSize());
        System.out.println("The vertex with index 1 is "+graph1.getVertex(1));
        System.out.println("the index of miami is "+ graph1.getIndex("Miami"));
        System.out.println("The edges for graph1 ");
        graph1.printEdges();
        //List of edge object for graph 
        String[] names = {"Peter", "Jane","Mark","Cindy","Wendy"};
        java.util.ArrayList<AbstractGraph.Edge> edgeList = new java.util.ArrayList<>();
        edgeList.add(new AbstractGraph.Edge(0, 2));
        edgeList.add(new AbstractGraph.Edge(1, 2));
        edgeList.add(new AbstractGraph.Edge(2, 4));
        edgeList.add(new AbstractGraph.Edge(3, 4));
        //create a graph with 5 vertices
        Graph<String> graph2 = new UnweightedGraph<>(java.util.Arrays.asList(names),edgeList);
        System.out.println("\n The number of vetices in graph2 "+ graph2.getSize());
        System.out.println("The edges for graph2: ");
        graph2.printEdges();
        
        
        System.out.println("index of seattle in graph1 "+graph1.getIndex("Seattle"));
        System.out.println("graph1. getdegree(5) "+graph1.getDegree(5));
        System.out.println("graph 1 getvertex(4) "+ graph1.getVertex(4));
        
        
        
    
}
}