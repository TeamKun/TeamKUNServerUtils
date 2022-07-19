package net.kunmc.lab.teamkunserverutils;

import net.kunmc.lab.commandlib.CommandLib;
import net.kunmc.lab.teamkunserverutils.command.MainCommand;
import net.kunmc.lab.teamkunserverutils.feature.OPInitializer.OPInitializer;
import org.bukkit.plugin.java.JavaPlugin;

public final class TeamKUNServerUtils extends JavaPlugin {

  @Override
  public void onEnable() {
    State.plugin = this;
    State.config = new Config(this);

    CommandLib.register(this, new MainCommand());

    new OPInitializer(true);
  }

  @Override
  public void onDisable() {
  }
}
