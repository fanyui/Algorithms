/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstanimation;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 *
 * @author harisu
 */
public class BTView extends Pane{
    private BST<Integer> tree = new BST<>();
    private double radius = 15; //tree node raduis
    private double vGap = 50; //Gap between two levels in a tree
    BTView(){
        
    }
    BTView(BST<Integer> tree){
        this.tree = tree;
        setStatus("Tree is Empty");
    }
    public void setStatus(String msg){
        getChildren().add(new Text(20,20,msg));
    }
    
    public void displayTree(){
        this.getChildren().clear(); //clear the )
        if(tree.getRoot() != null){
            //display tree recursively
            displayTree(tree.getRoot(),getWidth()/2,vGap,getWidth()/4);
            
        }
    }
    //display a subtree rooted at position (x,y)
    private void displayTree(BST.TreeNode<Integer> root,double x,double y,double hGap){
        if(root.left != null){
            //draw a line to the left node
            getChildren().add(new Line(x-hGap,y+vGap,x,y));
            //draw the left subtree recursively
            displayTree(root.left,x - hGap, y+vGap,hGap/2);
        }
        if(root.right != null){
            //draw  a line to the right node
            getChildren().add(new Line(x+hGap, y+vGap ,x,y));
            //draw the right subtree recursively
            displayTree(root.right,x + hGap,y+vGap,hGap/2);
            
        }
        //display a node
        Circle circle = new Circle(x,y,radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle,new Text(x-4,y+4,root.element +""));
    }
}
