package com.example.parallelarray;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ParallelArraysDemo {

	public static void main(String[] args) {
		
		long time = System.currentTimeMillis();
		
		long[] arrayOfLong = new long[20000];

		Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt(1000000));
		System.out.println("time taken: " + (System.currentTimeMillis() - time) + "ºÁÃë");
		time =  System.currentTimeMillis();
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();

		Arrays.parallelSort(arrayOfLong);
		System.out.println("time taken: " + (System.currentTimeMillis() - time) + "ºÁÃë");
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();
		
	
		
	}
}
