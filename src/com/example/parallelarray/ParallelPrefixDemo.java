package com.example.parallelarray;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class ParallelPrefixDemo {
	public static void main(String[] args) {
		BinaryOperator<Floor> opt = (f1, f2) -> new Floor(f1.getLength() + f2.getLength(),
				f1.getWidth() + f2.getWidth());
		Floor[] floors = Floor.createFloors();
		Consumer<Floor> print = f -> System.out.println(f.getLength() + ", " + f.getWidth());
		Arrays.stream(floors).forEach(print);
		
		System.out.println("parallel prefix for complete array");
		Arrays.parallelPrefix(floors, opt);
		
		Arrays.stream(floors).forEach(print);

		System.out.println("parallel prefix for array from index 1 to 4");
		floors = Floor.createFloors();
		Arrays.parallelPrefix(floors, 1, 4, opt);
		Arrays.stream(floors).forEach(print);
	}
}
