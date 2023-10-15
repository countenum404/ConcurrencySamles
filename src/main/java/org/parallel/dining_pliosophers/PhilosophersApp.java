package org.parallel.dining_pliosophers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhilosophersApp {

    public static void main(String[] args) {
        List<Fork> forks = new ArrayList<>() {{
            add(new Fork());
            add(new Fork());
            add(new Fork());
            add(new Fork());
            add(new Fork());
        }};
        List<Runnable> philosophers = new ArrayList<>() {{
            add(new Philosopher("Сократ", 2, forks.get(0), forks.get(1)));
            add(new Philosopher("Платон", 2, forks.get(1), forks.get(2)));
            add(new Philosopher("Аристотель", 2, forks.get(2), forks.get(3)));
            add(new Philosopher("Пифагор", 2, forks.get(3), forks.get(4)));
            add(new Philosopher("Атрей", 2, forks.get(0), forks.get(4)));
        }};

        List<Thread> phThreads = philosophers.stream().map(ph -> new Thread(ph)).collect(Collectors.toList());
        phThreads.forEach(t -> t.start());

    }
}
