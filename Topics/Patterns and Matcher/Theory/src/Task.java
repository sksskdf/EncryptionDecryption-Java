// You can experiment here, it won’t be checked

class AlertDialog {
  private String title;
  private String text;
  private String applyButton;
  private String cancelButton;

  private AlertDialog(String title, String text, String applyButton, String cancelButton) {
    this.title = title;
    this.text = text;
    this.applyButton = applyButton;
    this.cancelButton = cancelButton;
  }

  @Override
  public String toString() {
    String str = "";
    if (title != null) {
      str += "The title is: \"" + title + "\"\n";
    }
    if (text != null) {
      str += "The text is: \"" + text + "\"\n";
    }
    if (applyButton != null) {
      str += "The applyButton is: \"" + applyButton + "\"\n";
    }
    if (cancelButton != null) {
      str += "The cancelButton is: \"" + cancelButton + "\"\n";
    }

    return str;
  }

  static class Builder {
    private String title;
    private String text;
    private String applyButton;
    private String cancelButton;

    Builder() {}

    Builder setTitle(String title) {
      this.title = title;
      return this;
    }

    Builder setText(String text) {
      this.text = text;
      return this;
    }

    Builder setApplyButton(String applyButton) {
      this.applyButton = applyButton;
      return this;
    }

    Builder setCancelButton(String cancelButton) {
      this.cancelButton = cancelButton;
      return this;
    }

    AlertDialog build() {
      return new AlertDialog(title, text, applyButton, cancelButton);
    }
  }

  public static void main(String[] args) {
    AlertDialog oneButtonsDialog = new AlertDialog.Builder()
            .setTitle("One button dialog")
            .setText("You can use `Close` only")
            .setCancelButton("Close")
            .build();

    AlertDialog abc = new AlertDialog.Builder()
            .setApplyButton("a")
                    .build();

    System.out.println(oneButtonsDialog);
    System.out.println(abc);
  }
}