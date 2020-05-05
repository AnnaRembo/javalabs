package ru.ershova.lab24;

/**
 * @author Anna
 */
public class Car implements Speed{
    private float distance;
    private int time;

    public Car(float distance, int time) {
        this.distance = distance;
        this.time = time;
    }

    public float getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    @Override
    public float calculateSpeed(float S, int T) {
        if (T > 0) {
            float V = S / (T/60);
            return V;
        } else {
            // машина телепортируется?
            return S;
        }
    }
}
