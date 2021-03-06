/**
 * 
 */
package client.model;

/**
 * @author quangvu
 *
 */
public class Board {
	
	public static int COL_COUNT = 4;
	public static int ROW_COUNT = 4;
	
	/**
	 * Array of cells
	 */
	protected Cell cells[][] = new Cell[ROW_COUNT][COL_COUNT];
	
	/**
	 * Initialize the board
	 * 
	 * Assuming the letters come in col then row
	 * 
	 * @param letters the letters to fill the board with
	 */
	public Board(String letters[][]) {
		int mul = 0;
		for (int i = 0; i < COL_COUNT; i++) {
			for (int j = 0; j < ROW_COUNT; j++) {
				Cell c   = new Cell(new Position(i,j));
				c.letter = letters[i][j];
				c.point  = 1;
				c.multiplier = mul;
				mul++;
				
				cells[i][j] = c;
			}
		}
	}
	
	public Cell getCell(Position p) {
		if (p != null) {
			return cells[p.col][p.row];
		}
		return null;
	}
	
	public void cancel() {
		for(Cell[] i: cells){
			for(Cell j: i){
				j.selected = false;
				j.added = false;
			}
		}
	}
	
	Board active = null;
	public Board  getActive(){
		return active;
	}

}
