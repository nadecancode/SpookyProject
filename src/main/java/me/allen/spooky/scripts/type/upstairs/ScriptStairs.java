package me.allen.spooky.scripts.type.upstairs;

import me.allen.spooky.scripts.SpookyScript;

public class ScriptStairs extends SpookyScript {

    @Override
    public String getName() {
        return "Stairs";
    }

    @Override
    public boolean canTrigger() {
        return false;
    }

    @Override
    public String[] getMessage() {
        return new String[0];
    }

    @Override
    public SpookyScript getNextScript(String trigger) {
        return null;
    }

}
