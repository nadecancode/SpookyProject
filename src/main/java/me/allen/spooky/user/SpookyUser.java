package me.allen.spooky.user;

import java.util.ArrayList;
import java.util.List;

public class SpookyUser {
    private int health = 3;

    private List<String> actionsPerformed = new ArrayList<>();

    public boolean checkDeath() {
        return --health <= 0;
    }

    public void addAction(String action) {
        this.actionsPerformed.add(action);
    }

    public boolean hasActionPerformed(String action) {
        return this.actionsPerformed.contains(action);
    }

    public int getHealth() {
        return this.health;
    }
}
