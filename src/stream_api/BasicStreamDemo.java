package stream_api;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author piyush.agarwal
 *
 */
public class BasicStreamDemo {

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.add(45);
		arrList.add(56);
		arrList.add(23);
		arrList.add(20);
		arrList.add(71);
		arrList.add(5);
		arrList.add(8);
		System.out.println("Origial List: " + arrList);

		/*		
		 * 		Similar to old style of code
				int min = arrList.get(0);
				for (int i = 1; i < arrList.size(); i++) {
					if(min> arrList.get(i)){
						min = arrList.get(i);
					}
				}
				System.out.println(min);
		*/

		Stream<Integer> stream = arrList.stream(); // Created a stream
		Optional<Integer> minValue = stream.min(Integer::compare);// Process
		if (minValue.isPresent()) {
			System.out.println("Min Value: " + minValue.get());// Consume
		}

		stream = arrList.stream();// Create Stream
		Optional<Integer> maxValue = stream.max(Integer::compare);
		if (maxValue.isPresent()) {
			System.out.println("Max Value: " + maxValue.get());
		}

		Stream<Integer> sorted = arrList.stream().sorted(); // process stream

		System.out.println("Display all the values in sorted format");
		sorted.forEach((n) -> System.out.println("Values are: " + n)); // consume
																		// stream

		System.out.println("Display only odd values");
		sorted = arrList.stream().sorted(); // Create Stream
		sorted.filter((n) -> n % 2 == 1).forEach(System.out::println);

		System.out.println("Display values that are odd and greater then 10");
		sorted = arrList.stream().sorted();
		sorted.filter(n -> n % 2 == 1).filter(n -> n > 10).forEach(System.out::println);

	}
}
