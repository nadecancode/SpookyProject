package me.allen.spooky.scripts.type;

import me.allen.spooky.scripts.ScriptManager;
import me.allen.spooky.scripts.SpookyScript;
import me.allen.spooky.scripts.type.window.ScriptWindow;

public class ScriptEnter extends SpookyScript {

    @Override
    public String getName() {
        return "Enter";
    }

    @Override
    public boolean canTrigger() {
        return true;
    }

    @Override
    public String[] getMessage() {
        return new String[] {
                "You wake up because of a blinding orange light coming out of the window. You glance at you watch. Its 3:00AM.",
                "Choose: Open the window (Input \"window\"), or Go downstairs (Input \"stairs\")"
        };
    }

    @Override
    public void onTriggered(String trigger) {

    }

    @Override
    public SpookyScript getNextScript(String trigger) {
        switch (trigger.toLowerCase()) {
            case "window":
                return new ScriptWindow();
            case "stairs":
            default:
                return ScriptManager.DENIED;
        }
    }

}
