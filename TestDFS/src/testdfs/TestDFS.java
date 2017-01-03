/*
 * Demonstrate a dfs using the graph created and determine if the graph
 * is connected or not
 * it also start by listing the number of edges present inthe graph
 * it also prints the vertices and their respective parents
 */
package testdfs;

/**
 *
 * @author harisu
 */
public class TestDFS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String[] vertices = {"Seattle", "San Francisco", "Los Angeles","Denver", "Kansas City","Chicago","Boston","New York","Atlanta", "Miami","Dallas","Houston","Ndu"};
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
        Graph<String> graph = new UnweightedGraph<>(vertices, edges);
        
         AbstractGraph <String>.Tree dfs = graph.dfs(graph.getIndex("Chicago"));
         java.util.List<Integer> searchOrders = dfs.getSearchOrder();
         //display the edges present on the graph 
         graph.printEdges();
         
         //display the original number of vertices in the graph
         System.out.println(" The original number of vertices in the graph is: "+graph.getSize());
         //display the number of vertices that have been obtained from the search of the graph that is return by the dfs method
         System.out.println(dfs.getNumberOfVerticesFound()+ " vertices are searched in this dfs order");
         //check if a graph is connected 
         if(graph.getSize()!= dfs.getNumberOfVerticesFound())
             System.out.println("This graph is not connected ");
         
         for (int i = 0; i < searchOrders.size(); i++) {
            if(dfs.getParent(i) != -1)
                 System.out.println(" Parent of "+graph.getVertex(i)+ " is "+ graph.getVertex(dfs.getParent(i)));
            
        }
    }
    
}
