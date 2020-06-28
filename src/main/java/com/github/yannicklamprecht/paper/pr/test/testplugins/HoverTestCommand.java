package com.github.yannicklamprecht.paper.pr.test.testplugins;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.HelpCommand;
import co.aikar.commands.annotation.Subcommand;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.awt.*;

@CommandAlias("hoverfrom")
public class HoverTestCommand extends BaseCommand {
    @Subcommand("item")
    public void showItem(Player player) {
        ItemStack itemStack = player.getEquipment().getItemInMainHand();

        TextComponent textComponent = new TextComponent("item");
        textComponent.setHoverEvent(Bukkit.hoverEventOf(itemStack));
        player.sendMessage(textComponent);
    }

    @Subcommand("entityStringNoName")
    public void entityStringNoName(Player player) {

        Entity entity = player.getTargetEntity(10);

        if (entity == null) {
            entity = player;
        }

        TextComponent textComponent = new TextComponent("entity");
        textComponent.setHoverEvent(Bukkit.hoverEventOf(entity, (String)null));
        player.sendMessage(textComponent);
    }

    @Subcommand("entityString")
    public void entityString(Player player, String name) {

        Entity entity = player.getTargetEntity(10);

        if (entity == null) {
            entity = player;
        }

        TextComponent textComponent = new TextComponent("entity");
        textComponent.setHoverEvent(Bukkit.hoverEventOf(entity, name));
        player.sendMessage(textComponent);
    }

    @Subcommand("entityComponent")
    public void entityComponent(Player player, String name) {

        Entity entity = player.getTargetEntity(10);

        if (entity == null) {
            entity = player;
        }

        BaseComponent textComponent = new ComponentBuilder("[entity]").color(ChatColor.of(new Color(111,45, 169))).getCurrentComponent();
        textComponent.setHoverEvent(Bukkit.hoverEventOf(entity, new ComponentBuilder(name).color(ChatColor.of(new Color(11,160, 9))).getCurrentComponent()));
        player.sendMessage(textComponent);
    }


    @HelpCommand
    public void help(CommandSender sender, CommandHelp help) {
        help.showHelp();
    }
}
