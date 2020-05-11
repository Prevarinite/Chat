package com.prevarinite.prevarinitechat;

import net.milkbowl.vault.chat.Chat;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class PrevariniteChat extends JavaPlugin {
    private static PrevariniteChat instance;
    private Chat chat;

    @Override
    public void onEnable() {
        instance = this;
        setupChat();
    }

    @Override
    public void onDisable() {

    }


    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    public static Chat getChat() {
        return instance.chat;
    }


}
