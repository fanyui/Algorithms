/*
BSTAnimation class for animating a binary search tree graphically

 */
package bstanimation;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author harisu
 */
public class BSTAnimation extends Application{
public static void main(String [] args){
    Application.launch();
}
    /**
     * @param args the command line arguments
     */
       @Override //override the start method in the application class
       public void start(Stage primaryStage){
        BST<Integer> tree = new BST<Integer>(); //create a tree
        BorderPane pane = new BorderPane();
        BTView view = new BTView(tree); //create a BTView
        pane.setCenter(view);
        
        TextField tfkey = new TextField();
        tfkey.setPrefColumnCount(3);
        tfkey.setAlignment(Pos.BASELINE_RIGHT);
        Button btnInsert = new Button("Insert");
        Button btnDelete = new Button("Delete");
        HBox hbox = new HBox(5);
        hbox.getChildren().addAll(new Label("Enter a Key:"),tfkey,btnInsert,btnDelete);
        hbox.setAlignment(Pos.CENTER);
        pane.setBottom(hbox);
        btnInsert.setOnAction(e->{
            int key = Integer.parseInt(tfkey.getText());
            if(tree.search(key)){//key is in the tree already
                view.displayTree();
                view.setStatus(key+ "is already in the tree");
            }
            else{
                tree.insert(key);//insert a new key
                view.displayTree();
                view.setStatus(key + "is inserted into the tree");
                
            }
        });
        
        btnDelete.setOnAction(e->{
            int key = Integer.parseInt(tfkey.getText());
            if(!tree.search(key)){//key not in the tree
                view.displayTree();
                view.setStatus(key + "is not in the tree");
                
            }
            else{
                tree.delete(key);//delet the key
                view.displayTree();
                view.setStatus(key + " is deleted from the tree");
            }
        });
        
        //create a scene and place the pane in the stage
         Scene scene = new Scene(pane,450,250);
         primaryStage.setTitle("BSTAnimation"); //set the stage title
         primaryStage.setScene(scene); //place the scene in the stage
         primaryStage.show(); //display the stage
    }
    
}
