package me.allen.spooky;

import me.allen.spooky.scripts.ScriptManager;
import me.allen.spooky.scripts.SpookyScript;
import me.allen.spooky.user.SpookyUser;

import java.util.Scanner;

public class Spooky {

    private static ScriptManager scriptManager;
    private SpookyUser spookyUser = new SpookyUser();

    private static Spooky instance;

    public static void main(String[] args) {
        instance = new Spooky();
        scriptManager = new ScriptManager();
        scriptManager.load();
        initialize();
    }

    public static Spooky getInstance() {
        return instance;
    }

    public ScriptManager getScriptManager() {
        return scriptManager;
    }

    private static void initialize() {
        Scanner scanner = new Scanner(System.in);

        do {
            SpookyScript script = scriptManager.getCurrentScript();

            for (String message : script.getMessage()) {
                System.out.println(message);
            }

            String input = scanner.nextLine();

            if (script.canTrigger()) {
                script.onTriggered(input);
                SpookyScript spookyScript = script.getNextScript(input);
                while (spookyScript.getName().equalsIgnoreCase("Denied")) {
                    System.out.println("Please perform a correct action to continue your adventure :)");
                    input = scanner.nextLine();
                    spookyScript = script.getNextScript(input);
                }

                scriptManager.setCurrentScript(spookyScript);
            }
        } while (scriptManager.getCurrentScript().getNextScript("") != null);

        System.exit(0);
    }

    public SpookyUser getSpookyUser() {
        return this.spookyUser;
    }
}
