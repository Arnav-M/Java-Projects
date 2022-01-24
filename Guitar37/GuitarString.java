// Arnav Mathur
// 1/15/2020
// Homework 2
// Section: BC
// TA: Khushi Chaudhari
// GuitarString class emulates a vibrating guitar string. It can be used with
// another program to create notes of sound.

import java.util.*;

public class GuitarString {
   
   private Queue<Double> q;
   private double buffer; 
   
   public static final double ENERGY_DECAY = 0.996;
   
   /* pre: frequency should be non-negative, ring buffer should be 
           greater than 2. Sampling rate is a constant.
      post: assigns 0.0 to the GuitarString to emulate it being at rest 
            throws IllegalArgumentException if pre conditions are not satisfed*/
   public GuitarString(double frequency) {
      q = new LinkedList<>();
      buffer = Math.round((StdAudio.SAMPLE_RATE/frequency));
      if(frequency <= 0 || buffer < 2) {
         throw new IllegalArgumentException();
      }
      for(int i = 0; i < buffer; i++) {
         q.add(0.0);
      }
   }
   
   /* pre: ring buffer should be greater than 2
      post: adds ring buffer values to the GuitarString throws IllegalArgument
            Exception if pre-conditions are not followed*/
   public GuitarString(double[] init) {
      q = new LinkedList<>();
      buffer = init.length;
      if(buffer < 2) {
         throw new IllegalArgumentException();
      }
      for(int i = 0; i < buffer; i++){
         q.add(init[i]);
      }
   }
   
   /* post: creates a random number between -0.5 and 0.5
            adds that value to buffer and removes the first value*/
   public void pluck() {
      for(int i = 0; i < buffer; i++){
         q.add(Math.random() - 0.5);
         q.remove();
      }
   }
   
   /* post: takes the average of 2 values then 
            multiplies the whole by the decay to get the Karplus-Strong update*/
   public void tic() {
      buffer = q.remove(); 
      q.add((buffer + q.peek()) * ENERGY_DECAY * 0.5);
   }
   
   /* post: returns the current sample */
   public double sample() {
      return q.peek();
   } 
}
