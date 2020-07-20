package com.pattern.memento;

import java.util.Stack;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 17:16 on 2020/5/20
 * @version V0.1
 * @classNmae SnapshotsHolder
 */
public class SnapshotsHolder {
    private Stack<Snapshot> snapshots = new Stack<>();

    public Snapshot popSnapshot() {
        return snapshots.pop();
    }

    public void pushSnapshot(Snapshot snapshot) {
        InputText deepClonedInputText = new InputText();
        snapshots.push(snapshot);
    }
}
