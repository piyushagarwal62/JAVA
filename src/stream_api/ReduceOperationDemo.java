package stream_api;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author piyush.agarwal
 *
 */
public class ReduceOperationDemo {

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.add(1);
		arrList.add(2);
		arrList.add(3);
		arrList.add(4);
		arrList.add(5);
		arrList.add(6);
		arrList.add(7);

		int mult = 1;
		for(int i = 1; i <= 7; i++){
			if(i % 2 ==0){
				mult = mult * i;
			}
		}
		System.out.println(mult);
		System.out.println("Origial List: " + arrList);

		Stream<Integer> stream = arrList.stream();
		Optional<Integer> reduce = stream.reduce((a,b)-> a *b); //terminal operation
		if (reduce.isPresent()) {
			System.out.println("Product as Optional:" + reduce.get());
		}

		stream = arrList.stream();
		int product = stream.reduce(1, (a,b)->a*b);
		if (reduce.isPresent()) {
			System.out.println("Product as Optional:" + product);
		}

		stream = arrList.stream();
		int evenProduct = stream.reduce(1, (a,b)->{
			if(b%2 ==0)
				return a*b; 
			else 
				return a;
		});
		if (reduce.isPresent()) {
			System.out.println("Product as Optional:" + evenProduct);
		}

	}
}
