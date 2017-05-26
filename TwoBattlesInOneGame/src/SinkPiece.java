import java.util.Random;

public class SinkPiece extends Card {
		
	public SinkPiece() {
		
		super.setCardName("SinkPiece");
		
	}
	
	public static void use(Player player) {
		
		System.out.println(player.getName() + " used SinkPiece Card");
		
		//Get the enemy board from the current player object.
		BattleshipBoard enemyBoard = player.getEnemy().getBoard();
				
		int randomXCoordinate, randomYCoordinate;
		
		do{
			
			randomXCoordinate = BattleshipGame.getRandomCoordinate();
			randomYCoordinate = BattleshipGame.getRandomCoordinate();
			
		}while(enemyBoard.checkPointIfShooted(randomXCoordinate, randomYCoordinate) && !enemyBoard.checkPointIfDeployed(randomXCoordinate, randomYCoordinate));
		
		int id = enemyBoard.shootPoint(randomXCoordinate, randomYCoordinate).getId();
		
		System.out.println(id + " piece was sunk!!!");
		
		BattleshipGame.printPlayerBoard(player.getEnemy());
		
	}

}