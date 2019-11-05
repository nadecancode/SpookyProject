package me.allen.spooky.scripts.type.upstairs;

import me.allen.spooky.scripts.SpookyScript;
import me.allen.spooky.scripts.type.ScriptEnter;

public class ScriptStairs extends SpookyScript {

    @Override
    public String getName() {
        return "Stairs";
    }

    @Override
    public boolean canTrigger() {
        return spooky.getScriptManager().getLastScript().getName().equalsIgnoreCase("Enter");
    }

    @Override
    public String[] getMessage() {
        if (!spooky.getSpookyUser().checkDeath()) {
            return new String[] {
                    "You tried to go to stairs but you fell",
                    "HP -1 (Current: " + spooky.getSpookyUser().getHealth() + ")",
                    "Input anything to exit and return to the enter."
            };
        } else {
            return new String[] {
                    "You died because you fell down from the stairs"
            };
        }
    }

    @Override
    public SpookyScript getNextScript(String trigger) {
        return spooky.getSpookyUser().getHealth() > 0 ? new ScriptEnter() : null;
    }

    @Override
    public void onTriggered(String trigger) {
        spooky.getSpookyUser().addAction("FellFromStairs");
    }

}
