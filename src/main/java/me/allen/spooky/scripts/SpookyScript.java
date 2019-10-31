package me.allen.spooky.scripts;

import me.allen.spooky.Spooky;

public abstract class SpookyScript {

    protected Spooky spooky = Spooky.getInstance();

    public abstract String getName();

    public abstract boolean canTrigger();

    public abstract String[] getMessage();

    public void onTriggered(String trigger) {}

    public abstract SpookyScript getNextScript(String trigger);

}
