import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 处理资源访问冲突
 * @author ImOkkkk
 * @date 2022/7/25 13:21
 * @since 1.0
 */
public class Logger {

  private static final Logger instance = new Logger();
  private FileWriter writer;

  private Logger() {
    File file = new File("/log.txt");
    try {
      writer = new FileWriter(file, true); // true表示追加写入
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static Logger getInstance() {
    return instance;
  }

  public void log(String message) throws IOException {
    writer.write(message);
  }
}
