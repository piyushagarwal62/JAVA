package inheritance;

public interface Bouncable {

	int bounceHeight = 10;
	
	void bounce(int height);
	
	default boolean isBoucable(){
		return true;
	}
	
	static void showProperties(){
		System.out.println("Object having Bouncable properties");
	}
	
}

interface BallBouncable extends Bouncable{
	void bounce(int height);
}

class LeatherProperty{
	void showProperties(){
		System.out.println("Its made of leather");
	}
}

class CricketBall extends LeatherProperty implements Bouncable, BallBouncable{

	@Override
	public void bounce(int height) {
		// TODO Auto-generated method stub
		System.out.println("Bounce Height: " + bounceHeight + Bouncable.bounceHeight);
		
	}
	
	public static void main(String[] args) {
		CricketBall obj = new CricketBall();
		Bouncable.showProperties();
		obj.isBoucable();
		obj.bounce(5);
		obj.functionalInterface();
	}
	
	public void functionalInterface(){
		//lambda expression
		Bouncable obj = (int height)->System.out.println("Its Bouncable with height" + height);
		
		Bouncable obj1 = (height)->{
			System.out.println("Its Bouncable with height" + height);
			int vol = 3 * height;
			System.out.println(vol);
		};

		obj.bounce(5);
		obj1.bounce(4);
	}
	
}