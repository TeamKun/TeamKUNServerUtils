package net.kunmc.lab.teamkunserverutils.feature.opinitializer;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import net.kunmc.lab.teamkunserverutils.State;
import net.kunmc.lab.teamkunserverutils.common.utils.FileUtil;
import net.kunmc.lab.teamkunserverutils.common.utils.MessageUtil;
import net.kunmc.lab.teamkunserverutils.feature.BaseFeature;
import net.kunmc.lab.teamkunserverutils.feature.ExecuteResult;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class OPInitializer extends BaseFeature {

  private static final OPInitializer INSTANCE = new OPInitializer();

  private OPInitializer() {
    super(State.config.enableOPSInitializer);
  }

  public static OPInitializer getINSTANCE() {
    return INSTANCE;
  }

  /**
   * OPSの自動DL機能.
   */
  public void autoDownloadOPS() {
    if (State.config.enableAutoOPSInitialize.value()) {
      MessageUtil.log(this.downloadOPS().message());
    } else {
      MessageUtil.log("自動OPダウンロード機能は無効化されています");
    }
  }

  /**
   * OPSを初期化する.
   */
  public ExecuteResult initializeOPS() {
    try {
      // ops.jsonをダウンロードする
      ExecuteResult result = this.downloadOPS();
      if (!result.isSucceed()) {
        return result;
      }

      // ops.jsonを読み込む
      OPSJson opsJson = this.loadOPS();

      // ops.jsonをもとにopを付与&剥奪
      for (OfflinePlayer offlinePlayer : Bukkit.getOfflinePlayers()) {
        if (opsJson.contains(offlinePlayer.getUniqueId())) {
          offlinePlayer.setOp(true);
        } else {
          offlinePlayer.setOp(false);
        }
      }

      // 成功
      return new ExecuteResult(true, "ops.jsonを初期化しました");
    } catch (FileNotFoundException e) {
      return new ExecuteResult(e);
    }
  }

  /**
   * ops.jsonをDLする.
   */
  private ExecuteResult downloadOPS() {
    return this.execute(() -> {
      // 指定したURLからops.jsonを取得
      return FileUtil.download(State.config.OPSDownloadURL.value(), null, "ops.json");
    });
  }

  /**
   * 配置済みのops.jsonを読み込む
   */
  private OPSJson loadOPS() throws FileNotFoundException {
    InputStreamReader isr = new InputStreamReader(new FileInputStream("ops.json"));
    JsonReader jsr = new JsonReader(isr);
    Gson gson = new Gson();
    List<LinkedTreeMap<String, Object>> outJson = gson.fromJson(jsr, ArrayList.class);

    OPSJson opsJson = new OPSJson();
    for (LinkedTreeMap<String, Object> map : outJson) {
      opsJson.add(
          new OPPlayer(
              (String) map.get("uuid"),
              (String) map.get("name"),
              (Double) map.get("level"),
              (Boolean) map.get("bypassesPlayerLimit"))
      );
    }
    return opsJson;
  }
}
