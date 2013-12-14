import javax.swing.JFrame;
import javax.swing.UIManager;

class Game extends JFrame{
	
	public final int width = 655;
	public final int height = 675;
	Board board;

	public Game(){
		setSize(width, height);
		setTitle("Chess");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);
		
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e){
			System.out.print(e);
		}
		
		board = new Board();
		getContentPane().add(board);
	}
	
	public static void main(String[] args){
		
		Game g = new Game();
		g.setVisible(true);
	}
}