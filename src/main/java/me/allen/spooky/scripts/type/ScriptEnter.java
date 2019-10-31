package me.allen.spooky.scripts.type;

import me.allen.spooky.scripts.ScriptManager;
import me.allen.spooky.scripts.SpookyScript;
import me.allen.spooky.scripts.type.kitchen.ScriptKitchen;

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
                "Let's start your adventure",
                "You are in a creepy house! Would you like to go \"upstairs\" or into the \"kitchen\" ?"
        };
    }

    @Override
    public void onTriggered(String trigger) {

    }

    @Override
    public SpookyScript getNextScript(String trigger) {
        switch (trigger.toLowerCase()) {
            case "kitchen":
                return new ScriptKitchen();
            default:
                return ScriptManager.DENIED;
        }
    }

}
