
public class BadLuck extends Card {
		
	//Can be deleted..
	public BadLuck() {
		
		super.setCardName("BadLuck");
		
	}
	
	//This is actually not need for now. However, we can replace it with GUI.
	public static void use(Player player) {
		
		System.out.println(player.getName() + " used BadLuck Card");
		
	}


}