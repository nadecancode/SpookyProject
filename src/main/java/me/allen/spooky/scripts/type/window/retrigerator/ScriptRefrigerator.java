package me.allen.spooky.scripts.type.window.retrigerator;

import me.allen.spooky.scripts.SpookyScript;
import me.allen.spooky.scripts.type.living.ScriptLivingRoom;

public class ScriptRefrigerator extends SpookyScript {

    @Override
    public String getName() {
        return "Window|Refrigerator";
    }

    @Override
    public boolean canTrigger() {
        return spooky.getScriptManager().getLastScript().getName().equalsIgnoreCase("Window");
    }

    @Override
    public String[] getMessage() {
        return new String[] {
                "You opened refrigerator but there's nothing there but a knife",
                "You picked up the knife.",
                "Input anything to close the refrigerator and go back to the living room."
        };
    }

    @Override
    public SpookyScript getNextScript(String trigger) {
        return new ScriptLivingRoom();
    }

    @Override
    public void onTriggered(String input) {
        spooky.getSpookyUser().addAction("KnifePicked");
    }
}
