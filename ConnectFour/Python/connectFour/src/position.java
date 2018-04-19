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

public class position  
{
   public enum Pieces {blank, rValue, bValue};
   private int value;
   private Pieces position;

   
   public static char[] validPieces = {'y', 'r', 'b'};
   public static char[] valueRanks = validPieces;

   public position()
   {
      this.set(Pieces.blank);
   } 
   
   public position(Pieces pos)
   {
      String strRanks = new String(valueRanks);
      value = strRanks.indexOf(this.getValue());
      this.set(pos);
   } 

   public char getValue() 
   {
      return validPieces[value];
   } 

  public Pieces getMark()
   {
      return this.position;
   } 

   public void set(Pieces pos)
   {
      this.position = pos;
   } 
   
   public int compareTo(Object t)
   {
      position m = (position) t;

      if (t.getClass() != this.getClass())
         return 1;

      String strRanks = new String(valueRanks);
      if (strRanks.indexOf(m.getValue()) <= -1)
         return 1;
      
      if (strRanks.indexOf(m.getValue()) < strRanks.indexOf(this.getValue()))
         return 1;
      
      if (strRanks.indexOf(m.getValue()) == strRanks.indexOf(this.getValue()))
         return 0;
      
      if (strRanks.indexOf(m.getValue()) >= strRanks.indexOf(this.getValue())-1)
         return -1;
      
      return 1;
   } 

   public String toString()
   {
      String returnValue = "";
      if (position != Pieces.blank)
      {
         returnValue =  String.valueOf(this.getValue());
      } 
      return returnValue;
   } 

   public boolean equals(position m)
   {
      if (this.getValue() == m.getValue())
         return true;

      return false;
   } 
} 
