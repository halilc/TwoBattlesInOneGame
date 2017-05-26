
public class ExtraShoot extends Card {
		
	//Can be deleted..
	public ExtraShoot() {
		
		super.setCardName("ExtraShoot");
		
	}
	
	//When the user wants to use the ExtraShoot card.
	//He will have extra one shoot. However, if the player hits the ship in the first shoot, he actually does not have an extra shoot.
	//Since according the game rule, while the player is not missing the points, the player keep shooting.
	public static void use(Player player) {
		
		boolean isMissed;
		System.out.println(player.getName() + " used ExtraShoot Card");
			
		isMissed = BattleshipGame.shoot(player);
		if(isMissed) System.out.println("Miss!");
		else System.out.println("Hit!");
		
		do{
			
			isMissed = BattleshipGame.shoot(player);
			if(isMissed) System.out.println("Miss!");
			else System.out.println("Hit!");
			
		}while(!isMissed);
	
	}

}