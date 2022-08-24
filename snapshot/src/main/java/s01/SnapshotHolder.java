package s01;

import java.util.Stack;

/**
 * @author ImOkkkk
 * @date 2022/8/23 10:11
 * @since 1.0
 */
public class SnapshotHolder {
  private Stack<InputText> snapshots = new Stack<>();

  public InputText popSnapshot() {
    return snapshots.pop();
  }
  public void pushSnapshot(InputText inputText) {
    InputText deepClonedInputText = new InputText();
    deepClonedInputText.setText(inputText.getText());
    snapshots.push(deepClonedInputText);
  }

}
