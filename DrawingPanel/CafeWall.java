// Arnav Mathur
// 4/20/2020
// CSE 142 A
// TA: Ana Jojic
// Assignment #3
// This program makes a CafeWall design using DrawingPanel

import java.awt.*;

public class CafeWall {

   // the mortar seperates the spaces between the lines in the grid
   // and can be changed to increase the spaces or decrease them.
   public static final int MORTAR = 2;

   public static void main(String[] args) {
      // size of drawing panel 650,400
      // Background color of drawing panel : Gray 
      DrawingPanel panel = new DrawingPanel(650, 400);
      panel.setBackground(Color.GRAY);
      Graphics g = panel.getGraphics();
      
      // g, size, sets, x, y
      DrawRow(g, 20, 4, 0, 0);
      DrawRow(g, 30, 5, 50, 70);
 
      DrawGrid(g, 25, 4, 10, 150, 0 );
      DrawGrid(g, 25, 3, 250, 200, 10);
      DrawGrid(g, 20, 5, 425, 180, 10);
      DrawGrid(g, 35, 2, 400, 20, 35);
   }
   
   // Draws a row using a for loop
   public static void DrawRow(Graphics g, int size, int sets, int x, int y) {
      for (int i = 0; i < sets; i++) {
        g.setColor(Color.BLACK);
        g.fillRect(x + size * 2 * i, y, size, size);
        g.setColor(Color.BLUE);
        g.drawLine(x + size * 2 * i, y, x + size + size * 2 * i, y + size);
        g.drawLine(x + size + size * 2 * i, y, x + size * 2 * i, y + size);
        g.setColor(Color.WHITE);
        g.fillRect(x + size + size * 2 * i, y, size, size);
      }
   }
   
   // Draws the grid using mortar constant and the row method
   public static void DrawGrid(Graphics g, int size, int sets, int x, int y, int change) {
      for (int i = 0; i < sets * 2; i++) {
         DrawRow(g, size, sets, x + change * (i % 2), y + (MORTAR * i) + i * size);
      }
   } 
}
