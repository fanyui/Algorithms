//To be used in creating the nodes of the tree
package bstanimation;

/**
 *
 * @author harisu
 */
public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;
    
    public TreeNode(E e){
        element = e;
    }
}
