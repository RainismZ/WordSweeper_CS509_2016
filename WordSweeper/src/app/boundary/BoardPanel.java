package app.boundary;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import app.entity.Board;
import app.entity.Cell;
import app.entity.Position;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

public class BoardPanel extends JPanel {

	public static int COL_COUNT = 4;
	public static int ROW_COUNT = 4;
	public static int CELL_SIZE = 50;

	CellPanel cellPanels[][] = new CellPanel[ROW_COUNT][COL_COUNT];

	final Board board;

	/**
	 * Create the panel and bound to a Board.
	 */
	public BoardPanel(Board board) {
		this.board = board;

		setup();
	}

	/**
	 * Initialize the board panel
	 */
	void setup() {
		setLayout(null);
		setBorder(BorderFactory.createEmptyBorder());
		setPreferredSize(new Dimension(ROW_COUNT * CELL_SIZE, COL_COUNT * CELL_SIZE));

		for (int x = 0; x < COL_COUNT; x++) {
			for (int y = 0; y < ROW_COUNT; y++) {
				Cell cell = board.getCell(new Position(x, y));
				CellPanel c = new CellPanel(cell);

				c.setBounds(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);

				add(c);
				cellPanels[x][y] = c;
			}
		}
	}

	/**
	 * Teardown the board panel
	 */
	void teardown() {

	}

	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;

		for (int x = 0; x < COL_COUNT; x++) {
			for (int y = 0; y < ROW_COUNT; y++) {
				cellPanels[x][y].repaint();
			}
		}
	}

	/**
	 * Private cell panel class
	 */
	private class CellPanel extends JPanel {
		final Cell cell;

		public CellPanel(Cell cell) {
			this.cell = cell;
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;

			int h = getHeight();
			int w = getWidth();

			g2.setColor(new Color(0, 255, 0, 15 * cell.multiplier));
			g2.fillRect(0, 0, w, h);
			
			g2.setColor(Color.BLACK);
			g2.drawRect(0, 0, w, h);			
			g2.drawString(String.valueOf(cell.letter), w / 2 - 3, h / 2 + 5);
			g2.drawString(String.valueOf(cell.point), w / 2 + 13, h / 2 - 10);
			g2.drawString('x' + String.valueOf(cell.multiplier), w / 2 + 8, h / 2 + 20);			
		}
	}

}