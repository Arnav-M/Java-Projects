// Arnav Mathur
// 3/14/2020
// Homework 8
// Section: BC
// TA: Khushi Chaudhari
/* HuffmanNode class is the class used by HuffmanTree to navigate the tree and compare the values
   of frequencies of characters in the input file. 
*/

import java.util.*;
import java.io.*;

public class HuffmanNode implements Comparable<HuffmanNode> {
   private int freq;
   private int ascii;
   private HuffmanNode left;
   private HuffmanNode right;
   
   // constructs frequency and acii value HuffmanNodes with no left or right nodes.
   public HuffmanNode(int freq, int ascii) {
      this.freq = freq;
      this.ascii = ascii;
   }
   
   // sets the value of the nodes to be what they should be.
   public HuffmanNode(int freq, int ascii, HuffmanNode left, HuffmanNode right) {
      this.freq = freq;
      this.ascii = ascii;
      this.left = left;
      this.right = right;
   }
   
   // compares this HuffmanNode's frequency to another HuffmanNode.
   public int compareTo(HuffmanNode other) {
      return (freq - other.freq()); 
   }
   
   // returns the ascii value.
   public int ascii() {
      return ascii; 
   }
   
   // returns the freq.
   public int freq() {
      return freq;
   }
   
   // returns the value on the left node.
   public HuffmanNode left() {
      return left;
   }
   
   // returns the value on the right node.
   public HuffmanNode right() {
      return right;
   }
   
   // changes the left node
   public void changeLeft(HuffmanNode node) {
      left = node;
   }
   
   // changes the right node
   public void changeRight(HuffmanNode node) {
      right = node;
   }
}
