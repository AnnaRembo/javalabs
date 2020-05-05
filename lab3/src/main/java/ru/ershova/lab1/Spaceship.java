package ru.ershova.lab1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Anna
 */
@Component
@Scope("prototype")
public class Spaceship {
    private int speed;

    public Spaceship(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
