import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class JavaLambada {

	// Count the name in the list which starts with the letter A
	@Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Amit");
		names.add("Prashant");
		names.add("Snehal");
		names.add("Adam");
		names.add("Ajay");
		names.add("Jayesh");
		names.add("Vipul");
		names.add("Aryan");
		names.add("Hitesh");
		names.add("Navya");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String eachName = names.get(i);
			if (eachName.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}

	/*
	 * Stream() is nothing but collection of strings Use filter method from Stream()
	 * which will filter based upon condition -> is a lambada experession left side
	 * it represents declare parameter/variable and right side write the action
	 */
	@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Amit");
		names.add("Prashant");
		names.add("Snehal");
		names.add("Adam");
		Stream.of("Amit", "Prashant", "Snehal", "Adam").filter
		(s -> s.length() > 4).forEach(s -> System.out.println(s));

		// long countNames = names.stream().filter(s->s.startsWith("A")).count();
		// System.out.println(countNames);
	}
	/*
	 * Print names which has last letter as A and convert them to uppercase
	 */
	@Test
	public void streamMap() {
		Stream.of("Amit", "Prashant", "Snehal", "Adam").filter(s->s.endsWith("t"))
		.map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
	}
}
