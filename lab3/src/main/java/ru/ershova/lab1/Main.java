package ru.ershova.lab1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.ershova.lab1.config.SpringConfig;
//import ru.ershova.lab1.Spaceship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anna
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        List<Spaceship> spaceshipList = new ArrayList<>();

        spaceshipList.add((Spaceship) context.getBean("spaceship", 30));
        spaceshipList.add((Spaceship) context.getBean("spaceship", 20));
        spaceshipList.add((Spaceship) context.getBean("spaceship", 10));

        minSpeed(spaceshipList);

        avgSpeed(spaceshipList);
    }

    public static void minSpeed(List<Spaceship> spaceships) {
        int min = spaceships.get(0).getSpeed();
        for (Spaceship ship: spaceships
            ) {
            if (ship.getSpeed() < min) {
                min = ship.getSpeed();
            }
        }
        System.out.println("Min speed: " + min);
    }

    public static void avgSpeed(List<Spaceship> spaceships) {
        double sum = 0.0;
        for (Spaceship ship: spaceships
            ) {
            sum += ship.getSpeed();
        }
        System.out.println("Average speed: " + sum / spaceships.size());
    }
}
