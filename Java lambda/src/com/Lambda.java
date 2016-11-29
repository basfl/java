package com;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

interface I {
	public void add(int a, int b);
}
 
public class Lambda {

	public static void main(String[] args) {
		I i = (int a, int b) -> {
			System.out.println("\n **** " + (a + b));
		};
		i.add(2, 3);
		List<String> strings = new ArrayList<String>();
		strings.add("babak");
		strings.add("amir");
		strings.add("parisa");
		strings.stream().forEach((string) -> {
			if (string.equals("amir")) {
				System.out.println("\n **********%%%%%%");
			}
			System.out.println("\n string is *****" + string);
		});
		strings.stream().filter(s -> s.equals("amir")).forEach((s1) -> {
			System.out.println("\n ***pepe" + "\t" + s1);

		});

	}

}
