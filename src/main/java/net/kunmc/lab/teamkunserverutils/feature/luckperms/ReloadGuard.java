package net.kunmc.lab.teamkunserverutils.feature.luckperms;

import java.util.Arrays;
import java.util.List;
import net.kunmc.lab.teamkunserverutils.State;
import net.kunmc.lab.teamkunserverutils.common.constants.CommonConst;
import net.kunmc.lab.teamkunserverutils.common.constants.Decoration;
import net.kunmc.lab.teamkunserverutils.common.utils.MessageUtil;
import net.kunmc.lab.teamkunserverutils.common.utils.PluginUtil;
import net.kunmc.lab.teamkunserverutils.feature.BaseFeature;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ReloadGuard extends BaseFeature implements Listener {

  public ReloadGuard() {
    super(State.config.enableReloadGuard);
    Bukkit.getPluginManager().registerEvents(this, State.plugin);
  }

  @EventHandler(ignoreCancelled = true)
  public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
    List<String> commands = Arrays.asList(event.getMessage().split(" "));

    if (!this.isEnabled()) {
      return;
    }

    if (!commands.get(0).equals("/reload")) {
      return;
    }

    if (!PluginUtil.existsPlugin(CommonConst.LUCKPERMS)) {
      return;
    }
    event.getPlayer().sendMessage(Decoration.RED.code + MessageUtil.getInfoMessage(
        CommonConst.LUCKPERMS + "が導入されているサーバーでのReloadコマンド実行は禁止されています"));

    event.setCancelled(true);
  }
}
