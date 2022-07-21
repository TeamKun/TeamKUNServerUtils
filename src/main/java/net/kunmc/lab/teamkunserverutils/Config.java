package net.kunmc.lab.teamkunserverutils;

import net.kunmc.lab.configlib.BaseConfig;
import net.kunmc.lab.configlib.value.BooleanValue;
import net.kunmc.lab.configlib.value.StringValue;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Config extends BaseConfig {

  public StringValue OPSDownloadURL = new StringValue(" ");
  public BooleanValue enableOPSInitializer = new BooleanValue(true);
  public BooleanValue enableAutoOPSInitialize = new BooleanValue(true);
  public StringValue WEPermissionName = new StringValue("we");

  public Config(@NotNull Plugin plugin) {
    super(plugin);
  }
}
