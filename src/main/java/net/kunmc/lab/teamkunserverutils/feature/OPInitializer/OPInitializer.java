package net.kunmc.lab.teamkunserverutils.feature.OPInitializer;

import java.io.File;
import java.util.List;
import net.kunmc.lab.teamkunserverutils.State;
import net.kunmc.lab.teamkunserverutils.feature.BaseFeature;
import net.kunmc.lab.teamkunserverutils.feature.FeatureRunnable;
import net.kunmc.lab.teamkunserverutils.feature.ResultBuilder;
import org.jetbrains.annotations.Nullable;

public class OPInitializer extends BaseFeature {

  public OPInitializer(boolean enable) {
    super(enable, new FeatureRunnable() {
      @Override
      public ResultBuilder run(@Nullable List<Object> args) {
        // コピー元のops.jsonの存在チェック
        File json = new File(
            State.plugin.getDataFolder().getParent().concat("/TeamKUNServerUtils/ops.json"));
        if (!json.exists()) {
          return ResultBuilder.NOTEXISTS_OPS_JSON_ERROR;
        }
        // TODO op権限の再設定
        return null;
      }
    });

    this.runnable.run(null);
  }
}
