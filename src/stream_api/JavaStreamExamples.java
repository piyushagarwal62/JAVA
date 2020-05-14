package stream_api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author piyush.agarwal
 *
 */
public class JavaStreamExamples {

	public static void main(String[] args) throws IOException {
		example1();
		example2();
		example3();
		example4();
		example5();
		example6();
		example7();
		example8();
		example9();
		example10();
		example11();
		example12();
		example13();
		example14();
	}

	private static void example1() {
		System.out.println("Printing range 1 to 10:");
		IntStream.range(1, 10).forEach(System.out::println);
	}

	private static void example2() {
		System.out.println("Printing range 1 to 10 but skiping first values: ");
		IntStream.range(1, 10).skip(5).forEach(x -> System.out.println(x));
	}

	private static void example3() {
		System.out.println("Printing sum for 1 to 10 : " + IntStream.range(1, 10).sum());
	}

	private static void example4() {
		System.out.print("Print the first value after sorting:");
		Stream.of("Ava", "Avanta", "Aliza", "Alberto").sorted().findFirst().ifPresent(System.out::println);
	}

	private static void example5() {
		System.out.print("Print the values that starts with S:");
		String[] names = { "Ali", "Ankit", "Kushal", "Rahul", "Shivin", "Shraddha", "Tanaji", "Shekhar" };

		String sortedNames = Arrays.stream(names).filter(x -> x.startsWith("S")).sorted()
				.collect(Collectors.joining(","));
		System.out.println(sortedNames);
	}

	private static void example6() {
		System.out.print("Find avearge of the square of numbers: ");
		Arrays.stream(new int[] { 2, 4, 6, 8, 10 }).map(x -> x * x).average().ifPresent(System.out::println);
	}

	private static void example7() {
		System.out.println("Print the values that starts with a:");
		List<String> people = Arrays.asList("Ali", "Ankit", "Kushal", "Rahul", "Shivin", "Shraddha", "Tanaji",
				"Shekhar");

		people.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).forEach(System.out::println);
	}

	private static void example8() throws IOException {
		System.out.println("Bands that have length more than 15");
		Stream<String> bands = Files.lines(Paths.get("resources/bands.txt"));
		bands.sorted().filter(x -> x.length() > 15).forEach(System.out::println);
		bands.close();
	}

	private static void example9() throws IOException {
		System.out.println("Bands that contains \"and\":");
		List<String> bands = Files.lines(Paths.get("resources/bands.txt")).filter(x -> x.contains("and"))
				.collect(Collectors.toList());
		bands.forEach(x -> System.out.println(x));
	}

	private static void example10() throws IOException {
		System.out.println("Valid Rows:");
		Stream<String> rows = Files.lines(Paths.get("resources/data.txt"));
		int rowCount = (int) rows.map(x -> x.split(",")).filter(x -> x.length == 4).count();
		System.out.println("RowCount: " + rowCount);
		rows.close();
	}

	private static void example11() throws IOException {
		System.out.println("Valid Rows:");
		Stream<String> rows = Files.lines(Paths.get("resources/data.txt"));
		rows.map(x -> x.split(",")).filter(x -> x.length == 4).filter(x -> Integer.parseInt(x[1]) > 15)
				.forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));
		rows.close();
	}

	private static void example12() throws IOException {
		System.out.println("Valid Rows:");
		Stream<String> rows = Files.lines(Paths.get("resources/data.txt"));
		HashMap<String, Integer> map = new HashMap<>();

		map = (HashMap<String, Integer>) rows.map(x -> x.split(",")).filter(x -> x.length == 4)
				.filter(x -> Integer.parseInt(x[1]) > 15)
				.collect(Collectors.toMap(x -> x[0], x -> Integer.parseInt(x[1])));
		rows.close();
		for (String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
	}

	private static void example13() {
		Double total = Stream.of(7.4, 1.5, 4.8).reduce(0.0, (Double a, Double b) -> a + b);
		System.out.println("Total of double values: " + total);
	}

	private static void example14() {
		IntSummaryStatistics summaryStatistics = IntStream.of(7, 2, 19, 88, 73, 4, 10).summaryStatistics();
		System.out.println(summaryStatistics);
	}

}
