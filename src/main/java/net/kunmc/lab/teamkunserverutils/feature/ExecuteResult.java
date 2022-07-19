package net.kunmc.lab.teamkunserverutils.feature;

public class ExecuteResult {

  private boolean isSucceed;
  private String message;

  public ExecuteResult(boolean isSucceed, String message) {
    this.isSucceed = isSucceed;
    this.message = message;
  }
}
