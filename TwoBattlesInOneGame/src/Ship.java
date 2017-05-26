
public abstract class Ship {

	private static int numberOfShips = 0;
	private int id;
	private int size;
	private int shootedPiece;
	private boolean sunk;

	public Ship() {

		id = ++numberOfShips;
		sunk = false;
		shootedPiece = 0;

	}

	public int getId() {

		return id;

	}

	public int getSize() {

		return size;

	}

	public void setSize(int newSize) {

		size = newSize;

	}

	public boolean isSunk() {

		return sunk;

	}

	private boolean checkSunk() {

		if(size == shootedPiece) sunk = true;
		return sunk;

	}

	public boolean shoot() {

		shootedPiece++;
		return checkSunk();

	}
	
}
