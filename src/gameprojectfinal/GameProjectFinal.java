package gameprojectfinal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GameProjectFinal {
    private JFrame frame;

    public GameProjectFinal() {
        frame = new JFrame("Connect Four Game");
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(frame.getSize());
        frame.add(new MultiDraw(frame.getSize()));
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String args[]) {
        new GameProjectFinal();
    }
    
    public static class MultiDraw extends JPanel  implements MouseListener {
        int startColumn = 10;
        int startRow = 10;
        int cellWidth = 40;
        int turn = 2;
        int rows = 6;
        int columns = 7;
        boolean winner=false;
        String ccolor = "";
        
        Color[][] grid = new Color[rows][columns];
        
        public MultiDraw(Dimension dimension) {
            setSize(dimension);
            setPreferredSize(dimension);
            addMouseListener(this);
            
            int x = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    grid[row][col] = new Color(255,255,255);
                   
                }
            
            }
            
        public void drawBoard(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            Dimension d = getSize();
            g2.setColor(new Color(0, 0, 0));
            g2.fillRect(0,0,d.width,d.height);
            startColumn = 0;
            startRow = 0;

            //2) draw grid here
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    g2.setColor(grid[row][col]);
                    g2.fillOval(startColumn, startRow, cellWidth, cellWidth);
                    startColumn += cellWidth;
                  
                }
                
                startColumn = 0;
                startRow += cellWidth;

               
            }

            g2.setColor(new Color(255, 255, 255));
            if(winner==false){
                if (turn %2==0) 
                    g2.drawString("Red's Turn", 400,20);
                 else 
                    g2.drawString("Yellow Turn",400,20);
                
            } else {
                g2.drawString("WINNER - "+ ccolor,450,20);
                
                    
                    }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

}
    