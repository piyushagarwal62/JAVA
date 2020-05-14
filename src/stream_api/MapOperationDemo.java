package stream_api;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author piyush.agarwal
 *
 */
public class MapOperationDemo {

	public static void main(String[] args) {
		ArrayList<Double> arrList = new ArrayList<>();
		arrList.add(9.0);//3
		arrList.add(4.0);//2
		arrList.add(25.0);//5
		arrList.add(36.0);//6
		
		//Sqrt of all number 3 2 5 6
		//Product of all the sqrt 3*2*5*6
		double mult = 1;
		for (int i = 0; i < arrList.size(); i++) {
			double sqrt = Math.sqrt(arrList.get(i));
			mult = mult * sqrt;
		}
		System.out.println("Product of sqrt: " + mult);
		System.out.println("Origial List: " + arrList);

		Stream<Double> stream = arrList.stream().map(a -> Math.sqrt(a));
		Double productOfSqRoot = stream.reduce(1.0, (a, b) -> a * b);
		System.out.println("Product of sqrt:" + productOfSqRoot);

	}
}
