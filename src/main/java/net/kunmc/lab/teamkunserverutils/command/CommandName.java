package net.kunmc.lab.teamkunserverutils.command;

public enum CommandName {
  MAIN("ksu"),
  OP("op"),
  INIT("init");

  private String name;

  CommandName(String name) {
    this.name = name;
  }

  public String getCommandName() {
    return this.name;
  }
}
