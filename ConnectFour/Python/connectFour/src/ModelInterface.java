/*
 *Courtney Dunbar
 * Connect Four
 * Model View Controller Design Pattern
 * ClassName: Model.java
 * 
 * 2 player game. One player receives red pieces. The other player receives black pieces.
 * The winner gets four of their pieces in a row either horizontally, vertically, or diagonally.
 * 
 */

import java.awt.Point;

public interface ModelInterface 
{
     public void movePlayer(Point location);
}
