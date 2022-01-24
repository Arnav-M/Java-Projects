// Arnav Mathur
// 4/20/2020
// CSE 142 A
// TA: Ana Jojic
// Assignment #3
// This program makes an Illuminati figure

import java.awt.*;
public class Doodle {
   public static void main(String[] args) {
   
      // size of drawing panel 200,200
      DrawingPanel panel = new DrawingPanel(200, 200);
      panel.setBackground(Color.BLACK);
      Graphics g = panel.getGraphics();
      
      //prints out illuminati
      Illuminati(g, 20, 110, 80, 10);
   }
   // Method that makes the illuminati triangle
   public static void Illuminati(Graphics g,int x,int y,int z,int w) {
        g.setColor(Color.GREEN);
        g.drawLine(x, y, z, w);
        g.drawLine(x + 120, y, z, w);
        g.drawLine(x, y, z + 60 , y);
        g.setColor(Color.YELLOW);
        g.drawOval(50, 55, 60, 30);  
        g.setColor(Color.WHITE);
        g.fillOval(70, 65, 20, 20);
   }
}