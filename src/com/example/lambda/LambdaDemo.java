package com.example.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
     * 遍历list里面的每一个元素， 如果元素满足predicte指定的条件， 那么就用consumer消费这个元素。 consumer
     * 允许你把一个"无返回值函数"当成一个参数传给一个方法。
     * 
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
     * 遍历list里面的每一个元素， 如果元素满足predicte指定的条件， 那么就用consumer消费这个元素。 consumer
     * 允许你把一个"有返回值函数"当成一个参数传给一个方法。
     * 
     * @param list
     * @param predicate
     * @param consumer
     */
    public static void printCollection(List<Integer> list, Predicate<Integer> predicate, Consumer<String> consumer,
            Function<Integer, String> action) {
        list.forEach(a -> {
            if (predicate.test(a)) {
                consumer.accept(action.apply(a));
            }
        });

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

        // 看看 nums 是不是空, 如果不是空,就遍历里面每个元素.
        System.out.println("============visit each of the element in list nums if it's not null. =================");
        Optional.ofNullable(nums).ifPresent(num -> {
            num.forEach(c -> System.out.println(c));
        });
    }
}
