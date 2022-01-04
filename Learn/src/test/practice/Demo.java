package test.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Demo {
    public static void main(String args[]) {

        List<Integer> number = Arrays.asList(2, 3, 4, 5);
        List<Integer> square = number.stream().filter(i -> {
            return i % 2 == 0;
        }).map(i -> {
            return i = i * i;
        }).collect(Collectors.toList());
        System.out.println(square);

    }
}
