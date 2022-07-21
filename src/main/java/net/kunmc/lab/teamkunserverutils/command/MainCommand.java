package net.kunmc.lab.teamkunserverutils.command;

import net.kunmc.lab.configlib.ConfigCommandBuilder;
import net.kunmc.lab.teamkunserverutils.State;
import net.kunmc.lab.teamkunserverutils.command.opsinitializer.OpCommand;

public class MainCommand extends BaseCommand {

  public MainCommand() {
    super(CommandName.MAIN);
    addChildren(new ConfigCommandBuilder(State.config).build(),
        new OpCommand());
  }
}
