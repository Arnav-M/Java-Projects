// Arnav Mathur
// 6/2/2020
// CSE 142 A
// TA: Ana Jojic
// Assignment #8
// This program is a class for the Lion critter and emulates the Lion's behavior.

import java.util.*;
import java.awt.*;

public class Lion extends Critter { // Extends shows that lion is a member of critters.

   // Initializes private ints, random and new color.
   // Users cannot change.
   private Random r; 
   private Color original;
   private int count;
   
   // Lion's constructor.
   public Lion() {
      r = new Random();
      count = 0; 
   }
   
   // Returns the Lion's move. 
   // Gets info from CritterInfo.
   public Action getMove(CritterInfo info) {
      
      count++;
      // Changes color every three moves. 
      if (count % 3 == 0) {
         original = randColor();
      } 
     
      // If there is an enemy in front of it the critter returns the command 'infect'. 
      if (info.getFront() == Neighbor.OTHER){
         return Action.INFECT; // Returns an action which attacks the enemy.
      }
      
      // If the object in front is a wall or if the object to the right 
      // is a wall the critter turns left.
      else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
         return Action.LEFT; // Returns an action which turns the critter left.
      }
      
      // If the object in front is a critter of its own type then it turns to the right.
      else if (info.getFront() == Neighbor.SAME) {
         return Action.RIGHT; // Returns an action which turns the critter right.
      }
      
      // If none of the conditions above are satisfied it returns the move as a 'hop'.
      else {
         return Action.HOP; // Returns an action which makes the critter move forward.
      }       
   }
   
   // Uses if conditions and Random to decide what color the critter is for three moves.
   public Color randColor() {
      int color = r.nextInt(3) + 1;
      if (color == 1) {
         return Color.GREEN; // Makes the critter green.
      }
      else if (color == 2) {
         return Color.BLUE; // Makes the critter blue.
      }
      else {
         return Color.RED; // Makes the critter red.
      }  
   }
   
   // Sets the color for the critter.
   public Color getColor() { 
      if(count == 0) {
         original = randColor();
      }
      return original; // Returns the color which is determined by randColor().
   }

   // Sets the critters character as the letter 'L'.
   public String toString() {
      return "L"; // Returns the critter's character.
   }
}