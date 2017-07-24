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

		// �����������������һ��stream
		Stream.generate(() -> Integer.valueOf((int) (Math.random() * 100000)))
				// ����steam�ĳ��ȣ���Ȼ����ѭ������Զͣ�������ˡ�
				.limit(100)
				// ��ӹ���������
				.filter(c -> c % 2 == 0)
				// ��Ӷ�Ԫ�صĶ�����
				.forEach(num -> System.out.println(num));
	}
}
