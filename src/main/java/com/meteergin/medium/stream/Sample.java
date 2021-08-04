package com.meteergin.medium.stream;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mete Ergin
 */
public class Sample {
    private List<User> userList = Arrays.asList(
            new User(1, "James", "Robert", 37),
            new User(2, "Mary", "Patricia", 11),
            new User(3, "John", "Michael", 7),
            new User(4, "Jennifer", "Linda", 77),
            new User(5, "William", "Elizabeth", 23)
    );

    public static void main(String... args) {
        Sample sample = new Sample();
        sample.test1();
        sample.test2();
    }

    private void test1() {
        System.out.println("Test 1");
        
        userList.stream().forEach(System.out::println);
    }

    private void test2() {
        System.out.println("Test 2");
        
        userList.stream().map(u -> {
            return new User(u.getId(), "X " + u.getFirstName(), "Y " + u.getLastName(), u.getAge() + 10);
        }).collect(Collectors.toList())
                .forEach(System.out::println);

        userList.stream().forEach(System.out::println);
    }

}
