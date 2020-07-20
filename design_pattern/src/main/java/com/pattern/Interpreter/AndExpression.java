package com.pattern.Interpreter;

import java.util.ArrayList;
import java.util.List;
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
public class AndExpression implements Expression {
    private List<Expression> exps = new ArrayList<>();

    public AndExpression(){

    }
    public void addExpress(Expression expression){
        exps.add(expression);
    }
    @Override
    public boolean interpret(Map<String,Long> stats) {
        for (Expression expression:exps){
            if(!expression.interpret(stats)){
                return false;
            }
        }
        return true;
    }
}
