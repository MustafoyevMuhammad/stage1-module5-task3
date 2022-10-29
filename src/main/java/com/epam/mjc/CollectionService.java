package com.epam.mjc;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionService {
    public List<Integer> filterEvenNumbers(List<Integer> list) {
        List<Integer> list1 = new ArrayList<Integer>();

        List<Integer> collect = (List<Integer>) list.stream().filter(numbers ->
                checkUp(Collections.singletonList(numbers))).collect(Collectors.toList());
        return collect;
    }

    private boolean checkUp(List<Integer> numbers) {
        for (int num : numbers) {
            if(num % 2 != 0)
                return false;
            else
                return true;
        }
        return true;
    }

    public List<String> toUpperCaseCollection(List<String> list) {
        return list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public Optional<Integer> findMax(List<Integer> list) {
        Optional<Integer> optional = Optional.of(list.stream().max(Integer::compareTo)).get();
        return optional;
    }

    public Optional<Integer> findMin(List<List<Integer>> list) {
        Optional<Integer> optional = Optional.of(list.stream().flatMap(list1 -> list1.stream()).min(Integer::compareTo)).get();
        return optional;
    }


    public Integer sum(List<Integer> list) {
        return list.stream().reduce(Integer::sum).get();
    }
}
