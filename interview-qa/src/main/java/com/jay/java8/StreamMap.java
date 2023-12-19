package com.jay.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Jay", "123", Arrays.asList("jay1@abc.com", "jay2@abc.com")),
                new User("Ashish", "456", Arrays.asList("ashish1@abc.com", "ashish2@abc.com", "ashish3@abc.com"))
        );

        List<String> phones = users.stream().map(User::getPhone).collect(Collectors.toList());
        System.out.println(phones);
        List<String> names = users.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(names);

//As name and phone is in one-to-one relationship so map() is getting use.
// But in case of email it has one-to-many relation, So it's recommended to use flatMap()
        //In case of map() return is List of List
        List<List<String>> emails = users.stream().map(User::getEmail).collect(Collectors.toList());
        System.out.println(emails);
        //To make return as List use flatMap()
        List<String> emails1 = users.stream().flatMap(u -> u.getEmail().stream()).collect(Collectors.toList());
        System.out.println(emails1);

    }
}
