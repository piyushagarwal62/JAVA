package use_of_static_instance;

public class Player {

	int playerNo;
	String playerName;
	int playerScore;
	static int teamScore;
	
	public void updatePlayerInfo(int no, String name){
		playerNo = no;
		playerName = name;
		
	}
	
	public void updatePlayerScore(int runs){
		playerScore += runs;
		updateTeamScore(runs);
	}
	
	public static void updateTeamScore(int runs){
		teamScore += runs;
	}
		
	public void displayAllInfo(){
		System.out.println("Player No:" + playerNo);
		System.out.println("Player Name: " + playerName);
		System.out.println("Player Score:" + playerScore);
		System.out.println("Team Score:" + teamScore);
	}
	
	public static void main(String[] args) {
		Player obj1 = new Player();
		
		obj1.updatePlayerInfo(1,  "Virat");
		obj1.updatePlayerScore(6);
		obj1.updatePlayerScore(4);
		obj1.displayAllInfo();
		System.out.println();
		Player obj2 = new Player();
		obj2.updatePlayerInfo(2,  "Rohit");
		obj2.updatePlayerScore(4);
		obj2.updatePlayerScore(6);
		obj2.updatePlayerScore(3);
		obj2.displayAllInfo();
		Player.updateTeamScore(19);
		obj1.updateTeamScore(10);

	}

}
