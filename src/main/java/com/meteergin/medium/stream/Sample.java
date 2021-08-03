package com.meteergin.medium.stream;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Mete Ergin
 */
public class Sample {

    public List<User> userList = Arrays.asList(
            new User(1, "James", "Robert", 37),
            new User(2, "Mary", "Patricia", 11),
            new User(3, "John", "Michael", 7),
            new User(4, "Jennifer", "Linda", 77),
            new User(5, "William", "Elizabeth", 23)
    );

    public static void main(String... args) {

        Sample sample = new Sample();

    }

}
