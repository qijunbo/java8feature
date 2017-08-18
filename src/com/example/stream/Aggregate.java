package com.example.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Aggregate {

	public static void main(String[] args) {

		List<Integer> nums = new ArrayList<Integer>();

		Collections.addAll(nums, 1, null, 3, 4, null, 6);

		System.out.println(nums.stream().filter(num -> num != null).count());

		Stream.generate(new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			}
		});

		Stream.generate(Math::random);

		// 用随机数发生器生成一个stream
		Stream.generate(() -> Integer.valueOf((int) (Math.random() * 100000)))
				// 限制steam的长度，不然就死循环，永远停不下来了。
				.limit(100)
				// 添加过滤条件。
				.filter(c -> c % 2 == 0)
				// 添加对元素的动作。
				.forEach(num -> System.out.println(num));
	}
}
