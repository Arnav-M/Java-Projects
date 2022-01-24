import java.awt.*;

public class CafeWall1 {

    public static void main(String[] args) {
            DrawingPanel panel = new DrawingPanel(650, 400);
            panel.setBackground(Color.GRAY);
            Graphics g = panel.getGraphics();

            DrawRow(g, 0, 0, 20, 4);
            DrawRow(g, 50, 70, 30, 5);
 
            DrawGrid(g, 10, 150, 25, 4, 0);
            DrawGrid(g, 250, 200, 25, 3, 10);
            DrawGrid(g, 425, 180, 20, 5, 10);
            DrawGrid(g, 400, 20, 35, 2, 35);
            
    }
           
  
    public static void DrawRow(Graphics g, int x, int y, int size, int sets) {  
        for (int i = 0; i < sets; i++) {
            g.setColor(Color.BLACK);
            
            g.fillRect( size, size, x + size * 2 * i, y);
            
            g.setColor(Color.WHITE);
            
            g.fillRect(size, size, x + size + size * 2 * i, y);
            
            g.setColor(Color.BLUE);
            
            g.drawLine( x + size + size * 2 * i, y + size, x + size * 2 * i, y);
            
            g.drawLine( x + size * 2 * i, y + size, x + size + size * 2 * i, y);
        }
    }
      // x, y, size, sets, change
    public static void DrawGrid(Graphics g, int x, int y, int size, int sets, int change) {
        for (int i = 0; i < sets * 2; i++) {
            DrawRow(g, x + change * (i % 2), y + (size * i) + (2 * i), size, sets);
        }
    } 
}
