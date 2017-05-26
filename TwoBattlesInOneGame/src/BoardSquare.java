import java.util.Random;

public class BoardSquare {

	private boolean playerOne;
	private boolean playerTwo;
	private boolean hasCard;
	
	private static int numberOfCardInDeck = 4;
	private static int counter = 0;
	public static int numberOfSquare = 14;
	
	public BoardSquare() {
		
		if(BoardSquare.counter == 0) {
			
			//In the beginning of the game, the players sit on the starting point.
			this.playerOne = true;
			this.playerTwo = true;
			
		}else{
			
			this.playerOne = false;
			this.playerTwo = false;
			
			//This part is in the else since we cannot have a card in the starting point otherwise, it can confuse us!
			
			//If the allocated card number is not sufficient, then allocate cards to rest of the board.			
			if(BoardSquare.numberOfSquare - BoardSquare.counter == BoardSquare.numberOfCardInDeck) {
				
				this.hasCard = true;
				BoardSquare.numberOfCardInDeck--;
				
			}else if(BoardSquare.numberOfCardInDeck > 0){
				
				//Select randomly if the square has card or not.
				Random rand = new Random();
				if(rand.nextBoolean()){
					
					this.hasCard = true;
					BoardSquare.numberOfCardInDeck--;
					
				}else{
					
					this.hasCard = false;
					
				}
				
			}

		}
		
		//Increment the counter so that we can understand how many board square are created so far.
		BoardSquare.counter++;
		
	}	
	
	public boolean isPlayerOne() {
		return playerOne;
	}

	public boolean setPlayerOne(boolean playerOne) {
		this.playerOne = playerOne;
		return this.hasCard;
	}

	public boolean isPlayerTwo() {
		return playerTwo;
	}

	public boolean setPlayerTwo(boolean playerTwo) {
		this.playerTwo = playerTwo;
		return this.hasCard;
	}

	public boolean isHasCard() {
		return hasCard;
	}

	public void setHasCard(boolean hasCard) {
		this.hasCard = hasCard;
	}
	
}
