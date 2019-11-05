package me.allen.spooky.scripts.type.window.freak;

import me.allen.spooky.scripts.SpookyScript;
import me.allen.spooky.scripts.type.living.ScriptLivingRoom;

public class ScriptFreakOut extends SpookyScript {

    @Override
    public String getName() {
        return "Window|FreakOut";
    }

    @Override
    public boolean canTrigger() {
        return spooky.getSpookyUser().hasActionPerformed("WatchTV") && spooky.getScriptManager().getLastScript().getName().equalsIgnoreCase("Window|Next");
    }

    @Override
    public String[] getMessage() {
        if (!spooky.getSpookyUser().checkDeath()) {
            return new String[] {
                    "You freaked out",
                    "HP -1 (Current: " + spooky.getSpookyUser().getHealth() + ")",
                    "Input anything to exit and return to the living room."
            };
        } else {
            return new String[] {
                    "You died because you freaked out"
            };
        }
    }

    @Override
    public SpookyScript getNextScript(String trigger) {
        return spooky.getSpookyUser().getHealth() > 0 ? new ScriptLivingRoom() : null;
    }

}
