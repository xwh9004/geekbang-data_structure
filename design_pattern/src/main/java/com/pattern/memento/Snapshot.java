package com.pattern.memento;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:55 on 2020/5/20
 * @version V0.1
 * @classNmae Snapshots
 */
public class Snapshot {
    private String text;

    public Snapshot(InputString input) {
        this.text = input.getString();
    }

    public String getText(){
        return text;
    }

}
