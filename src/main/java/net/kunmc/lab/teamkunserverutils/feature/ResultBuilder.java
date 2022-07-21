package net.kunmc.lab.teamkunserverutils.feature;

import net.kunmc.lab.teamkunserverutils.common.constants.Decoration;

public enum ResultBuilder {
  DISABLE_ERROR(false, "エラー: この機能は現在無効化されています", Decoration.RED);

  private boolean isSucceed;
  private String message;
  private Decoration decoration;

  ResultBuilder(boolean isSucceed, String message,
      Decoration decoration) {
    this.isSucceed = isSucceed;
    this.message = message;
    this.decoration = decoration;
  }

  public ExecuteResult build() {
    return new ExecuteResult(this.isSucceed, this.decoration.code.concat(this.message));
  }
}
