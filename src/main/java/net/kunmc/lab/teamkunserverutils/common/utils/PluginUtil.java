package net.kunmc.lab.teamkunserverutils.common.utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class PluginUtil {

  public static boolean existsPlugin(String pluginName) {
    Plugin luckPerms = Bukkit.getPluginManager().getPlugin(pluginName);

    if (luckPerms == null) {
      return false;
    }

    return true;
  }
}
