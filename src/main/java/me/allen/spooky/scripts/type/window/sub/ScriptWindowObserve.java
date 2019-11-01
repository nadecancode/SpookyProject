package me.allen.spooky.scripts.type.window.sub;

import me.allen.spooky.Spooky;
import me.allen.spooky.scripts.SpookyScript;
import me.allen.spooky.scripts.type.window.ScriptWindow;

public class ScriptWindowObserve extends SpookyScript {

    @Override
    public String getName() {
        return "Window|Observe";
    }

    @Override
    public boolean canTrigger() {
        return Spooky.getInstance().getScriptManager().getLastScript().getName().equalsIgnoreCase("Kitchen");
    }

    @Override
    public String[] getMessage() {
        return new String[] {
                "The sky has turned orange. You see the color green below but it doesn't look like grass. You also hear strange growling noises coming from all directions.",
                "",
                "Input anything to close the window and go back"
        };
    }

    @Override
    public SpookyScript getNextScript(String trigger) {
        return new ScriptWindow();
    }

}
