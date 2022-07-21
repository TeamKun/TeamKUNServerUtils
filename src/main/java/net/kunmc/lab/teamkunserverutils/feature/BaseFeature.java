package net.kunmc.lab.teamkunserverutils.feature;

import net.kunmc.lab.configlib.value.BooleanValue;
import org.jetbrains.annotations.NotNull;

public abstract class BaseFeature {

  private BooleanValue isEnable;

  public BaseFeature(BooleanValue isEnable) {
    this.isEnable = isEnable;
  }

  protected ExecuteResult execute(@NotNull FeatureRunnable runnable) {
    if (!this.isEnable.value()) {
      return ResultBuilder.DISABLE_ERROR.build();
    }
    return runnable.run();
  }
}
