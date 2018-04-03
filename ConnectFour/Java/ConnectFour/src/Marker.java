public class Marker  implements Comparable
{
   public enum Marks {blank, rValue, bValue};
   private int value;
   private Marks marker;

   public static char[] validMarkerValues = {'y', 'r', 'b'};
   public static char[] valueRanks = validMarkerValues;

   public Marker()
   {
      this.set(Marks.blank);
   } 
   
   public Marker(Marks pos)
   {
      String strRanks = new String(valueRanks);
      value = strRanks.indexOf(this.getValue());
      this.set(pos);
   } 

   public char getValue() 
   {
      return validMarkerValues[value];
   } 

  public Marks getMark()
   {
      return this.marker;
   } 

   public void set(Marks pos)
   {
      this.marker = pos;
   } 
   
   public int compareTo(Object t)
   {
      Marker m = (Marker) t;

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
      if (marker != Marks.blank)
      {
         returnValue =  String.valueOf(this.getValue());
      } 
      return returnValue;
   } 

   public boolean equals(Marker m)
   {
      if (this.getValue() == m.getValue())
         return true;

      return false;
   } 
} 
