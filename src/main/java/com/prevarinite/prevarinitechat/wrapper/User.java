package com.prevarinite.prevarinitechat.wrapper;

import com.prevarinite.prevarinitechat.PrevariniteChat;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.entity.Player;

import java.util.UUID;

public class User {
    private Player player;
    private Chat c = PrevariniteChat.getChat();

    public String getPrefix(){
        return c.getPlayerPrefix(player);
    }
    public String getSuffix(){
        return c.getPlayerSuffix(player);
    }
    public String getDisplayName(){
        return player.getDisplayName();
    }
    public String getName(){
        return player.getName();
    }
    public void sendMessage(String msg,boolean applyColor){//TODO:: Color
        player.sendMessage(msg);
    }
    public UUID getUUID(){
        return player.getUniqueId();
    }
}
