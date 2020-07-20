package com.pattern.memento;

import java.util.Scanner;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:15 on 2020/5/20
 * @version V0.1
 * @classNmae InputString
 */
public class InputString {
    private StringBuilder sb = new StringBuilder();


    public Snapshot createSnapshot() {
        return new Snapshot(this);
    }

    public void restoreSnapshot(Snapshot snapshot){
        this.sb.replace(0, this.sb.length(), snapshot.getText());
    }
    public String getString(){
        return sb.toString();
    }

    public void append(String text){
        sb.append(text);
    }
    public static void main(String[] args) {

        InputString inputString = new InputString();
        SnapshotsHolder snapshotsHolder = new SnapshotsHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals(":list")) {
                System.out.println(inputString.toString());
            } else if (input.equals(":undo")) {
                Snapshot snapshot = snapshotsHolder.popSnapshot();
                inputString.restoreSnapshot(snapshot);
            } else {
                snapshotsHolder.pushSnapshot(inputString.createSnapshot());
                inputString.append(input);
            }
        }
    }
}
