package net.kunmc.lab.teamkunserverutils.feature;

import net.kunmc.lab.configlib.value.BooleanValue;
import org.jetbrains.annotations.NotNull;

public abstract class BaseFeature {

  private BooleanValue isEnabled;

  public BaseFeature(BooleanValue isEnabled) {
    this.isEnabled = isEnabled;
  }

  protected ExecuteResult execute(@NotNull FeatureRunnable runnable) {
    if (!this.isEnabled()) {
      return ResultBuilder.DISABLE_ERROR.build();
    }
    return runnable.run();
  }

  protected boolean isEnabled() {
    return this.isEnabled.value();
  }
}
