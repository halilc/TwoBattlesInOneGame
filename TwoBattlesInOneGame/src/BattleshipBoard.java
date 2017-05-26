import java.util.ArrayList;
import java.util.List;

public class BattleshipBoard {

	//This list stores the 10*10 board square classes which hold ship pointers.
	private List<List<BattleshipBoardSquare>> board;
	
	private int totalShips;
	private int totalSunkShips;
	
	//Initialize the board with null so that we can distinguish if the square has ship or not.
	private void initializeBoard() {		
		
		this.board = new ArrayList<List<BattleshipBoardSquare>>();
		for(int i=0; i<10; i++){

			this.board.add(new ArrayList<BattleshipBoardSquare>());
			List<BattleshipBoardSquare> boardRow = this.board.get(i);
		
			for(int c=0; c<10; c++) {
				boardRow.add(new BattleshipBoardSquare(null, false));
			}
		}				
	}
		
	//Override the default constructor.
	public BattleshipBoard() {
		
		this.totalShips = Cruiser.totalShipNumber + Carrier.totalShipNumber + Battleship.totalShipNumber + Submarine.totalShipNumber + Patrolboat.totalShipNumber;
		this.totalSunkShips = 0;
		this.initializeBoard();
		
	}
		
	public List<List<BattleshipBoardSquare>> getBoard() {
		return board;
	}

	public void setBoard(List<List<BattleshipBoardSquare>> board) {
		this.board = board;
	}
	
	public boolean checkGameIfFinishes() {
		
		return this.totalShips == this.totalSunkShips;
		
	}
	
	public void deployShip(Ship ship, int row, int col, char direction) {
		
		switch(direction) {

			case 'v':

				for(int i = 0; i < ship.getSize(); i++) this.board.get(row + i).get(col).setShipPointer(ship);
				
				break;

			case 'h':

				for(int j = 0; j < ship.getSize(); j++) this.board.get(row).get(col + j).setShipPointer(ship);
			
				break;
			
			case 'u':
				
				for(int j = 0; j < ship.getSize(); j++)this.board.get(row + j).get(col + j).setShipPointer(ship);
				
				break;
			
			case 'd':
				
				for(int j = 0; j < ship.getSize(); j++) this.board.get(row - j).get(col - j).setShipPointer(ship);
					
				break;

		}
		
	}
	
	public Ship shootPoint(int row, int col) {
		
		//Check if the player sunk the ship, then increment the sunk ship total
		if(this.board.get(row).get(col).shootShipPiece()) {
			System.out.println("You sunk the enemy's ship!");
			this.totalSunkShips++;
		}
		this.board.get(row).get(col).setShooted(true);
		return this.board.get(row).get(col).getShipPointer();
	
	}
	
	//Check the given point, if it is out of the board or not.
	//This is not need when we use GUI since we do not show the points which are out of the board.
	public boolean checkPointIfOutOfRange(int row, int col) 
	{
		if(row >= 10 || row < 0 || col >= 10 || col < 0) return true;			
		return false;
	}
	
	//Check the point if it is already shooted. This will be usually used while shooting the point.
	//This is also not need when we use GUI since we can disable click if the point is already shooted.
	//However, we can still use while displaying the board in the GUI...
	public boolean checkPointIfShooted(int row, int col) {	
		
		if(this.board.get(row).get(col).isShooted() == false) return true;
		return false;
		
	}
	
	//////////////////////////////////////
	public boolean checkPointIfDeployed(int row, int col) {	
		
		if(this.board.get(row).get(col).getShipPointer() != null) return true;
		return false;
		
	}
	
	public boolean checkPointsIfDeployable(Ship ship, int row, int col, char direction) {
		
		switch(direction) {

			case 'v':
	
				for(int i = 0; i < ship.getSize(); i++) {
					
					if(!checkPointIfOutOfRange(row + i, col)) {
						if( checkPointIfDeployed(row + i, col) )
							return true;
					}else return true;				   		
			        	
				}	
				
			break;
	
			case 'h':
	
				for(int j = 0; j < ship.getSize(); j++) {
					
					if(!checkPointIfOutOfRange(row, col + j)) {
						if(checkPointIfDeployed(row, col + j))
							return true;							
					}else return true;
				}
	
			break;
			
			case 'u':
				
				for(int j = 0; j < ship.getSize(); j++) {
					
					if(!checkPointIfOutOfRange(row + j, col + j)) {
						if(checkPointIfDeployed(row + j, col + j))
							return true;
					}else return true;
					
				}
				
			break;
			
			case 'd':
				
				for(int j = 0; j < ship.getSize(); j++) {
					
					if(!checkPointIfOutOfRange(row - j, col - j)) {
						if(checkPointIfDeployed(row - j, col - j))
							return true;
					}else return true;
					
				}
				
			break;
	
		}
		
		return false;
		
	}
	
	public void printBoard() {
		
		for(int i=0; i<10; i++){

			for(int c=0; c<10; c++) {
				
				if(!this.board.get(i).get(c).isShooted()) {
					
					if(this.board.get(i).get(c).getShipPointer() != null) {
						
						System.out.print(String.format("%3d", this.board.get(i).get(c).getShipPointer().getId()));
						
					}else {
						
						System.out.print(String.format("%3d", 0));
						
					}
					
				}else {
					
					System.out.print(String.format("%3s", "X"));
					
				}
					
			}
			
			System.out.println("");

		}
				
	}
		
}
