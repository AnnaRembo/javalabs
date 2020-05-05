package ru.ershova.lab30;

/**
 * @author Anna
 */
public class Robot {

    private final Object step = new Object();
    // поток 1 - нога 1
    // поток 2 - нога 2

    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.walk();
    }

    public void doStep(String leg) throws InterruptedException {
        while (true) {
            synchronized (step) {
                notifyStep(leg);
                try {
                    step.wait(); // ждет notify
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // шагает, освобождает все из wait, засыпает
    public synchronized void notifyStep(String leg) throws InterruptedException {
        System.out.println(leg);
        step.notifyAll();
        Thread.sleep(1000);
    }

    public void walk() {
        Thread thread1 = new Thread(() -> {
            try {
                doStep("leg 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                doStep("leg 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}
