// Arnav Mathur
// 3/14/2020
// Homework 8
// Section: BC
// TA: Khushi Chaudhari

/* Class HuffmanTree is a class that compresses text files using the frequency of characters.
   It reduces the size of the file by only making bits for the most used characters. HuffmanTree
   can create an encoded file, decode a encoded file and create an initial compressed file. The
   file it creates is an integer followed by a mixture of 1's and 0's. This is printed in standard
   form.
*/

import java.util.*;
import java.io.*;

public class HuffmanTree2  {
   
   private HuffmanNode overallRoot;
   private Queue<HuffmanNode> frequency;
   
   /* pre: if value of the character in the file is not zero
      post: it creates a list of frequencies of the characters from the file
            creates a HuffmanTree to be used for printing the integer value of the characters
            and the bit form of the integers
   */
   public HuffmanTree2(int[] count) {
      HuffmanNode leaf = null;
      HuffmanNode left = null;
      HuffmanNode right = null;
      frequency = new PriorityQueue<HuffmanNode>();   
      for(int i = 0; i < count.length; i++) {
         if(count[i] != 0) {
            frequency.add(new HuffmanNode(count[i], i));
         }
      }
      frequency.add(new HuffmanNode(1, 256));
      while(frequency.size() > 1) {
         left = frequency.remove();
         right = frequency.remove();
         leaf = new HuffmanNode(left.freq() + right.freq(), -1, left, right);
         frequency.add(leaf);
      }
      overallRoot = frequency.remove();
   }
   
   // writes the tree to the printstream output in standard form.
   public void write(PrintStream output) {
      write(output, overallRoot, "");
   }
   
   /* pre : if the left and right of the HuffmanNodes are empty (signifying it is the end of the tree),
            it starts printing the tree.
      post: uses the HuffmanNodes and binary values to write the tree to the printstream
            in standard form.
   */
   private void write(PrintStream output, HuffmanNode node, String binary) {
      if(node.left() == null && node.right() == null) {
         output.println(node.ascii());
         output.println(binary);
      }
      else {
         write(output, node.left(), binary + 0);
         write(output, node.right(), binary + 1);
      }
   }
   
   /* post: reconstructs the HuffmanTree from an input file, the tree is in standard form.
   */
   public HuffmanTree2(Scanner input) {
   
      int length = 0;
      int ascii = -1;
      overallRoot = new HuffmanNode(-1, 0);
      HuffmanNode previous = null;
      HuffmanNode current = null;
      String line = "";
      
      while(input.hasNextLine()) {
         length++;
         if(length % 2 == 1) {
            ascii = Integer.parseInt(input.nextLine()); 
            line = input.nextLine();
         }
         else {
            previous = overallRoot;
            line = input.nextLine();
            buildTree(line, previous, current, ascii);
            previous = current;
         }
      }
   }
   
   /* pre: if it reaches the last line then it sets current node to the ascii number and 
           makes it's left and right nodes null as it is the last node in the tree
      post: if it is not the last node then sets current node's ascii value to -1.
   */      
   private void setter(int i, HuffmanNode current, HuffmanNode previous, String line, int ascii) {
     if(i == line.length() - 1) {
        current = new HuffmanNode(ascii, 0);
     }
     else {
        current = new HuffmanNode(-1, 0);
     }
   }
   
   /* pre: while input's bit values are greater than zero.
      post: decodes the file that was encoded using a special eof character to represent end of
            file. It writes the decoded file to the printstream output.
   */
   public void decode(BitInputStream input, PrintStream output, int eof) {
      int ascii = 0;
      while(input.readBit() > 0) {
         ascii = decode(input, eof);
         output.write(ascii);
      }
   }
   
   /* pre: while the eof value is not reached and the left and right nodes of the overallRoot
           are not null.
      post: Keeps going left or right until entire file is decoded.
            returns the ascii value at each node.
   */
   private int decode(BitInputStream input, int eof) {
      HuffmanNode temp = overallRoot;
      int binary = 0;
      while(temp.ascii() != eof && temp.left() != null && temp.right() != null) {
         binary = input.readBit();
         if(binary == 0) {
            temp = temp.left();
         }
         else {
            temp = temp.right();
         }
      }
      return temp.ascii();
   } 
   
   public HuffmanTree2(BitInputStream input) {
      int n = input.readBit();
      
   }
   
   private HuffmanNode buildTree(String line, HuffmanNode previous, HuffmanNode current, int ascii) {
      char a;
      for(int i = 0; i < line.length(); i++) {
         a = line.charAt(i);
         if(a == '0') {
            if(previous.left() == null) {
               setter(i, current, previous, line, ascii);
               previous.changeLeft(current);
            }
            else {
               current = previous.left();
            }
         }
         else if(previous.right() == null) {
            setter(i, current, previous, line, ascii);
            previous.changeRight(current);
         }
         else {
            current = previous.right();
         }
      }
      return current;
   }
}
