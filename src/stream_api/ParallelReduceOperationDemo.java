package stream_api;
import java.util.ArrayList;

/**
 * @author piyush.agarwal
 *
 */
public class ParallelReduceOperationDemo {

	public static void main(String[] args) {
		ArrayList<Double> arrList = new ArrayList<>();
		arrList.add(9.0);
		arrList.add(4.0);
		arrList.add(25.0);
		arrList.add(36.0);

		System.out.println("Origial List: " + arrList);

		Double productOfSqrtOFF = arrList.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b), (a, b) -> a * b);
		System.out.println("Product of square root:" + productOfSqrtOFF);

		productOfSqrtOFF = arrList.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b) );
		System.out.println("Product of sqr root: "  + productOfSqrtOFF);

	}
}
