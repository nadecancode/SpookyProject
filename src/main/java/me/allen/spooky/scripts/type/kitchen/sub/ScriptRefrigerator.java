package me.allen.spooky.scripts.type.kitchen.sub;

import me.allen.spooky.Spooky;
import me.allen.spooky.scripts.SpookyScript;

public class ScriptRefrigerator extends SpookyScript {

    @Override
    public String getName() {
        return "Refrigerator";
    }

    @Override
    public boolean canTrigger() {
        return Spooky.getInstance().getScriptManager().getLastScript().getName().equalsIgnoreCase("Kitchen");
    }

    @Override
    public String[] getMessage() {
        return new String[] {

        };
    }

    @Override
    public SpookyScript getNextScript(String trigger) {
        return null;
    }

}
