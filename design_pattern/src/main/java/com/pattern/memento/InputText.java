package com.pattern.memento;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:05 on 2020/5/20
 * @version V0.1
 * @classNmae InputText
 */

/**
 * >hello
 * >:list
 * hello
 * >world
 * >:list
 * helloworld
 * >:undo
 * >:list
 * hello
 */
public class InputText {

    private StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
//        InputText inputText = new InputText();
//        SnapshotsHolder snapshotsHolder = new SnapshotsHolder();
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String input = scanner.next();
//            if (input.equals(":list")) {
//                System.out.println(inputText.toString());
//            } else if (input.equals(":undo")) {
//                InputText snapshot = snapshotsHolder.popSnapshot();
//                inputText.setText(snapshot.getText());
//            } else {
//                snapshotsHolder.pushSnapshot(inputText);
//                inputText.append(input);
//            }
//        }

    }

    public String getText() {
       return sb.toString();
    }

    public void setText(String text) {
        this.sb.replace(0, sb.length(), text);
    }
    public void append(String text){
        sb.append(text);
    }

    @Override
    public String toString() {
        return sb.toString();
    }

}
