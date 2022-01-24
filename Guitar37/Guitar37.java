// Arnav Mathur
// 1/21/2020
// Homework 2
// Section: BC
// TA: Khushi Chaudhari

/* Class Guitar37 can be used to play piano notes in the form of a guitar which
   have frequency from 110Hz to 180Hz. It uses keyboard input which is pre defined 
   to play the GuitarString. The pitch of this Guitar is between -24 to 24. 
   It uses one of 37 keys on the keyboard to play sounds. */

import java.util.*;
import java.io.*;

public class Guitar37 implements Guitar {
   
   private GuitarString[] notes; // stores the frequency of each note
   private int tics; 
   
   public static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "; // keyboard layout
   private static final int KEYBOARD_SIZE = KEYBOARD.length(); 
   
   // Creates a storage of the different frequencies used in the guitar string
   public Guitar37() {
      notes = new GuitarString[KEYBOARD_SIZE];
      for(int i = 0; i < KEYBOARD_SIZE; i++){
         notes[i] = new GuitarString(440.0 * Math.pow(2, ((i - 24.0)/12.0)));
      }
   }
   
   // pre: pitch has to be in range of -24 < pitch < 37, ignores if the key can't
   //      be played
   // post: plays the note the user selects using the pitch inputted
   public void playNote(int pitch) {
      int index = pitch + 24;
      if(index >= 0 && index < KEYBOARD_SIZE) {
         notes[index].pluck();
      }
   }
   
   // checks if the key inputted by user is a valid one on the Guitar
   public boolean hasString(char string) {
      return (KEYBOARD.indexOf(string) != 38);
   }
   
   // pre: uses hasString to check if valid character is input
   // post: throws IllegalArgumentException if key is invalid
   //       plucks the string which is valid
   public void pluck(char string) {
      if (!hasString(string)) {
         throw new IllegalArgumentException();
      }
      notes[KEYBOARD.indexOf(string)].pluck();
   }
   
   // returns the sample which is the sum of all strings
   public double sample() {
      double sample = 0.0;
      for(int i = 0; i < KEYBOARD_SIZE; i++) {
         sample += notes[i].sample();
      }
      return sample;
   }
   
   // increases the time by one each time its called using tics
   public void tic() {
      for(int i = 0; i < KEYBOARD_SIZE; i++) {
         notes[i].tic();
      }
      tics++;
   }
   
   // returns tics which is the time of the music file
   public int time() {
      return tics;
   }
}
