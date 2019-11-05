package me.allen.spooky.scripts.type.window.tv;

import me.allen.spooky.scripts.SpookyScript;
import me.allen.spooky.scripts.type.living.ScriptLivingRoom;

public class ScriptWatchTV extends SpookyScript {

    @Override
    public String getName() {
        return "Window|Watch TV";
    }

    @Override
    public boolean canTrigger() {
        return spooky.getScriptManager().getLastScript().getName().equalsIgnoreCase("LivingRoom");
    }

    @Override
    public String[] getMessage() {
        return new String[] {
                "You tried to watch TV but you realized you forgot to pay to activate it for this month.",
                "Input anything to exit and return to living room."
        };
    }

    @Override
    public SpookyScript getNextScript(String trigger) {
        return new ScriptLivingRoom();
    }

    @Override
    public void onTriggered(String trigger) {
        spooky.getSpookyUser().addAction("WatchTV");
    }
}
