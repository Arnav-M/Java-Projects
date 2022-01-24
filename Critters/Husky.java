// Arnav Mathur
// 12/2/2019
// CSE 142 B
// TA: Jun Song
// Assignment #8
// This program is a class for the Husky critters
// and emulates the Husky's behavior

import java.util.*;
import java.awt.*;
 
public class Husky extends Critter { // extends means Giant is a member of critters
   
   // initializes private Random and int
   // users cannot change
   private Random r; 
   private int count;
   private Action one;
   private Action two;

   // Husky constructor
   public Husky() {
      r = new Random();
      count = 1;
   }
   
   // Randomizes the huskies move if it reaches a wall
   public Action move(CritterInfo info) {
      int move = r.nextInt(2) + 1;
      if (move == 1) {
         return Action.RIGHT; // returns an action which turns the critter right
      }
      else {
         return Action.LEFT; // returns an action which turns the critter left
      }
   }
   
   // returns the Husky's move
   // gets information from CritterInfo   
   public Action getMove(CritterInfo info) {
      count++;
      if (info.getFront() == Neighbor.OTHER) {
      return Action.INFECT; // returns an action which attacks the enemy
      }
      else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP; // returns an action which makes the critter move forward
      }
      else if (info.getFront() == Neighbor.SAME) {
         Action newMove1 = move(info);
         two = newMove1;
         return newMove1; // returns a random move 
      }
      else if (info.getFront() == Neighbor.WALL) {
         Action newMove = move(info);
         one = newMove;
         return newMove; // returns a random move
      }
      else {
         return one;
      }
   }
   
   // sets the color for the critter
   public Color getColor() {
      int color = r.nextInt(2)+1;
      if (color == 1) {
         return Color.MAGENTA; // makes the critter purple
      }
      else {
         return Color.BLACK; // makes the critter black
      }
   }
   
   // sets the critter's character
   public String toString() {
      return "ô¿ô";
   }
}