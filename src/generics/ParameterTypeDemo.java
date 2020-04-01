package generics;

import collections.Student;

/**
 * @author piyush.agarwal
 *
 */
public class ParameterTypeDemo {

	public static void main(String[] args) {
		Demo1<Integer> obj = new Demo1(new Integer(10));
		Integer object = obj.getObject();
		//Error since the type parameter is of type Integer and not String
//		obj.setObject("Ram");
		obj.display();
		
		Demo1<Student> obj1 = new Demo1(new Student(23, "Ranbeer", "Mumbai"));
//		Error Since the type parameter is of type Student
//		obj.setObject("Ram");
		obj1.display();
		
		runThread("Piyush Agarwal");
		runThread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello");
				
			}
		});
		Demo<CricketBall, Bouncable> obj2 = new Demo(new CricketBall());

		passValue(obj2);
	}
	
	public static void passValue(Demo1<? extends String> obj){
		obj.display();
		if(obj.getObject() instanceof String){
			String object = (String)obj.getObject();
		}
	}

	public static void passValue1(Demo1<? super Bouncable> obj){
		obj.display();
		if(obj.getObject() instanceof LeatherProperty)
			((LeatherProperty)obj.getObject()).showProperties();
		
	}

	public static void passValue(Demo<? extends LeatherProperty, Bouncable> obj){
		obj.display();
		if(obj.getObject() instanceof LeatherProperty)
			((LeatherProperty)obj.getObject()).showProperties();
		
	}

	/**
	 * Generic Method with type parameter T
	 * @param obj
	 */
	public static <T> void runThread(T obj){
		if(obj instanceof Runnable){
			((Runnable) obj).run();
		}else if(obj instanceof String){
			System.out.println("Its a string value:" + ((String)obj).substring(2));
		}
		System.out.println(obj);
	}
}


/**
 * Generic Class
 *
 * @param <T>
 * @param <E>
 */
class Demo<T, E>{
	T obj;
	
	Demo(T obj){
		this.obj = obj;
	}
	
	public void setObject(T obj){
		this.obj = obj;
	}
	
	public T getObject(){
		return obj;
	}
	
	public void display(){
		System.out.println(this.obj);
	}
}

class Demo1<T>{
	T obj;
	
	Demo1(T obj){
		this.obj = obj;
	}
	
	public void setObject(T obj){
		this.obj = obj;
	}
	
	public T getObject(){
		return obj;
	}
	
	public void display(){
		System.out.println(this.obj);
	}
	
}