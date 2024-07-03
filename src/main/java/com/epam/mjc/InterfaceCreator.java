package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> list.stream()
                .allMatch(str -> Character.isUpperCase(str.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> evenNumbers = list.stream().filter(num -> (num & 1) != 1).collect(Collectors.toList());
            list.addAll(evenNumbers);
        };
    }

    @SuppressWarnings("java:S5998")
    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(s -> s.matches("^[A-Z].*\\b(\\w+\\b.*){3,}\\.$"))
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> list.stream()
                .collect(Collectors.toMap(Function.identity(), String::length, (existing, replacement) -> existing));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (l1, l2) -> {
            ArrayList<Integer> combined = new ArrayList<>(l1);
            combined.addAll(l2);

            return combined;
        };
    }
}
