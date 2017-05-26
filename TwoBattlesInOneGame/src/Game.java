
public class Game {

	private Player playerOne;
	private Player playerTwo;
	
	public Game() {
		
		this.playerOne = new Player(1, "Player 1");
		this.playerTwo = new Player(2, "Player 2");
		playerTwo.setEnemy(playerOne);
		playerOne.setEnemy(playerTwo);
		
	}
	
	public void startPlayingGame() {
		
		//The flag that checks whether the player passed the starting point or not.
		boolean hasPassed = false;
		
		
		//This is for only testing.
		//Deploy the boards automatically so that we can test easily.
		//Will be replaced with the method `deployShips`

		BattleshipGame.autoDeployShips(this.playerOne);
		BattleshipGame.autoDeployShips(this.playerTwo);

		//TODO: Implement a function that checks if the game finished or not based on the sunk ship number.
		while( !BattleshipGame.isGameFinished(playerOne, playerTwo) ) {
			
			BoardGame.printBoard();
			hasPassed = BoardGame.play(playerOne);
			
			//If the player passes the starting point of the board, then call the battleship game.
			if(hasPassed) {
				
				BattleshipGame.play(this.playerOne);
				
			}
			
			hasPassed = false;
			
			BoardGame.printBoard();
			hasPassed = BoardGame.play(playerTwo);
			if(hasPassed) {
				
				BattleshipGame.play(this.playerTwo);
				
			}
				
			hasPassed = false;
			
		}
	
		
	}
		
	public Player getPlayerOne() {
		return playerOne;
	}
	
	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}
	
	public Player getPlayerTwo() {
		return playerTwo;
	}
	
	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

}
