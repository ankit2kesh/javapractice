import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Melisandre", "Sansa", "Jon", "Daenerys", "Joffery");
		List<String> longnames = names.stream().filter(str -> str.length() > 6 && str.length() < 8) // Multiple
//								.forEach(result->System.out.println(result));																	// conditions
				.collect(Collectors.toList());
		longnames.forEach(System.out::println);//method reference
		longnames.forEach(x->System.out.println(x));//lamda expression

		
		
		
		
		
		Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
			System.out.println("filter: " + s);
			return s.startsWith("a");
		}).map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).forEach(s -> System.out.println("forEach: " + s));
	}
}
