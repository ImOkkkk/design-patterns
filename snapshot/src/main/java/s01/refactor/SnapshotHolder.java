package s01.refactor;

import java.util.Stack;

/**
 * @author ImOkkkk
 * @date 2022/8/23 10:45
 * @since 1.0
 */
public class SnapshotHolder {
  private Stack<Snapshot> snapshots = new Stack<>();
  public Snapshot popSnapshot() {
    return snapshots.pop();
  }
  public void pushSnapshot(Snapshot snapshot) {
    snapshots.push(snapshot);
  }

}
