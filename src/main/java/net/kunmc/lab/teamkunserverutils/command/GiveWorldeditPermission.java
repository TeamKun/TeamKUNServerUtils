package net.kunmc.lab.teamkunserverutils.command;

import java.util.List;
import net.kunmc.lab.commandlib.CommandContext;
import net.kunmc.lab.teamkunserverutils.State;
import net.kunmc.lab.teamkunserverutils.common.constants.CommonConst;
import net.kunmc.lab.teamkunserverutils.common.utils.MessageUtil;
import net.kunmc.lab.teamkunserverutils.common.utils.PluginUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GiveWorldeditPermission extends BaseCommand {

  public GiveWorldeditPermission() {
    super(CommandName.GIVE_WORLDEDIT_PERMISSION);
    argument(argumentBuilder -> {
      argumentBuilder.entityArgument("player");
    });
  }

  @Override
  protected void execute(@NotNull CommandContext ctx) {
    if (!PluginUtil.existsPlugin(CommonConst.LUCKPERMS)) {
      ctx.sendFailure(
          MessageUtil.getInfoMessage("エラー: このサーバーには" + CommonConst.LUCKPERMS + "が導入されていません"));
      return;
    }

    List<Player> args = (List<Player>) ctx.getParsedArg("player");

    if (args.size() == 0) {
      ctx.sendFailure(
          MessageUtil.getInfoMessage("エラー: 存在しないプレイヤーです"));
      return;
    }

    CommandSender sender = ctx.getSender();
    for (Player player : args) {
      Bukkit.dispatchCommand(sender,
          "lp user " + player.getName() + " parent add " + State.config.WEPermissionName.value());
    }
  }
}
