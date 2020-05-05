package ru.ershova.lab11;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.ershova.lab11.config.AppConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Anna
 */
public class Main {
        public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();

        addPerson(personList);

        System.out.println(personList);
        Collections.sort(personList);
        System.out.println(personList);
    }

    private static void addPerson(Collection collection) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class
        );
        collection.add((Person) context.getBean("person", "Petr", "Petrov", 32));
        collection.add((Person) context.getBean("person", "Ivan", "Ivanov", 31));
        collection.add((Person) context.getBean("person", "Petr", "Shishkin", 27));
        collection.add((Person) context.getBean("person", "Aleksey", "Osin", 29));
        collection.add((Person) context.getBean("person", "Aleksey", "Osin", 23));
    }
}
