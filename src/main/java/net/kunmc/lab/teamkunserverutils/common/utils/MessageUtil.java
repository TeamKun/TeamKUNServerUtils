package net.kunmc.lab.teamkunserverutils.common.utils;

import net.kunmc.lab.commandlib.CommandContext;
import net.kunmc.lab.teamkunserverutils.feature.ExecuteResult;
import org.bukkit.Bukkit;

public class MessageUtil {

  private static final String BASE_MESSAGE = "[TeamKUNServerUtils] ";

  public static void log(String message) {
    Bukkit.getLogger().info(BASE_MESSAGE + message);
  }

  public static void announce(String message) {
    Bukkit.getOnlinePlayers().forEach((player -> {
      player.sendMessage(message);
    }));
  }

  public static void sendCommandFeedback(CommandContext ctx, ExecuteResult result) {
    if (result.isSucceed()) {
      ctx.sendSuccess(BASE_MESSAGE + result.message());
    } else {
      ctx.sendFailure(BASE_MESSAGE + result.message());
    }
  }

  public static String getInfoMessage(String message) {
    return BASE_MESSAGE + message;
  }
}
