package com.example.parallelarray;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Floor {
	private int length;
	private int width;

	public Floor(int length, int width) {
		this.length = length;
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public static Floor[] createFloors() {

		Floor[] floors = new Floor[50];

		IntStream.range(0, floors.length).forEach(i -> {
			int a = ThreadLocalRandom.current().nextInt(100);
			int b = ThreadLocalRandom.current().nextInt(100);
			floors[i] = new Floor(a, b);
		});
		return floors;
	}
}