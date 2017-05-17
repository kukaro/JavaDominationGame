import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StageFrame {

	private JFrame frame;
	private Packman packman1;
	private Packman packman2;
	private Cell[][] cellArr;
	private ImageIcon it;
	public static int CELL_COUNT = 15;
	public static int CELL_SIZE = 60;

	/**
	 * Launch the application.
	 */
	{
		it = new ImageIcon("close.png");
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StageFrame window = new StageFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Initialize Block
	 */
	{
		cellArr = new Cell[CELL_COUNT][CELL_COUNT];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				cellArr[i][j] = new Cell(i * 60, j * 60);
			}
		}
		new MapLoader("MapSet.txt", cellArr);
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				System.out.print(cellArr[i][j].getState() + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Create the application.
	 */
	public StageFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		packman1 = new Packman(0, 0, new ImageIcon("pica.jpg"));
		packman2 = new Packman(14 * CELL_SIZE, 14 * CELL_SIZE, new ImageIcon("righ.png"));
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (!(cellArr[packman1.getPosX() / CELL_SIZE][(packman1.getPosY() - CELL_SIZE) / CELL_SIZE]
							.getState() == Cell.TREASURE))
						packman1.setPosY(packman1.getPosY() - CELL_SIZE);
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (!(cellArr[packman1.getPosX() / CELL_SIZE][(packman1.getPosY() + CELL_SIZE) / CELL_SIZE]
							.getState() == Cell.TREASURE))
						packman1.setPosY(packman1.getPosY() + CELL_SIZE);
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (!(cellArr[(packman1.getPosX() - CELL_SIZE) / CELL_SIZE][packman1.getPosY() / CELL_SIZE]
							.getState() == Cell.TREASURE))
						packman1.setPosX(packman1.getPosX() - CELL_SIZE);
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (!(cellArr[(packman1.getPosX() + CELL_SIZE)/ CELL_SIZE][packman1.getPosY()/ CELL_SIZE]
							.getState() == Cell.TREASURE))
					packman1.setPosX(packman1.getPosX() + CELL_SIZE);
				}
				if (e.getKeyCode() == KeyEvent.VK_W) {
					if (!(cellArr[packman2.getPosX() / CELL_SIZE][(packman2.getPosY() - CELL_SIZE) / CELL_SIZE]
							.getState() == Cell.TREASURE))
					packman2.setPosY(packman2.getPosY() - CELL_SIZE);
				} else if (e.getKeyCode() == KeyEvent.VK_S) {
					if (!(cellArr[packman2.getPosX() / CELL_SIZE][(packman2.getPosY() + CELL_SIZE) / CELL_SIZE]
							.getState() == Cell.TREASURE))
					packman2.setPosY(packman2.getPosY() + CELL_SIZE);
				} else if (e.getKeyCode() == KeyEvent.VK_A) {
					if (!(cellArr[(packman2.getPosX() - CELL_SIZE) / CELL_SIZE][packman2.getPosY() / CELL_SIZE]
							.getState() == Cell.TREASURE))
					packman2.setPosX(packman2.getPosX() - CELL_SIZE);
				} else if (e.getKeyCode() == KeyEvent.VK_D) {
					if (!(cellArr[(packman2.getPosX() + CELL_SIZE)/ CELL_SIZE][packman2.getPosY()/ CELL_SIZE]
							.getState() == Cell.TREASURE))
					packman2.setPosX(packman2.getPosX() + CELL_SIZE);
				}
				frame.repaint();
			}
		});
		frame.setContentPane(new JPanel() {

			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				for (int i = 0; i < 15; i++) {
					for (int j = 0; j < 15; j++) {
						if (cellArr[i][j].enter(packman1.getCenterX(), packman1.getCenterY())) {
							cellArr[i][j].setState(Cell.PLAYER1);
						}
						if (cellArr[i][j].enter(packman2.getCenterX(), packman2.getCenterY())) {
							cellArr[i][j].setState(Cell.PLAYER2);
						}
						if (cellArr[i][j].getState() == Cell.PLAYER1) {
							g.setColor(Color.RED);
							g.fillRect(cellArr[i][j].getPosX(), cellArr[i][j].getPosY(), CELL_SIZE, CELL_SIZE);
						}
						if (cellArr[i][j].getState() == Cell.PLAYER2) {
							g.setColor(Color.BLUE);
							g.fillRect(cellArr[i][j].getPosX(), cellArr[i][j].getPosY(), CELL_SIZE, CELL_SIZE);
						}
						if (cellArr[i][j].getState() == Cell.TREASURE) {
							g.drawImage(it.getImage(), cellArr[i][j].getPosX(), cellArr[i][j].getPosY(), CELL_SIZE,
									CELL_SIZE, this);
						}
					}
				}
				g.drawImage(packman1.getImage(), packman1.getPosX(), packman1.getPosY(), CELL_SIZE, CELL_SIZE, this);
				g.drawImage(packman2.getImage(), packman2.getPosX(), packman2.getPosY(), CELL_SIZE, CELL_SIZE, this);
			}
		});
	}

}
