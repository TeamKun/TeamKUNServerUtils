package net.kunmc.lab.teamkunserverutils.command.opsinitializer;

import net.kunmc.lab.commandlib.CommandContext;
import net.kunmc.lab.teamkunserverutils.command.BaseCommand;
import net.kunmc.lab.teamkunserverutils.command.CommandName;
import net.kunmc.lab.teamkunserverutils.common.utils.MessageUtil;
import net.kunmc.lab.teamkunserverutils.feature.opinitializer.OPInitializer;
import org.jetbrains.annotations.NotNull;

public class InitCommand extends BaseCommand {

  public InitCommand() {
    super(CommandName.INIT);
  }

  @Override
  protected void execute(@NotNull CommandContext ctx) {
    MessageUtil.sendCommandFeedback(ctx, OPInitializer.getINSTANCE().initializeOPS());
  }
}
