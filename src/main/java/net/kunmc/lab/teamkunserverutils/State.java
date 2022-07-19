package net.kunmc.lab.teamkunserverutils;

import net.kunmc.lab.teamkunserverutils.feature.FeatureManager;
import org.bukkit.plugin.java.JavaPlugin;

public class State {

  /**
   * プラグインオブジェクト
   */
  public static JavaPlugin plugin;

  /**
   * コンフィグオブジェクト
   */
  public static Config config;

  /**
   * 機能マネージャ
   */
  public static FeatureManager featureManager;
}
