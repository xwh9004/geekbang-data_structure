package com.pattern.Interpreter;

import java.util.Map;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:40 on 2020/5/22
 * @version V0.1
 * @classNmae Expression
 */
public interface Expression {

   boolean interpret(Map<String,Long> stats);
}
