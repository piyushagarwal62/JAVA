package use_of_static_instance;

public class StaticInstanceDemo {
	// This is Static block which gets called only once in lifetime for class.
	static {
		System.out.println("Inside Static block");
	}

	// This is Instance block which gets called everytime a new instance created
	// using new keyword
	{
		System.out.println("Inside Instance block");
	}

	int id;
	String name;
	float idf;

	public StaticInstanceDemo() {
		id = 0;
		name = "";
		System.out.println("In Default Constructor");
	}

	public StaticInstanceDemo(int id, String name) {
		this();
		this.id = id;
		this.name = name;
		System.out.println("In Parameterized Constructor");
	}

	public StaticInstanceDemo(long id, String name) {
		this();
		this.id = (int) id;
		this.name = name;
		System.out.println("In Parameterized Constructor : long");
	}

	public StaticInstanceDemo(double idf, String name) {
		this();
		this.idf = (float) idf;
		this.name = name;
		System.out.println("In Parameterized Constructor : double");
	}

	public StaticInstanceDemo(float idf, String name) {
		this();
		this.idf = idf;
		this.name = name;
		System.out.println("In Parameterized Constructor : float");
		System.gc();
		finalize();
	}

	public void finalize() {
		name = null;
		id = 0;
		idf = 0.0f;
		System.out.println("Inside Finalize ");
	}

	public static void main(String[] args) {
		StaticInstanceDemo obj = new StaticInstanceDemo();
		StaticInstanceDemo obj1 = new StaticInstanceDemo(2, "Piyush");
		StaticInstanceDemo obj2 = new StaticInstanceDemo(2.0f, "Piyush");
	}
}