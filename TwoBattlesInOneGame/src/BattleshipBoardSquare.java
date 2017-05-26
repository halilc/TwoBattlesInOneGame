
public class BattleshipBoardSquare {

	private Ship shipPointer;
	private boolean isShooted;
	
	public BattleshipBoardSquare(Ship shipPointer, boolean isShooted) {
		
		this.shipPointer = shipPointer;
		this.isShooted = isShooted;
		
	}
	
	public boolean shootShipPiece() {
		
		boolean isSunk = false;
		
		if(this.shipPointer != null) {
			isSunk = this.shipPointer.shoot();
		}
		
		return isSunk;
		
	}
	
	public Ship getShipPointer() {
		return shipPointer;
	}
	
	public void setShipPointer(Ship shipPointer) {
		this.shipPointer = shipPointer;
	}
	
	public boolean isShooted() {
		return isShooted;
	}
	
	public void setShooted(boolean isShooted) {
		this.isShooted = isShooted;
	}
	
	
	
}
