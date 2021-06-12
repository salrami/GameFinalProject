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
        frame.add(new gridDraw(frame.getSize()));
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String args[]) {
        new GameProjectFinal();
    }
    
    public static class gridDraw extends JPanel  implements MouseListener {
        int startColumn = 10;
        int startRow = 10;
        int cellWidth = 40;
        int turn = 2;
        int rows = 6;
        int columnumns = 7;
        boolean winner=false;
        String ccolumnor = "";
        
        Color[][] grid = new Color[rows][columnumns];
        
        public gridDraw(Dimension dimensions) {
            setSize(dimensions);
            setPreferredSize(dimensions);
            addMouseListener(this);
            
            int x = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int column = 0; column < grid[0].length; column++) {
                    grid[row][column] = new Color(255,255,255);
                   
                }
            
            }
        }
            
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            Dimension d = getSize();
            g2.setColor(new Color(0, 0, 0));
            g2.fillRect(0,0,d.width,d.height);
            startColumn = 0;
            startRow = 0;

            //2) draw grid here
            for (int row = 0; row < grid.length; row++) {
                for (int column = 0; column < grid[0].length; column++) {
                    g2.setColor(grid[row][column]);
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
                g2.drawString("WINNER - "+ ccolumnor,450,20);
                
                    
                    }
        }

        
        public void mouseClicked(MouseEvent e) {
            
        }

        
        public void mousePressed(MouseEvent e) {
             int x = e.getX();
            int y = e.getY();
            if(winner==false){
                int xSpot = x/cellWidth;
                int ySpot = y/cellWidth;
                ySpot = dropP(xSpot);
            
                if (ySpot < 0) {
                    System.out.println("not a valid entry");
                
                } else {
                
            
            
            
            if (turn %2==0) {
                grid[ySpot][xSpot] = new Color(255,0,0);
                
            } else {
                grid[ySpot][xSpot] = new Color(255,255,0);
            }
            turn++;
            if(checkForWinner(xSpot,ySpot, grid[ySpot][xSpot])){
                winner=true;
            }
        }
            repaint();
        }
        }
        
            public int dropP(int cc){
            int cr = grid.length-1;

            while(cr>=0){ 

                if(grid[cr][cc].equals(Color.white)){
                    return cr;
                }
                cr--;
            }

            return -1;

        
        }

        
        public void mouseReleased(MouseEvent e) {
            
        }

        
        public void mouseEntered(MouseEvent e) {
           
        }

        
        public void mouseExited(MouseEvent e) {
            reset();
        }
        
        public void reset(){
            winner=false;
            turn=2;
            for (int row = 0; row < grid.length; row++) {
                for (int column = 0; column < grid[0].length; column++) {
                    grid[row][column] = Color.white; 
                }
            }
        }
    
    public boolean checkForWinner(int cc,int cr, Color c){
            //search west and east
            int xStart = cc;
            int count = 1;
            //check west
            xStart--;
            while(xStart>=0){
                if(grid[cr][xStart].equals(c)){
                    count++;
                }else{
                    break;
                }
                if(count==4)
                    return true;

                xStart--;
            }

            //check east
            xStart = cc;
            xStart++;
            while(xStart<grid[0].length){

                if(grid[cr][xStart].equals(c)){

                    count++;
                }else{
                    break;
                }
                if(count==4)
                    return true;

                xStart++;
            }


            //check North
            count = 1;
            int yStart = cr;
            yStart--;
            while(yStart>0){
                if(grid[yStart][cc].equals(c)){
                    count++;
                }else{
                    break;
                }
                if(count==4)
                    return true;

                yStart--;
            }

            //check east
            yStart = cr;
            yStart++;
            while(yStart<grid.length){

                if(grid[yStart][cc].equals(c)){

                    count++;
                }else{
                    break;
                }
                if(count==4)
                    return true;

                yStart++;
            }
            /*
             * More Searches
             */

            //check NorthWest
            count = 1;
            yStart = cr;
            xStart = cc;
            xStart--;
            yStart--;
            while(yStart>0 && xStart>0){
                if(grid[yStart][xStart].equals(c)){
                    count++;
                }else{
                    break;
                }
                if(count==4)
                    return true;

                yStart--;
                xStart--;
            }

            yStart = cr;
            yStart++;
            xStart = cc;
            xStart++;
            while(yStart<grid.length && xStart<grid.length){

                if(grid[yStart][xStart].equals(c)){

                    count++;
                }else{
                    break;
                }
                if(count==4)
                    return true;

                yStart++;
                xStart++;
            }

            /*
             * More Searches
             */

            //check southWest
            count = 1;
            yStart = cr;
            xStart = cc;
            xStart--;
            yStart++;
            while(yStart<grid.length && xStart>0){
                if(grid[yStart][xStart].equals(c)){
                    count++;
                }else{
                    break;
                }
                if(count==4)
                    return true;

                yStart++;
                xStart--;
            }

           

    


}
    