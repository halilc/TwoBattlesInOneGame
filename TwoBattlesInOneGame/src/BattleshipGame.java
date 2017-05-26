import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleshipGame {
		
	public static void printPlayerBoard(Player player) {
		
		System.out.println(player.getName() + "'s Board");
		player.getBoard().printBoard();
		
	}	
	
	public static boolean isGameFinished(Player playerOne, Player playerTwo) 
	{
		return playerOne.getBoard().checkGameIfFinishes() || playerTwo.getBoard().checkGameIfFinishes();
	}
	
	public static void printCards(Player player) {
				
		PlayerCardDeck playerCardDeck = player.getPlayerCardDeck();
		System.out.println("You have the following cards: ");
		//Will be replaced with the GUI
		System.out.println(playerCardDeck.getNumberOfSinkPieceCards() + "x SinkPiece Card");
		System.out.println(playerCardDeck.getNumberOfExtraShootCards() + "x ExtraShoot Card");
		System.out.println(playerCardDeck.getNumberOfAirstrikeCards() + "x Airstrike Card");
		System.out.println(playerCardDeck.getNumberOfBadLuckCards() + "x BadLuck Card");
		
	}
	
	//This will use only for the auto deployment.
	public static char getRandomDirection() 
	{
		char directions[] = {'v', 'h', 'u', 'd'};
		Random rand = new Random();
		return directions[rand.nextInt(4)];			
		
	}
	
	//This will use only for the auto deployment.
	public static int getRandomCoordinate()
	{
		Random rand = new Random();
		return rand.nextInt(10);	
	}
	
	public static void autoDeployShips(Player player) {

		int i;
		int row, col;
		char direction;
		
		BattleshipBoard board = player.getBoard();
				
		for(i=0;i<Carrier.totalShipNumber;i++) {

			Ship carrier = makeNewShip(1);
			
			do{
				
				row = getRandomCoordinate();
				col = getRandomCoordinate();
				direction = getRandomDirection();
				
			}while( board.checkPointsIfDeployable(carrier, row, col, direction) );
			
			board.deployShip(carrier, row, col, direction);

		}
		
		for(i=0;i<Battleship.totalShipNumber;i++) {

			Ship battleship = makeNewShip(2);
			
			do{
				
				row = getRandomCoordinate();
				col = getRandomCoordinate();
				direction = getRandomDirection();
				
			}while( board.checkPointsIfDeployable(battleship, row, col, direction) );
			
			board.deployShip(battleship, row, col, direction);

		}

		for(i=0;i<Cruiser.totalShipNumber;i++) {

			Ship cruiser = makeNewShip(3);

			do{
				
				row = getRandomCoordinate();
				col = getRandomCoordinate();
				direction = getRandomDirection();
				
			}while( board.checkPointsIfDeployable(cruiser, row, col, direction) );
			
			board.deployShip(cruiser, row, col, direction);

		}

		for(i=0;i<Submarine.totalShipNumber;i++) {

			Ship submarine = makeNewShip(4);

			do{
				
				row = getRandomCoordinate();
				col = getRandomCoordinate();
				direction = getRandomDirection();
				
			}while( board.checkPointsIfDeployable(submarine, row, col, direction) );
			
			board.deployShip(submarine, row, col, direction);

		}

		for(i=0;i<Patrolboat.totalShipNumber;i++) {

			Ship patrolBoat = makeNewShip(5);

			do{
				
				row = getRandomCoordinate();
				col = getRandomCoordinate();
				direction = getRandomDirection();
				
			}while( board.checkPointsIfDeployable(patrolBoat, row, col, direction) );
			
			board.deployShip(patrolBoat, row, col, direction);

		}

		printPlayerBoard(player);
		
	}
	
	public void deployShips(Player player) {

		Scanner sc = new Scanner(System.in);
		int i;
		int row, col;
		char direction;
		BattleshipBoard board = player.getBoard();
		
		for(i=0;i<Carrier.totalShipNumber;i++) {

			Ship carrier = makeNewShip(1);

			do{
				
				row = sc.nextInt();
				col = sc.nextInt();
				direction = sc.next().charAt(0);
					
			}while( board.checkPointsIfDeployable(carrier, row, col, direction) );
			
			board.deployShip(carrier, row, col, direction);

		}
		
		for(i=0;i<Battleship.totalShipNumber;i++) {

			Ship battleship = makeNewShip(2);
			
			do{
				
				row = sc.nextInt();
				col = sc.nextInt();
				direction = sc.next().charAt(0);
				
			}while( board.checkPointsIfDeployable(battleship, row, col, direction) );
			
			board.deployShip(battleship, row, col, direction);

		}

		for(i=0;i<Cruiser.totalShipNumber;i++) {

			Ship cruiser = makeNewShip(3);
			
			do{
				row = sc.nextInt();
				col = sc.nextInt();
				direction = sc.next().charAt(0);
			}while( board.checkPointsIfDeployable(cruiser, row, col, direction) );
			
			board.deployShip(cruiser, row, col, direction);

		}

		for(i=0;i<Submarine.totalShipNumber;i++) {

			Ship submarine = makeNewShip(4);
			
			do{
				row = sc.nextInt();
				col = sc.nextInt();
				direction = sc.next().charAt(0);
			}while( board.checkPointsIfDeployable(submarine, row, col, direction) );
			
			board.deployShip(submarine, row, col, direction);

		}

		for(i=0;i<Patrolboat.totalShipNumber;i++) {

			Ship patrolBoat = makeNewShip(5);
			
			do{
				row = sc.nextInt();
				col = sc.nextInt();
				direction = sc.next().charAt(0);
			}while( board.checkPointsIfDeployable(patrolBoat, row, col, direction) );
			
			board.deployShip(patrolBoat, row, col, direction);

		}
		
	}
	
	public static void play(Player player) {
		
		int choice;
		boolean isMissed;
		
		//Force the player to use the BadLuck card
		if(player.getPlayerCardDeck().getNumberOfBadLuckCards() > 0) {
			
			System.out.println("Unlucky!!! You have BadLuck card so you will skip this round :(");
			player.getPlayerCardDeck().useCard(player, 3);
			return;
			
		}
		
		
		printCards(player);
		System.out.print("Do you want to use or shoot? 1-USE 2-CONT: ");
		
		Scanner sc = new Scanner(System.in);
		
		choice = sc.nextInt();
		
		if(choice == 1){
			
			System.out.print("Which one do you want to use: ");
			choice = sc.nextInt();
			
			useCard(player, choice);
			
		}else{
			
			do{
			
				isMissed = shoot(player);
				if(isMissed) System.out.println("Miss!");
				else System.out.println("Hit!");
				
			}while(!isMissed);
			
		}
		
	}
	
	public static void useCard(Player player, int cardType) {
		
		PlayerCardDeck playerCardDeck = player.getPlayerCardDeck();
								
		playerCardDeck.useCard(player, cardType);
		
	}
	 
	public static boolean shoot(Player player) {
		
		BattleshipBoard enemyBoard = player.getEnemy().getBoard();
		int row, col;
		boolean isShootable;
		
		Scanner sc = new Scanner(System.in);
		
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
				
		Ship shootedPiece = enemyBoard.shootPoint(row, col);
		
		printPlayerBoard(player.getEnemy());
		
		if(shootedPiece == null) {
			
			return true;
			
		}else{
			
			return false;
			
		}
		
		
	}

	public static Ship makeNewShip(int type) {
		
		switch(type) {
		
			case 1:
				return new Carrier();
				
			case 2:
				return new Battleship();
				
			case 3:
				return new Cruiser();
				
			case 4:
				return new Submarine();
				
			case 5:
				return new Patrolboat();
				
		}
		
		return null;
		
	}
	
}
