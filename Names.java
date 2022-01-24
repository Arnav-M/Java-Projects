// Arnav Mathur
// 5/18/2020
// CSE 142 A
// TA: Ana Jojic
// Assignment #6
//
// This program asks the user to input the name of a person and their sex to produce
// a graph using an input file which shows how highly ranked the person's name was in 
// a specific decade. It uses Drawing panel to create the graph and show it. The graph
// shows the name, the sex and the rank of the person. The width of the individual decades
// , the number of decades and the starting year can all be changed as needed to show the results.
// The file from which the data is taken can also be changed. 

import java.io.*;
import java.util.*;
import java.awt.*;

public class Names {
   
   public static final int DECADES = 14;
   public static final int START_YEAR = 1880;
   public static final int WIDTH = 70;

   public static void main(String[] args) throws FileNotFoundException {
      // throws FileNotFoundException
      Scanner input = new Scanner(new File("names.txt"));   
      introduction();
      String nameData = databaseSearch(input);
      
      if(nameData == "false") {
         System.out.println("name/sex combination not found");
      }
      else {
         DrawingPanel p = new DrawingPanel(DECADES * WIDTH, 550);
         Graphics g = p.getGraphics();
         drawGraph(g);
         drawGraphLines(nameData, g);  
      }  
   }
   
   // Prints out an introdcution about what the program does
   public static void introduction() {
      System.out.println("This program allows you to search through the");
      System.out.println("data from the Social Security Administration");
      System.out.println("to see how popular a particular name has been");
      System.out.println("since " + START_YEAR + ".");
      System.out.println();
   }
   
   // Searches through the file to see if a particular name and sex exists or not in the file.
   // If the name and sex combination does not exist it prints out a statement 
   // and ends the program and does not make any graph. 
   // The user can enter the name and sex in any type of casing. 
   // Returns either the name and rank of the person if he/she exists or returns false otherwise.
   // Uses scanner input as a parameter.
   public static String databaseSearch(Scanner input) {
      Scanner console = new Scanner(System.in);
      System.out.print("name? ");
      String name = console.next();
      System.out.print("sex (M or F)? ");
      String sex = console.next();
      String namePlusSex = name.toLowerCase() + " " + sex.toLowerCase();
      
      while(input.hasNextLine()) {
         String nameInfo = input.next() + " " + input.next();
         String rank = input.nextLine();
         if(nameInfo.toLowerCase().equals(namePlusSex)) {
            return nameInfo + rank;
         }
      }
      return "false";
   }
   
   // Draws the initial (empty) graph in drawing panel.
   // Uses graphics g as a parameter.
   public static void drawGraph(Graphics g) {
      g.drawLine(0, 525, 0, 0);
      g.drawLine(0, 25, DECADES * WIDTH, 25);
      g.drawLine(0, 525, DECADES * WIDTH, 525);
            
      for(int i = 0; i < DECADES ; i++) {
         g.drawLine((i + 1) * WIDTH, 0, (i + 1) * WIDTH, 550);
         g.drawString("" + (START_YEAR + (10 * i)), WIDTH * i, 550);
      }
   }
   
   // Draws the graph after using the parameters nameData and graphics g.
   // Uses a red color to draw the graph of rank of names. 
   // The names and sex are printed in uppercase on the graph. 
   // If rank is not in the first thousand then it is given a rank of zero.
   // Creates a scanner using nameData.
   public static void drawGraphLines(String nameData, Graphics g) {
      g.setColor(Color.RED);
      Scanner line = new Scanner(nameData);
      
      // initializes the x, y coordinates, the decadeCount, the rank and also the previous
      // y coordinate used on the graph.
      int x = 0;
      int y = 0;
      int rank = 0;
      int previous = 0;
      int decadeCount = 0;
      String display = line.next();
      display += " " + line.next().toUpperCase();
      
      while(line.hasNextInt() && decadeCount < DECADES)  {
         rank = line.nextInt();
         previous = y;
         
         if(rank > 0) {
            if(rank % 2 == 0) {
               y = 24 + (rank / 2);
            }
            else {
               y = 25 + (rank / 2);
            }
         }
         else {
            y = 525;
         }
         g.drawString(display + " " + rank, x, y);
         g.drawLine(x - WIDTH, previous,x, y);
         x += WIDTH;
         decadeCount++;
      }
   }
}