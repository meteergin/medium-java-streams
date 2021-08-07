package com.meteergin.medium.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Mete Ergin
 */
public class Sample {

    private final List<User> userList = Arrays.asList(
            new User(1, "Michael", "Robert", 37, "TR"),
            new User(2, "Mary", "Patricia", 11, "EN"),
            new User(3, "John", "Michael", 7, "FR"),
            new User(4, "Jennifer", "Linda", 77, "TR"),
            new User(5, "William", "Elizabeth", 23, "US"),
            new User(6, "Sue", "Jackson", 11, "IT"),
            new User(7, "Michael", "Tommy", 37, "EN")
    );

    public static void main(String... args) {
        Sample sample = new Sample();
        sample.test1();
        sample.test2();
        sample.test3();
        sample.test4();
        sample.test5();
        sample.test6();
        sample.test7();
        sample.test8();
        sample.test9();
        sample.test10();
    }

    private void test1() {
        System.out.println("Test 1");

        userList.stream().
                forEach(System.out::println);
    }

    private void test2() {
        System.out.println("Test 2");

        userList.stream()
                .map(u -> {
                    return new User(
                            u.getId(),
                            "X " + u.getFirstName(),
                            "Y " + u.getLastName(),
                            u.getAge() + 10,
                            u.getNationality());
                })
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private void test3() {
        System.out.println("Test 3");

        userList.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private void test4() {
        System.out.println("Test 4");

        userList.stream()
                .sorted(Comparator.comparing(User::getAge)
                        .thenComparing(User::getFirstName)
                        .thenComparing(User::getLastName))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private void test5() {
        System.out.println("Test 5");

        double averageAge = userList.stream()
                .mapToInt(User::getAge)
                .summaryStatistics()
                .getAverage();

        System.out.print("averageAge: " + averageAge);

        int maxFirstNameLenght = userList.stream()
                .mapToInt(user -> {
                    return user.getFirstName().length();
                })
                .summaryStatistics()
                .getMax();

        System.out.println(" maxFirstNameLenght: " + maxFirstNameLenght);
    }

    private void test6() {
        System.out.println("Test 6");

        boolean isAllAgesGreaterThan6 = userList.stream()
                .allMatch(user -> user.getAge() > 6);

        System.out.println("isAllAgesGreaterThan6: " + isAllAgesGreaterThan6);
    }

    private void test7() {
        System.out.println("Test 7");
        boolean isFirstCharS = userList.stream()
                .anyMatch(user -> user.getFirstName().charAt(0) == 'S');

        System.out.println("isFirstCharS: " + isFirstCharS);
    }

    private void test8() {
        System.out.println("Test 8");

        List<User> list = userList.stream()
                .collect(Collectors.toList());

        Set<User> set = userList.stream()
                .collect(Collectors.toSet());

        List<User> linkedList = userList.stream()
                .collect(Collectors.toCollection(LinkedList::new));

        Map<Long, User> map = userList.stream()
                .collect(Collectors.toMap(user -> user.getId(), user -> user));
    }

    private void test9() {
        System.out.println("Test 9");

        long countDifferentNationalites = userList.stream()
                .map(User::getNationality)
                .distinct()
                .count();

        System.out.println("countDifferentNationalites: " + countDifferentNationalites);
    }

    private void test10() {
        System.out.println("Test 10");

        userList.stream()
                .filter(p -> (p.getFirstName().charAt(0) != 'M'))
                .filter(p -> (p.getAge() > 10))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

}
