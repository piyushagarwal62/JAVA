package inheritance;

interface Bouncable {

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

public class CricketBall extends LeatherProperty implements Bouncable, BallBouncable{
	
	Bouncable bb = new Bouncable() {
		
		@Override
		public void bounce(int height) {
			System.out.println("Its in cricket ball Bouncable property with height: " + height);
			
		}
	};
	
	@Override
	public void bounce(int height) {
		System.out.println("Bounce Height: " + bounceHeight);
		
	}
	
	public static void main(String[] args) {
		CricketBall obj = new CricketBall();
		Bouncable.showProperties();
		obj.isBoucable();
		obj.bounce(5);
		obj.functionalInterface();
		obj.annonymousClass();
		obj.annonymousClass1();
		
	}
	
	public void functionalInterface(){
		//lambda expression
		Bouncable obj = (int height)->System.out.println("Its Bouncable with height" + height);
		
		Bouncable obj1 = (height)->{
			System.out.println("Its Bouncable with height: " + height);
			int vol = 3 * height;
			System.out.println(vol);
		};

		obj.bounce(5);
		obj1.bounce(4);
		bb.bounce(5);
	}
	
	public void annonymousClass(){
		//Creating annonymous class with unnamed inherited class from interface Bouncable
		Bouncable obj = new Bouncable(){
			int i = 10;
			
			public void bounce(int height){
				i =20;
				System.out.println("In annonymous inner class");
				newMethod(i);
			}
			
			private void newMethod(int num){
				System.out.println("INside new method:" + num);
			}
		};
		obj.bounce(6);
		bb = obj;
	}
	
	public void annonymousClass1(){
		//Creating annonymous class with unnamed inherited class of LeatherProperty
		LeatherProperty obj = new LeatherProperty(){
			public void showProperties(){
				System.out.println("IN Annonymouse Show properties");
			}
		};
		obj.showProperties();
	}
}