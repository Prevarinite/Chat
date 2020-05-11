package com.prevarinite.prevarinitechat.settings;

import org.apache.commons.lang.StringUtils;

public class PluginSettings {
    private InterServerSetting interServerSetting;
    private String channelName;





    enum InterServerSetting{
        BUNGEE,
        REDIS,
        NONE;
    }
}
