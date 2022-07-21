package net.kunmc.lab.teamkunserverutils.feature.OPInitializer;

public class OPPlayer {

  private String uuid;
  private String name;
  private double level;
  private boolean bypassesPlayerLimit;

  public OPPlayer(String uuid, String name, double level, boolean bypassesPlayerLimit) {
    this.uuid = uuid;
    this.name = name;
    this.level = level;
    this.bypassesPlayerLimit = bypassesPlayerLimit;
  }

  public String getUUID() {
    return this.uuid;
  }

  public String getName() {
    return this.name;
  }
}
