package net.kunmc.lab.teamkunserverutils.command.opsinitializer;

import net.kunmc.lab.teamkunserverutils.command.BaseCommand;
import net.kunmc.lab.teamkunserverutils.command.CommandName;

public class OpCommand extends BaseCommand {

  public OpCommand() {
    super(CommandName.OP);

    addChildren(new InitCommand());
  }
}
