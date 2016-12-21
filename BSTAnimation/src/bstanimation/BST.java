/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstanimation;


/**
 *
 * @author harisu
 * @param <E>
 */
public class BST <E extends Comparable<E>> extends AbstractTree<E>{
    protected TreeNode<E> root; //start from the root
    protected int size =0; //size
    
    //default bst by
    public BST(){
        
    }
    
    //create BST from ans array of object
    public BST(E[] object){
        for(int i=0;i<object.length;i++){
            insert(object[i]);
        }
    }
    
    @Override //returns true if the element is in the list
    public boolean search(E e){
        TreeNode<E> current = root; //start search from the root
         while(current != null){
             if(e.compareTo(current.element)<0){
                 current = current.left;
             }
             else if(e.compareTo(current.element)>0){
                 current = current.right;
             }
             else //a match is found
                 return true;
         }
         return false;
    }
    
   @Override //insert elements into the binary search returns true if successfull
    public boolean insert(E e){
        if(root ==null)
            root = createNewNode(e); //creates a new root
        else{
            //find the parent
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while(current != null)
                if(e.compareTo(current.element)<0){
                    parent = current;
                    current = current.left;
                }
                else if(e.compareTo(current.element)>0){
                    parent = current;
                    current = current.right;
                }
                else 
                    return false; //element already exixt repetition not allowd
                //create new node and add to the parent
                if(e.compareTo(parent.element)<0)
                    parent.left = createNewNode(e);
                else
                    parent.right = createNewNode(e);
                
            }
            size++;
            return true; //element has successfully been added
        }
    
    /**
     *
     * @param e
     * @return
     */
    protected TreeNode<E> createNewNode(E e){
            return new TreeNode<>(e);
        }
    
    @Override //inorder traversal from the root
    public void inorder(){
        inorder(root);
    }
    //inorder traversal method from the parameter passed ie subtree
    protected void inorder(TreeNode<E> root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.element+" ");
        inorder(root.right);
    }
    
    @Override //postorderTraversal from the root
    public void postorder(){
        postorder(root);
    }
    //method to implement postorder traversal from a particular node 
    protected void preorder(TreeNode<E> root){
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.element +" ");
    }
    
    @Override //preorder traversal from the root
    public void preorder(){
        preorder(root);
    }
    //preorder traversal from the subtree
    protected void postorder(TreeNode<E> root){
        if(root == null) 
            return;
        System.out.println(root.element+ " ");
        preorder(root.left);
        preorder(root.right);
    }
    
    //this inner class is static because it does not access any istance member defined in its outer class
    public static class TreeNode<E extends Comparable<E>>{
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;
        
        protected TreeNode(E e){
            element = e;
        }
    }
    @Override //get the number of nodes in the class
    public int getsize(){
        return size;
    }
    //return the root of the tree
    public TreeNode<E> getRoot(){
        return root;
    }
    //return the path from the root leading to a specified element
    public java.util.ArrayList<TreeNode<E>> path(E e){
        java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
        TreeNode<E> current = root; //start from the root before return ing the path
        while(current != null){
            list.add(current);//add the node to the list
            if(e.compareTo(current.element)<0){
                current = current.left;
            }
            else if(e.compareTo(current.element)>0){
                current = current.right;
            }
            else break;
        }
        return list;
    }
    @Override //delete an element from the binary search tree
    public boolean delete(E e){
        //fist find the node to be deleted and find the parent
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while(current!= null){
            if(e.compareTo(current.element)<0){
                parent = current;
                current = current.left;
        }   
            else if(e.compareTo(current.element)>0){
                parent = current;
                current = current.right;
            }
            else break;
  
        }
        if(current ==null)
            return false; //element is not in the tree so was not deleted
    
       //case 1: current has no child
       if(current.left==null){
           //connect the parent with the right child of the current node
           if(parent == null){
               root = current.right;
           }
           else{
               if(e.compareTo(parent.element)<0)
                   parent.left = current.right;
               else
                   parent.right = current.right;
           }
       }
       else{
    //case 2: the current node has a left child
    //locate the rightmost node in the left subtree of 
    //the current node and also it parent
    TreeNode<E> parentOfRightMost = current;
    TreeNode<E> rightMost = current.left;
    
    while(rightMost.right != null){
        parentOfRightMost = rightMost;
        rightMost = rightMost.right; //keep going to the right
        
    }
   // replace the element in current by the element in rightMost
            current.element = rightMost.element;
            //eliminate rightMost node
            if(parentOfRightMost.right == rightMost)
                parentOfRightMost.right= rightMost.left;
            else
                //special case:parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
    }
       size--;
       return true; //successfull delete
}
    @Override // obtain and iterator use inorder
    public java.util.Iterator<E> iterator(){
        return new inorderiterator();
    }
    
    //innner clase inorderiterator
    private class inorderiterator implements java.util.Iterator<E>{
        //stores element in a list
        private java.util.ArrayList<E> list = new java.util.ArrayList<>();
                //points to the current element in list
                public int current = 0;
                public inorderiterator(){
                    inorder(); //traverse binary tree and store element in list
                }
                //inorder traversal from the root
                private void inorder(){
                    inorder(root);
                }
                //inorder traversal from the root
                private void inorder(TreeNode<E> root){
                    if(root == null)
                        return;
                    inorder(root.left);
                    list.add(root.element);
                    inorder(root.right);
                }
                @Override //more element for traversal ?
                public boolean hasNext(){
                    if(current <list.size())
                        return true;
                    return false;
                }
                @Override //get the current element and move to the next
                public E next(){
                    return list.get(current++);
                }
                @Override //remove the current element
                public void remove(){
                    delete(list.get(current));//delete the current element
                    list.clear(); //clear the list
                    inorder();//Rebuild the list
                    
                }
    }
    
    @Override //Remove all elements from the list
    public void clear(){
        root = null;
        size = 0;
    }
}   

