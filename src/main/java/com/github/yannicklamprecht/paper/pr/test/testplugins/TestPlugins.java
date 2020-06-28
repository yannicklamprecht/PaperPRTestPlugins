package com.github.yannicklamprecht.paper.pr.test.testplugins;

import co.aikar.commands.PaperCommandManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugins extends JavaPlugin {

    @Override
    public void onEnable() {
        PaperCommandManager commandManager = new PaperCommandManager(this);
        // optional: enable unstable api to use help
        commandManager.enableUnstableAPI("help");
        commandManager.registerCommand(new HoverTestCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
