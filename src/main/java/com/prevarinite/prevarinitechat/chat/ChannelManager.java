package com.prevarinite.prevarinitechat.chat;

import com.prevarinite.prevarinitechat.wrapper.User;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ChannelManager {
    private Map<String,ChatChannel> channelMap;
    private Map<UUID,String> playerChannelMap;
    private ChatChannel defaultChannel;

    public Optional<ChatChannel> getChannel(String name){
        return Optional.ofNullable(channelMap.get(name));
    }
    public ChatChannel getUserChannel(User player){
        String channelName = playerChannelMap.computeIfAbsent(player.getUUID(),a-> defaultChannel.getName());
        return channelMap.getOrDefault(channelName,defaultChannel);
    }

    public boolean setPlayerChannel(User user,String channelName){
        Optional<ChatChannel> channelOptional = getChannel(channelName);
        if(!channelOptional.isPresent())return false;
        ChatChannel channel = channelOptional.get();
        ChatChannel current = getUserChannel(user);
        current.removeRecipient(user);
        playerChannelMap.put(user.getUUID(),channelName);
        channel.addRecipient(user);
        return true;
    }



}
