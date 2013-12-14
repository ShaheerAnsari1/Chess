import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;


/**
 * @author Cian
 * This class will draw our game board
 */

class Board extends JComponent implements MouseListener{
	
	public int gameBoard[][] = new int[8][8];
	public int row = 8;
	public int column = 8;
	public int cell = 80;
	public int rowSelected;
	public int colSelected;
	
	
	public Board(){
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, 640, 640);
		drawBoard(g2d);
	}
	
	public void drawBoard(Graphics2D g2d){
		g2d.setColor(Color.black);
		
		// draw the edge lines (0,0,0,640), (0,0,640,0), (0,640,640,640), (640,0,640,640)
		g2d.drawLine(0, 0, 0, 639);
		g2d.drawLine(0, 0, 639, 0);
		g2d.drawLine(0, 639, 639, 639);
		g2d.drawLine(639, 0, 639, 639);
		
		// draw the horizontal lines using a loop from one to 7, coordiates of each line is (0, x*80, 640, x*80) also
		// draw vertical lines with coordinates of (x*80, 0, x*80, 640)
		for(int i = 1; i < 8; i++) {
			g2d.drawLine(0, i*80, 640, i*80);
			g2d.drawLine(i*80, 0, i*80, 640);
		}

		for ( int row = 0; row < 8; ++row )  // ++ means "increment by one" 
		    // This inner loop counts over all the (white or black) squares in a row. It starts at 0 if row is even, or 1 if row is odd, and goes up to no more than 7 (so it will count 1-3-5-7 or 0-2-4-6 
		    for ( int i = row % 2; i <= 7; i+= 2 ) {  // += means "add to that variable
		    	g2d.setColor(Color.BLACK);
		        g2d.fillRect ( getX() + cell*i, getY() + row*cell, cell, cell); 
		    } 
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mousePressed(MouseEvent event) {
		int x = event.getX(); int y = event.getY();
		rowSelected = x / cell;
		colSelected = y / cell;
		if (rowSelected >= 0 && rowSelected < row && colSelected >= 0 && colSelected < column){
			System.out.println("X: "+rowSelected+" | Y: "+colSelected);
		}
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub
	}
}