package net.kunmc.lab.teamkunserverutils.command;

import net.kunmc.lab.commandlib.Command;
import org.jetbrains.annotations.NotNull;

public abstract class BaseCommand extends Command {

  public BaseCommand(@NotNull CommandName commandName) {
    super(commandName.getCommandName());
  }
}
