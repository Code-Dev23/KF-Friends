package it.codedev.juicefriends;

import lombok.Getter;
import net.md_5.bungee.api.plugin.Plugin;

public final class JuiceFriends extends Plugin {

    @Getter private static JuiceFriends instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {

    }

    // working in progress...
}
