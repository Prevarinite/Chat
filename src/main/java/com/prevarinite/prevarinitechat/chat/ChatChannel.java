package com.prevarinite.prevarinitechat.chat;

import com.prevarinite.prevarinitechat.wrapper.User;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ChatChannel {
    private UUID channelID = UUID.randomUUID();
    //Data to be loaded
    private String name;
    private String permission;
    private String colorChatPermission;
    private String prefix,suffix;
    private String info;
    private String format = "#prefix# | #player# | #suffix# : #message# ";

    private boolean ignorePlayerPrefix = false;

    private Set<User> recipients = new HashSet<>();

    public void sendChannelMessage(User player, String message){
        if(recipients.isEmpty())return;
        String playerPrefix = player.getPrefix();
        String playerSuffix = player.getSuffix();
        String chMsg = applyFormatPlaceholders(playerPrefix,playerSuffix,player.getDisplayName(),message);
        recipients.stream().forEach(u->u.sendMessage(chMsg,false));
    }
    private String applyFormatPlaceholders(String prefix,String player, String suffix, String message){
        return format
                .replaceAll("(?i)#prefix#",prefix)
                .replaceAll("(?i)#suffix#",suffix)
                .replaceAll("(?i)#player#",player)
                .replaceAll("(?i)#message#",message);
    }

    public void addRecipient(User u){
        recipients.add(u);
    }
    public void removeRecipient(User u){
        recipients.remove(u);
    }
    public void removeAllRecipients(){
        recipients.clear();
    }
    public boolean isRecipient(User u){
        return recipients.contains(u);
    }
    public UUID getChannelID(){
        return channelID;
    }
    public String getName(){
        return name;
    }
}
