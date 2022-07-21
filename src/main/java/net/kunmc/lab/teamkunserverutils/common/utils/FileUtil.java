package net.kunmc.lab.teamkunserverutils.common.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import javax.annotation.Nullable;
import net.kunmc.lab.teamkunserverutils.feature.ExecuteResult;

public class FileUtil {

  public static ExecuteResult download(String urlString, @Nullable File targetDirectory,
      String fileName) {
    URL url;

    try {
      // URL生成
      url = new URL(urlString);

      // 対象ディレクトリ取得
      String targetDirectoryPath = "";
      if (targetDirectory != null) {
        targetDirectoryPath = targetDirectory.getPath() + "/";
      }

      // ファイル取得
      DataInputStream in = new DataInputStream(url.openStream());
      DataOutputStream out = new DataOutputStream(
          new FileOutputStream(targetDirectoryPath + fileName));

      byte[] buf = new byte[8192];
      int len = 0;

      //入力ストリームからバイト配列に読み込む。ストリームが終端に達した場合は -1 が返る
      while ((len = in.read(buf)) != -1) {
        //バイト配列を出力ストリームに書き込む
        out.write(buf, 0, len);
      }

      //バッファリングされていたすべての出力バイトを強制的に書き込む
      out.flush();
      return new ExecuteResult(true, urlString.concat("からファイルを取得しました"));
      
    } catch (IOException e) {
      return new ExecuteResult(e);
    }
  }
}
