import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BoardGame {
	
	public static int playerOneCurrentLocation = 0;
	public static int playerTwoCurrentLocation = 0;
	public static List<BoardSquare> board = new ArrayList<BoardSquare>() {
	    {
	        add(new BoardSquare());
	        add(new BoardSquare());
	        add(new BoardSquare());
	        add(new BoardSquare());
	        add(new BoardSquare());
	        add(new BoardSquare());
	        add(new BoardSquare());
	        add(new BoardSquare());
	        add(new BoardSquare());
	        add(new BoardSquare());
	        add(new BoardSquare());
	        add(new BoardSquare());
	        add(new BoardSquare());
	        add(new BoardSquare());
	    }
	};
	
	public static boolean play(Player player) {
		
		int[] dices = new int[2];
		boolean hasCard = false;
		Card card;
		int newLocation = 0;
		
		dices[0] = rollDice();
		dices[1] = rollDice();
		
		int choice;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print(player.getName() + ", please select one of them: 1: " + dices[0] + " 2: " + dices[1] + ": " );
		choice = sc.nextInt();
				
		//No need to check if the user enters 1 or 2 for now! since GUI will not allow the player to enter different number.
		choice -= 1;
			
		if(player.getId() == 1) {

			board.get(playerOneCurrentLocation).setPlayerOne(false);
			newLocation = playerOneCurrentLocation + dices[choice];
			hasCard = board.get(playerOneCurrentLocation = newLocation % 14).setPlayerOne(true);

		}else if(player.getId() == 2) {
			
			board.get(playerTwoCurrentLocation).setPlayerTwo(false);
			newLocation = playerTwoCurrentLocation + dices[choice];
			hasCard = board.get(playerTwoCurrentLocation = newLocation % 14).setPlayerTwo(true);
					
		}
		
		if(hasCard) {
			
			int cardType = getCard(player);
			System.out.println("You got " + cardType + " card!");
			
		}
		
		if(newLocation >= BoardSquare.numberOfSquare) return true;
		else return false;
			
	}

	
	public static void printBoard() {
		
		//replace it with the GUI
		System.out.println("Board:");
		for(int i=0; i<BoardSquare.numberOfSquare; i++) {
			
			System.out.print(String.format("%4s",  (i+1) + ":"));
			if(BoardGame.board.get(i).isPlayerOne()) System.out.print(" P1"); 
			if(BoardGame.board.get(i).isPlayerTwo()) System.out.print(" P2");
			if(BoardGame.board.get(i).isHasCard()) System.out.print(" C");			
			System.out.println("");
			
		}
			
		
	}
	
	public static int rollDice() {
		
		Random rand = new Random();
		return rand.nextInt(6) + 1;
		
	}	

	public static int getCard(Player player) {
		
		int cardType = makeNewCard();
		player.addCard(cardType);
		return cardType;
		
	}
	
	public static int makeNewCard() {
		
		Random rand = new Random();
		int randomCard = rand.nextInt(10) + 1;
		
		if(randomCard == 1){
			
			return 3;
				
		}else if(randomCard == 2 || randomCard == 3) {
			
			return 2;
			
		}else if(randomCard == 4 || randomCard == 5 || randomCard == 6) {
			
			return 1;
			
		}else if(randomCard == 7 || randomCard == 8 || randomCard == 9 || randomCard == 10) {
			
			return 0;
			
		}
		
		return 0;
		
	}
	
	
}
