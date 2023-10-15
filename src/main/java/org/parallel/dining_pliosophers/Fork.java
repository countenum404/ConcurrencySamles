package org.parallel.dining_pliosophers;

public class Fork {

    private boolean free = true;
    private String owner;

    public String getOwner() {
        return owner;
    }

    public Fork() {
    }

    public void take(String name) {
        this.owner = name;
        this.free = false;
    }

    public void put() {
        this.free = true;
    }

    public boolean isFree() {
        return free;
    }
}
