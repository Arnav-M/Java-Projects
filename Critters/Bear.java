// Arnav Mathur
// 6/2/2020
// CSE 142 A
// TA: Ana Jojic
// Assignment #8
// This program is a class for the Bear critters and emulates the Bear's behavior.

import java.util.*;
import java.awt.*;

public class Bear extends Critter { // Extends means Bear is a member of critters.
   
   // Initializes private ints and booleans.
   // Users cannot change.
   private boolean polar;
   private int count;
   
   // Bear's constructor.
   public Bear (boolean polar) {
      count = 0;
      this.polar = polar;
   }
   
   // Returns the Bear's move.
   // Gets info from CritterInfo.
   public Action getMove(CritterInfo info){
      count++;
      
      // Returns an 'infect' action if the enemy is in the front.
      if (info.getFront() == Neighbor.OTHER){
         return Action.INFECT; // Returns an action which attacks the enemy.
      }
      
      // Returns an 'hop' action if there is no object in front of the critter.
      else if (info.getFront() == Neighbor.EMPTY){
         return Action.HOP; // Returns an action that makes the critter jump one step ahead.
      }
      
      // If none of the previous two conditions are true it moves left.
      else {
         return Action.LEFT; // Returns an action which turns the critter left.
      }         
   }
   
   // Sets the color for the critter.
   public Color getColor() {
      if (polar) {
         return Color.WHITE; // Makes the critter white if polar = true.
      }
      else {
         return Color.BLACK; // Makes critter black if polar = false.
      }
   }
   
   // Sets the critters character.
   // Returns character '/' on the first move, '\' on the second and alternates every move.
   public String toString() {
      if (count % 2 == 0) {
         return "/"; // Returns the critter's character as this on alternate moves.
      }
      else {
         return "\\"; // Returns the critter's character as this on alternate moves.
      }
   }
}