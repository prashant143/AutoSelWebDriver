import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
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

		ArrayList<String> names = new ArrayList<String>();
		names.add("Jayesh");
		names.add("Harshil");
		names.add("Vipul");
		names.add("Navya");
		
		List<String> familyName = Arrays.asList("Jinal", "Shweta","Kaushik","Dhaval");
		
		Stream.of("Amit", "Prashant", "Snehal", "Adam").filter(s->s.endsWith("t"));
		
		Stream.of("Amit", "Prashant", "Snehal", "Adam").filter(s->s.startsWith("A")).sorted()
		.map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		Stream<String> combineNames = Stream.concat(names.stream(), familyName.stream());
		
		//combineNames.sorted().forEach(s->System.out.println(s));
		
		boolean flag = combineNames.anyMatch(s->s.equalsIgnoreCase("Dhaval"));
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void streamCollect()
	{
		List<String> nameValue = Stream.of("Jinal", "Shweta","Kaushik","Dhaval")
				.filter(s->s.endsWith("l")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(nameValue.get(0));
		
		//print unique number from the array list and sort the array
		List<Integer> numberValue = Arrays.asList(2,4,5,2,6,7,8,6,9,0,3,2,1,3,1);
		numberValue.stream().sorted().distinct().forEach(s->System.out.println(s));
		List<Integer> li =  numberValue.stream().sorted().distinct().collect(Collectors.toList());
		
	}
}
