package net.kunmc.lab.teamkunserverutils.feature;

public class ExecuteResult {

  private boolean isSucceed;
  private String message;

  public ExecuteResult(boolean isSucceed, String message) {
    this.isSucceed = isSucceed;
    this.message = message;
  }

  public ExecuteResult(Throwable throwable) {
    this.isSucceed = false;
    this.message = throwable.getMessage();
  }

  public String message() {
    return this.message;
  }

  public boolean isSucceed() {
    return isSucceed;
  }
}
