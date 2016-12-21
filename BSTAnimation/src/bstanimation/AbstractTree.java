/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstanimation;

/**
 *
 * @author harisu
 */
public abstract class AbstractTree<E> implements Tree<E> {
    @Override //inorder traversal
    public void inorder(){
        
    }
    @Override //postorder traversal
    public void postorder(){
        
    }
    @Override //preorder traversal 
    public void preorder(){
        
    }
    @Override //return true if list is empty 
    public boolean isEmpty(){
        return getsize() ==0;
    }
    
}
