import java.util.ArrayList;
import java.util.List;

public class PlayerCardDeck {

	private int numberOfCards[];
	
	public PlayerCardDeck() {
		
		this.numberOfCards = new int[4];
		this.numberOfCards[0] = 0;
		this.numberOfCards[1] = 0;
		this.numberOfCards[2] = 0;
		this.numberOfCards[3] = 0;
		
	}

	public int getNumberOfSinkPieceCards() {
		return this.numberOfCards[0];
	}
	
	public int getNumberOfExtraShootCards() {
		return this.numberOfCards[1];
	}
	
	public int getNumberOfAirstrikeCards() {
		return this.numberOfCards[2];
	}
	
	public int getNumberOfBadLuckCards() {
		return this.numberOfCards[3];
	}
	
	public int addCard(int cardType) {
		return ++this.numberOfCards[cardType];		
	}
	
	public int deleteCard(int cardType) {
		return --this.numberOfCards[cardType];		
	}
	
	public void useCard(Player player, int cardType)
	{
		
		this.deleteCard(cardType);
		
		switch(cardType) {
		
			case 0:
				
				SinkPiece.use(player);
				
				break;
			
			case 1:
				
				ExtraShoot.use(player);
				
				break;
			
			case 2:
				
				Airstrike.use(player);
			
				break;
				
			case 3:
				
				BadLuck.use(player);
				
				break;
				
		}
		
	}
	
}
