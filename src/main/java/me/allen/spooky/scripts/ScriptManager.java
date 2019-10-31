package me.allen.spooky.scripts;

import me.allen.spooky.scripts.type.ScriptEnter;

public class ScriptManager {

    private SpookyScript scriptHandle, lastScript;

    public static final SpookyScript DENIED = new SpookyScript() {
        @Override
        public String getName() {
            return "Denied";
        }

        @Override
        public boolean canTrigger() {
            return false;
        }

        @Override
        public String[] getMessage() {
            return new String[0];
        }

        @Override
        public SpookyScript getNextScript(String trigger) {
            return null;
        }
    };

    public SpookyScript getCurrentScript() {
        return this.scriptHandle;
    }

    public SpookyScript getLastScript() {
        return this.lastScript;
    }

    public void setCurrentScript(SpookyScript scriptHandle) {
        this.lastScript = this.scriptHandle;
        this.scriptHandle = scriptHandle;
    }

    public void load() {
        this.scriptHandle = new ScriptEnter();
    }
}
