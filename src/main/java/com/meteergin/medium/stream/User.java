package com.meteergin.medium.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author Mete Ergin
 */
@Data
@AllArgsConstructor
@ToString
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private int age;

}
