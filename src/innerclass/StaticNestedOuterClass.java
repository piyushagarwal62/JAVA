package innerclass;

public class StaticNestedOuterClass{

	public static void main(String[] args) {
		OuterClass obj  = new OuterClass();
		obj.test();
		OuterClass.InnerClass obj1  = new OuterClass.InnerClass() ;
		obj1.fun();
		OuterClass.test1();
		System.out.println("Value of c" + OuterClass.InnerClass.c);		//Not possible
	}

}

class OuterClass{
	int a = 12;
	static int b = 14;

	public void gun(){

		System.out.println("Inside Outers Gun");
		System.out.println("Value of a" + a);
	}

	public void test(){

		InnerClass obj = new InnerClass();
		obj.fun();
		System.out.println("Value of c" + InnerClass.c);
	}

	public static void test1(){
		InnerClass obj = new InnerClass();	//Not possible
		obj.fun();
		OuterClass.InnerClass obj1  = new OuterClass.InnerClass() ;
		
	}

	static class InnerClass{
		int b = 20;
		public static int c = 23;

		public void newMethod(){
			OuterClass obj = new OuterClass();
			
			System.out.println(obj.a);
			System.out.println(c);
			System.out.println(b);
			System.out.println(OuterClass.b);
			test1();
			obj.test();
		}
		
		
		public void fun(){
			System.out.println("Inside Inners Fun");
			System.out.println("Value of b " + b);
			System.out.println("Value of OuterClass.b " + OuterClass.b);
			OuterClass obj = new OuterClass();
			System.out.println("Value of a " + obj.a);
			// System.out.println("Value of a " + OuterClass.this.a);  // Will work in inner class(Non Static)
			System.out.println("Value of b " + this.b);
//			System.out.println("Value of c " + this.c);
		} 
	}
}