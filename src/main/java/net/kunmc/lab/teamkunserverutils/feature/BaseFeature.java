package net.kunmc.lab.teamkunserverutils.feature;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public abstract class BaseFeature {

  protected FeatureRunnable runnable;
  protected boolean enable;

  public BaseFeature(boolean enable, @NotNull FeatureRunnable runnable) {
    this.enable = enable;
    this.runnable = runnable;
  }

  public ExecuteResult execute(List<Object> args) {
    if (!this.enable) {
      return ResultBuilder.DISABLE_ERROR.build();
    }

    return this.runnable.run(args).build();
  }
}
