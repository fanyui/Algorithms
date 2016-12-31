/*
 * provides method for obtaining the x and y coordinates
 * and make vertices instances of displayable
 */
package displayusmap;

/**
 *
 * @author harisu
 */
public interface Displayable {
    public int getX(); //get the x-cordinate of the vertex
    public int getY(); //get y-coordinate of the vertex
    public String getName();//get display name of the vertex
}
