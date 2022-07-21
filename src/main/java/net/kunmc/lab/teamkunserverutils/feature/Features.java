package net.kunmc.lab.teamkunserverutils.feature;

import net.kunmc.lab.teamkunserverutils.feature.OPInitializer.OPInitializer;

public enum Features {
  OP_INITIALIZER(OPInitializer.getINSTANCE());

  private BaseFeature feature;

  Features(BaseFeature feature) {
    this.feature = feature;
  }

  BaseFeature getInstance() {
    return this.feature;
  }
}
