//an interface to implements the various functions of a tree
package bstanimation;

/**
 *
 * @author harisu
 */
public interface Tree<E> extends Iterable<E>{
    //return true if the element is in the tree
    public boolean search(E e);
   //insert and element into a tree and returns true on success
    public boolean insert(E e);
    //returns true if element is successfully removed from the tree
    public boolean delete(E e);
    //print the nodes in inorder traversal
   public void inorder();
    //print the nodes in preorder traversal
   public void preorder();
    //print the nodes in postorder 
   public void postorder();
    //returns the number of elements in the tree
   public int getsize();
    //returns true if the tree is empty
   public boolean isEmpty();
    //removes all element from the list
   public void clear();
    
}
