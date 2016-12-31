/*
 * To display a graph on a pane we use this class called 
 * GraphView
 *
 */
package displayusmap;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
/**
 *
 * @author harisu
 */
public class GraphView extends Pane {
    private Graph<?extends Displayable> graph;
    
    public GraphView(Graph<? extends Displayable> graph){
        this.graph = graph;
        
        //Draw vertices
        java.util.List<? extends Displayable> vertices = graph.getVertices();
        for(int i = 0; i<graph.getSize(); i++){
            int x = vertices.get(i).getX();
            int y = vertices.get(i).getY();
            String name = vertices.get(i).getName();
            
            getChildren().add(new Circle(x,y,16));//display a vertex
            getChildren().add(new Text(x-8, y-18,name));
        }
        
        //draw edges for pairs of vertices
        for(int i = 0;i<graph.getSize(); i ++){
            java.util.List<Integer> neighbors = graph.getNeigbors(i);
            int x1 = graph.getVertex(i).getX();
            int y1 = graph.getVertex(i).getY();
            for(int v:neighbors){
                int x2 = graph.getVertex(v).getX();
                int y2 = graph.getVertex(v).getY();
                
                //Draw an edge for (i,v)
                getChildren().add(new Line(x1,y1,x2,y2));
            }
        }
    }
}
