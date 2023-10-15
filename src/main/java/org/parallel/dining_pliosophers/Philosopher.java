package org.parallel.dining_pliosophers;

public class Philosopher implements Runnable {
    private PhState phState;
    private String name;
    private Fork left;
    private Fork right;
    private int timeToEat;

    public Philosopher(String name, int timeToEat, Fork left, Fork right) {
        this.phState = PhState.THINKING;
        this.name = name;
        this.timeToEat = timeToEat;
        this.left = left;
        this.right = right;
    }

    public void takeLeftFork() {
        if (left.isFree() == true) {
            left.take(name);
            System.out.println(name + " took left fork");
        }
    }

    public void takeRightFork() {
        if (right.isFree() == true) {
            right.take(name);
            System.out.println(name + " took right fork");
        }
    }

    public void eat() {
        try {
                System.out.println(name + " is eating; [leftOwner=" + left.getOwner() + "]" + "[rightOwner=" + right.getOwner() + "]");
                Thread.sleep(timeToEat * 1000);
            } catch (Exception e) {

        }
    }

    public void putLeftFork() {
        left.put();
        System.out.println(name + " put left fork");
    }

    public void putRightFork() {
        right.put();
        System.out.println(name + " put right fork");
    }

    public void think() {
        try {
            System.out.println(name + " is thinking");
            Thread.sleep(1000);
        } catch (Exception e) {

        }
    }

    @Override
    public void run() {
        while (true) {
            think();
            synchronized (left) {
                takeLeftFork();
                    synchronized (right) {
                        takeRightFork();
                        eat();
                        putRightFork();
                }
                putLeftFork();
                think();
            }
        }
    }
}
