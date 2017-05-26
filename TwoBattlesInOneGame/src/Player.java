import java.util.ArrayList;
import java.util.List;

public class Player {

	private int id;
	private String name;
	private BattleshipBoard board;
	private PlayerCardDeck playerCardDeck;
	private Player enemy;
	
	public Player(int id, String name) {
		
		this.id = id;
		this.name = name;
		this.board = new BattleshipBoard();
		this.playerCardDeck = new PlayerCardDeck();
		this.enemy = null;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public BattleshipBoard getBoard() {
		return board;
	}

	public void setBoard(BattleshipBoard board) {
		this.board = board;
	}

	public PlayerCardDeck getPlayerCardDeck() {
		return playerCardDeck;
	}

	public void setPlayerCardDeck(PlayerCardDeck playerCardDeck) {
		this.playerCardDeck = playerCardDeck;
	}

	public void addCard(int cardType) {
		this.playerCardDeck.addCard(cardType);
	}
		
	public Player getEnemy() {
		return enemy;
	}

	public void setEnemy(Player enemy) {
		this.enemy = enemy;
	}

}
