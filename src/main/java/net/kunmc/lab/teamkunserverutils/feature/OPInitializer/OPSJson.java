package net.kunmc.lab.teamkunserverutils.feature.OPInitializer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OPSJson {

  private List<OPPlayer> list = new ArrayList<>();

  public void add(OPPlayer player) {
    this.list.add(player);
  }

  public boolean contains(UUID uuid) {
    for (OPPlayer player : list) {
      if (player.getUUID().equals(uuid.toString())) {
        return true;
      }
    }

    return false;
  }
}
