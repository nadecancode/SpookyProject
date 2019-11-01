package me.allen.spooky.scripts.type.window;

import me.allen.spooky.scripts.ScriptManager;
import me.allen.spooky.scripts.SpookyScript;
import me.allen.spooky.scripts.type.window.freak.ScriptFreakOut;
import me.allen.spooky.scripts.type.window.tv.ScriptWatchTV;

import java.util.ArrayList;
import java.util.List;

public class ScriptWindowNext extends SpookyScript {

    @Override
    public String getName() {
        return "Window|Next";
    }

    @Override
    public boolean canTrigger() {
        return spooky.getScriptManager().getLastScript().getName().equalsIgnoreCase("Window|Observe");
    }

    @Override
    public String[] getMessage() {
        List<String> actionsAvailable = new ArrayList<>();
        if (spooky.getSpookyUser().hasActionPerformed("WatchTV")) {
            actionsAvailable.add("Freak Out (c)");
        } else {
            actionsAvailable.add("Watch TV (x)");
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
        }

        return ScriptManager.DENIED;
    }

}
