package me.allen.spooky.scripts.type.living;

import me.allen.spooky.scripts.ScriptManager;
import me.allen.spooky.scripts.SpookyScript;
import me.allen.spooky.scripts.type.exit.ScriptExit;
import me.allen.spooky.scripts.type.window.freak.ScriptFreakOut;
import me.allen.spooky.scripts.type.window.tv.ScriptWatchTV;

import java.util.ArrayList;
import java.util.List;

public class ScriptLivingRoom extends SpookyScript {

    @Override
    public String getName() {
        return "LivingRoom";
    }

    @Override
    public boolean canTrigger() {
        return spooky.getScriptManager().getLastScript().getName().contains("Window");
    }

    @Override
    public String[] getMessage() {
        List<String> actionsAvailable = new ArrayList<>();
        if (spooky.getSpookyUser().hasActionPerformed("WatchTV")) {
            actionsAvailable.add("Freak Out (c)");
        } else {
            actionsAvailable.add("Watch TV (x)");
        }

        if (spooky.getSpookyUser().hasActionPerformed("KnifePicked")) {
            actionsAvailable.add("Unlock the Window by Knife (u)");
        }

        actionsAvailable.add("Exit (z)");

        return new String[] {
                "You have " + (actionsAvailable.size()) + " options: " + String.join(",", actionsAvailable.toArray(new String[] {}))
        };
    }

    @Override
    public SpookyScript getNextScript(String trigger) {
        switch (trigger) {
            case "x":
                if (!spooky.getSpookyUser().hasActionPerformed("WatchTV")) {
                    return new ScriptWatchTV();
                } else {
                    return ScriptManager.DENIED;
                }
            case "c":
                if (spooky.getSpookyUser().hasActionPerformed("WatchTV")) {
                    return new ScriptFreakOut();
                } else {
                    return ScriptManager.DENIED;
                }
            case "u":
                if (spooky.getSpookyUser().hasActionPerformed("KnifePicked")) {
                    return new ScriptExit();
                } else {
                    return ScriptManager.DENIED;
                }
        }

        return ScriptManager.DENIED;
    }

}
