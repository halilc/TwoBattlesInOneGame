import java.util.Scanner;

public class Airstrike extends Card {

	//Can be deleted..
	public Airstrike() {
		
		super.setCardName("Airstrike");
		
	}

	//When the player uses the Airstrike Card.
	public static void use(Player player) {
		
		System.out.println(player.getName() + " used Airstrike Card");
		
		boolean isShootable;
		int row, col;
		Scanner sc = new Scanner(System.in);
		
		//Get the enemy board from the current player object.
		BattleshipBoard enemyBoard = player.getEnemy().getBoard();
		
		//This may not need to be used in GUI.
		//Since we cannot click the shooted squares or out of the board.
		do{
			
			//Get the x coordinate from the current player.
			System.out.println("Please enter x coordinate: ");
			row = sc.nextInt();
			
			//Get the y coordinate from the current player.
			System.out.println("Please enter y coordinate: ");
			col = sc.nextInt();
				
			isShootable = true;
			if(!enemyBoard.checkPointIfOutOfRange(row, col))
				if(enemyBoard.checkPointIfShooted(row, col)) isShootable = false;
			
		//Basically checks the point if it is already shooted or the point is out of the range.
		}while(isShootable);

		//Check the points whether they are out of range or not since the player can shoot the point which is on the corner or sides.
		//If it is not, then shoot the point.
		//There is no need to check every point if they are already shooted.
		//We need to check only the entered point which is x and y.
		//Also, no need to be use with GUI.
		if(!enemyBoard.checkPointIfOutOfRange(row-1, col-1)) enemyBoard.shootPoint(row-1, col-1);
		if(!enemyBoard.checkPointIfOutOfRange(row-1, col)) enemyBoard.shootPoint(row-1, col);
		if(!enemyBoard.checkPointIfOutOfRange(row-1, col+1)) enemyBoard.shootPoint(row-1, col+1);
		if(!enemyBoard.checkPointIfOutOfRange(row, col-1)) enemyBoard.shootPoint(row, col-1);
		if(!enemyBoard.checkPointIfOutOfRange(row, col)) enemyBoard.shootPoint(row, col);
		if(!enemyBoard.checkPointIfOutOfRange(row, col+1)) enemyBoard.shootPoint(row, col+1);
		if(!enemyBoard.checkPointIfOutOfRange(row+1, col-1)) enemyBoard.shootPoint(row+1, col-1);
		if(!enemyBoard.checkPointIfOutOfRange(row+1, col)) enemyBoard.shootPoint(row+1, col);
		if(!enemyBoard.checkPointIfOutOfRange(row+1, col+1)) enemyBoard.shootPoint(row+1, col+1);
		
		BattleshipGame.printPlayerBoard(player.getEnemy());
		
	}

}