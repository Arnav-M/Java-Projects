// Arnav Mathur
// 6/2/2020
// CSE 142 A
// TA: Ana Jojic
// Assignment #8
// This program is a class for the Giant in Critters and emulates the Giant's behavior.

import java.util.*;
import java.awt.*;

public class Giant extends Critter { // Extends shows that the Giant is a member of critters.
   
   // Initializes private ints, strings and arrays.
   // Users cannot change.
   private int count;  
   private String[] sounds = {"fee", "fie", "foe", "fum"}; 
   
   // Giant's constructor.
   public Giant() {
      count = 0;
   }
   
   // Returns the Giant's move.
   // Gets information from CritterInfo.  
   public Action getMove(CritterInfo info) {
      count++;
      
      // If there is any object apart from its own type in front it returns the infect command.
      if (info.getFront() == Neighbor.OTHER) { 
         return Action.INFECT; // returns an action which attacks the enemy.
      }
      
      // If there is no object in front of the critter, the critter returns the hop command.
      else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP; // Returns an action which makes the critter move forward.
      }
      
      // If any of the previous two conditions are not fulfilled it returns 
      // the action to turn right.
      else {  
         return Action.RIGHT; // Returns an action which turns the critter right.
      }
   }
   
   // Sets the color for the critter.
   public Color getColor() {
      return Color.GRAY; // Makes the critter gray.
   }
 
   // Sets the critter's character, which is stored in an array.
   public String toString() { 
      return sounds[count / 6 % 4]; 
      // Returns either of the four words in the array depending on the no. of moves.
   } 
}