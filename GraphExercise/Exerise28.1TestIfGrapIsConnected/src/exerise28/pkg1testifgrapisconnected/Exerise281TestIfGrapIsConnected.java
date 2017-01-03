/*
 * A programe that reads the graph from a file specified by he user and 
 * construct a graph.
 * It prints the edges and 
 * it uses dfs on the graph to check whether the graph is connected or not
 *
 */
package exerise28.pkg1testifgrapisconnected;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;
/**
 *
 * @author harisu
 */
public class Exerise281TestIfGrapIsConnected {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //create a list to store the edges 
        java.util.ArrayList<AbstractGraph.Edge> edgeList = new java.util.ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println(" input the name of the file ");
        String name = in.next();
   Scanner input = new Scanner(new File(name));
    int intValue = Integer.parseInt(input.nextLine());

        System.out.println(intValue);
        System.out.println("The edges of the graph is");
while(input.hasNext()){
      String line = input.nextLine();
      //split the input line into and array of strings
       String[] result = line.split(" ");
        //create edges using the splitted line as in (u,v1), (u,v2) etc
        for(int i=1;i<result.length ;i++ ){
            edgeList.add(new AbstractGraph.Edge(Integer.parseInt(result[0]), Integer.parseInt(result[i])));
 
        }
        
        //edgeList.add(new AbstractGraph.Edge(0, 2));
  
} 
        //construct the graph
       Graph<Integer> graph = new UnweightedGraph<>(edgeList,intValue);
       //prints the edges of the graph
       graph.printEdges();
       
       //perform dfs on the graph
       AbstractGraph.Tree dfs = graph.dfs(0);
       //determine if the graph is connected
       if(dfs.getNumberOfVerticesFound()!= graph.getSize())
            System.out.println("Graph is not connected");
       else
            System.out.println("Graph is connected");
}
}
