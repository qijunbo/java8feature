package com.example.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemo {

	/**
	 * Evaluate the predicate on each item in given list, print the item when
	 * the predicate returns true.
	 * 
	 * @param list
	 * @param predicate
	 */
	public static void printCollection(List<Integer> list, Predicate<Integer> predicate) {

		for (Integer num : list) {
			if (predicate.test(num)) {
				System.out.println(num);
			}
		}

	}
	
	/**
	 * ����list�����ÿһ��Ԫ�أ� ���Ԫ������predicteָ���������� ��ô����consumer�������Ԫ�ء�
	 * consumer �������һ��"�޲�������"����һ����������һ��������
	 * @param list
	 * @param predicate
	 * @param consumer
	 */

	public static void printCollection(List<Integer> list, Predicate<Integer> predicate, Consumer<Integer> consumer) {

		for (Integer num : list) {
			if (predicate.test(num)) {
				consumer.accept(num);
			}
		}

	}
	/**
	 * ����list�����ÿһ��Ԫ�أ� ���Ԫ������predicteָ���������� ��ô����consumer�������Ԫ�ء�
	 * consumer �������һ��"�в�������"����һ����������һ��������
	 * @param list
	 * @param predicate
	 * @param consumer
	 */
	public static void printCollection(List<Integer> list, Predicate<Integer> predicate, Consumer<String> consumer,
			Function<Integer, String> action) {

		for (Integer num : list) {
			if (predicate.test(num)) {
				consumer.accept(action.apply(num));
			}
		}

	}

	public static void main(String[] args) {

		List<Integer> nums = new ArrayList<Integer>();

		Collections.addAll(nums, 10, null, 13, 14, null, 16, 21);

		printCollection(nums, i -> i != null && i > 0);

		printCollection(nums, i -> i != null && i > 0, c -> System.out.print(c));

		printCollection(nums, i -> i != null && i > 0, c -> System.out.print("[" + c + "]"), a -> a.toString());

		nums.stream().filter(i -> i != null).map(m -> Integer.toHexString(m.intValue())).forEach(a -> {
			System.out.print("[" + a.toUpperCase() + "]");
		});
		;
	}
}
