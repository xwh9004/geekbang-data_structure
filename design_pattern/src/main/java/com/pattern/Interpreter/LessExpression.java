package com.pattern.Interpreter;

import java.util.Map;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:42 on 2020/5/22
 * @version V0.1
 * @classNmae GreaterExpression
 */
public class LessExpression implements Expression {
    private String key;

    private long value;

    public LessExpression(String expression){
        String[] exps=expression.split("\\<");
        this.key = exps[0];
        this.value =  Long.valueOf(exps[1]);;

    }

    @Override
    public boolean interpret(Map<String,Long> stats) {
        Long keyVal= stats.get(key);
        return keyVal<value;
    }
}
