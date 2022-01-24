// Arnav Mathur
// 1/30/2020
// Homework 3
// Section: BC
// TA: Khushi Chaudhari

/* Class AssassinManager is used by AssassinMain to kill people
   in a kill chain. The name of the person to be killed can be in 
   Lowercase or Uppercase it doesn't matter. This class also shows 
   which person is stalking which person in the kill chain.
*/

import java.util.*;

public class AssassinManager {
   
   private AssassinNode firstKiller; // this is the front of the kill chain
   private AssassinNode firstKill; // this is the front of the killed people list
   
   /* pre : size of the kill chain should not be zero
            if there is no one in kill chain the first person in the kill ring
            is assigned that spot
      post : throws IllegalArgumentException if kill chain is zero in size
             creates a kill chain using names in kill ring */
   public AssassinManager(List<String> names) {
      if(names.size() == 0) {
         throw new IllegalArgumentException();
      }
      for(int i = 0; i < names.size(); i++) {
         String killerName = names.get(i);
         AssassinNode killRing = new AssassinNode(killerName);
         if(firstKiller == null) {
            firstKiller = killRing;
         }
         else {
            AssassinNode temp = firstKiller;
            while(temp.next != null) {
               temp = temp.next;
            }
            temp.next = killRing;
         }
      }
   }
   
   /* pre : if there is only person in the list, it prints <person> is stalking
            <person>
      post: prints out who is stalking who in the Kill chain
    */
   public void printKillRing() {
      AssassinNode temp = firstKiller;
      while(temp != null) {
         if(temp.next == null) {
            System.out.println("    " + temp.name + " is stalking " + firstKiller.name);
         }
         else {
            System.out.println("    " + temp.name + " is stalking " + temp.next.name);
         }
         temp = temp.next;
      }
   }
   
   /* pre : if there is only person in the list, it prints <person> is stalking
            <person>
      post: prints out who is stalking who in the Kill chain
   */
   public void printGraveyard() {
      AssassinNode temp = firstKill;
      while(temp != null) {
         System.out.println("    " + temp.name + " was killed by " + temp.killer);             
         temp = temp.next;
      }
      System.out.println();
   }
   
   // checks if kill ring has the name the user provides
   // returns true or false
   public boolean killRingContains(String name) {
      AssassinNode temp = firstKiller;
      return (contains(name, temp));
   }
   
   // checks if the graveyard has the name the user provides
   // returns true or false
   public boolean graveyardContains(String name) {
      AssassinNode temp = firstKill;
      return (contains(name, temp));
   }
   
   /* pre : compares name to the name in the graveyard or killchain
      post : returns true or false   
   */
   private boolean contains(String name, AssassinNode temp) {
      while(temp != null) {
         if(temp.name.equalsIgnoreCase(name)) {
            return true;
         }
         temp = temp.next;
      }
      return false;
   }
   
   // returns true or false to show if the game is over
   public boolean gameOver() { 
      return (firstKiller.next == null);
   }
   
   // returns the name of the winner
   public String winner() {
      if(!gameOver()) {
         return null;
      }
      return firstKiller.name;
   }
   
   /* pre : checks if kill ring contains name 
            checks if game is not over
      post : throws IllegalArgumentException if kill ring doesn't contain name
             throws IllegalStateException if game is over and user tries to kill 
             someone
             kills the person the user specifies by moving him/her from the kill
             ring to the graveyard 
   */
   public void kill(String name) {
      if(!killRingContains(name)) {
         throw new IllegalArgumentException();
      }
      if(gameOver()) {
         throw new IllegalStateException();
      }
      else {
         AssassinNode victim = null;
         
         // kills if victim is at front of list
         if(firstKiller.name.equalsIgnoreCase(name)) { 
            String assassin = null;
            AssassinNode temp = firstKiller;
            while(temp != null) { 
               if(temp.next == null) {
                  assassin = temp.name;
               }
               temp = temp.next;
            }
            victim = firstKiller;
            victim.killer = assassin;
            firstKiller = firstKiller.next;
            if(firstKill != null) {
               victim.next = firstKill;
            }
            else {
               victim.next = null;
            }
            firstKill = victim;
         } 
         else {
            // kills if victim is in the middle or end
            AssassinNode current = firstKiller.next;
            AssassinNode previous = firstKiller;
            while(!current.name.equalsIgnoreCase(name) && current.next != null) {
               previous = current;
               current = current.next;
            }   
            AssassinNode temp = firstKill;
            firstKill = current;            
            previous.next = previous.next.next;
            firstKill.next = temp;
            firstKill.killer = previous.name;            
         }               
      }
   }
}
