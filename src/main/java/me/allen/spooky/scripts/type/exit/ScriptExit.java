package me.allen.spooky.scripts.type.exit;

import me.allen.spooky.scripts.SpookyScript;

public class ScriptExit extends SpookyScript {

    @Override
    public String getName() {
        return "Exit";
    }

    @Override
    public boolean canTrigger() {
        return spooky.getSpookyUser().hasActionPerformed("KnifePicked");
    }

    @Override
    public String[] getMessage() {
        return new String[] {
                "You have successfully exited the house"
        };
    }

    @Override
    public SpookyScript getNextScript(String trigger) {
        return null;
    }

}
