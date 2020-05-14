package stream_api;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WrapperStreams {

	public static void main(String[] args) {
		
		intsteamClass();
		
		int[] array = {4,2,8,2,5,1};
		// 4 2 8 5 1
		
		// 1 2 4 5 8 
		long count = IntStream.of(array) //Created Stream
				.distinct() 			//Processing Stream
				.count();				//Consuming Stream
		System.out.println(count);
		
		IntStream distinct = IntStream.of(array).distinct();

		IntStream sorted = distinct.filter((a)-> a%2==1).sorted(); 
		int sum = (int) sorted.sum();
		System.out.println("Sum of the distinct numbers that are odd:" + sum);
		
		DoubleStream filter = DoubleStream.of(new double[]{4.0,3.0,6.0,2.0}).filter((a)-> a%6 ==0);
		Stream<Double> boxed = filter.boxed();
		boxed.forEach(a->System.out.println(a));
		boxed.forEach(System.out::println);
	}

	private static void intsteamClass(){
		int[] array = {4,2,8,2,5,1};
		IntStream.of(array).average();
		IntStream.of(array).min();
		IntStream.of(array).max();
		IntStream.of(array).sum();
		IntStream.of(array).count();
		
		IntStream.range(1,100).forEach(System.out::println);
		int[] array2 = IntStream.rangeClosed(1,  100).toArray();
		Arrays.stream(array2).forEach(System.out::println);
		
		List<Integer> list = IntStream.range(1, 100).boxed().collect(Collectors.toList());
		boolean anyMatch = list.stream().anyMatch(num -> num % 2 == 1);
		System.out.println("Found match:" + anyMatch);
		
		System.out.println(IntStream.of(array).allMatch(num -> num %2 == 1));
	}
}
