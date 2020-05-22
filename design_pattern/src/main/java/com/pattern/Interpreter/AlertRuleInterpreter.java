package com.pattern.Interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 10:38 on 2020/5/22
 * @version V0.1
 * @classNmae AlertRuleInterpreter
 */
public class AlertRuleInterpreter {

    private List<Expression> list = new ArrayList<>();

    // key1 > 100 && key2 < 1000 || key3 == 200
    public AlertRuleInterpreter(String ruleExpression) {
        ruleExpression = ruleExpression.replace(" ","");
        //||表达式优先级最低
        String[] orExps = ruleExpression.split("\\|\\|");
        Expression expression = null;
        if (orExps != null && orExps.length != 0) {
            for (String exp : orExps) {
                Expression logic  =new  OrExpression();
                if (exp.contains("&&")) {
                    String[] AndExps = exp.split("&&");
                    expression = new AndExpression();
                    Expression childExpression = null;
                    for (String andExp : AndExps) {
                        if (andExp.contains(">")) {
                            childExpression = new GreaterExpression(andExp);
                        } else if (andExp.contains("<")) {
                            childExpression = new LessExpression(andExp);
                        } else if (andExp.contains("==")) {
                            childExpression = new EqualExpression(andExp);
                        }
                        ((AndExpression)expression).addExpress(childExpression);
                    }
                } else if(exp.contains(">")){
                    expression = new GreaterExpression(exp);
                }else if (exp.contains("<")) {
                    expression = new LessExpression(exp);
                } else if (exp.contains("==")) {
                    expression = new EqualExpression(exp);
                }
                ((OrExpression)logic).addExpress(expression);
                list.add(logic);

            }

        }
    }

    public static void main(String[] args) {
        String expression = "key1 > 100 && key2 < 1000 || key3 == 200";
        AlertRuleInterpreter rule = new AlertRuleInterpreter(expression);
        Map stats = new HashMap<>();
        stats.put("key1", 99L);
        stats.put("key2", 800L);
        stats.put("key3", 200L);
       boolean res = rule.interpret(stats);
        System.out.println(res);
    }

    // apiStat = new HashMap<>();
    // apiStat.put("key1", 103);
    // apiStat.put("key2", 987);
    public boolean interpret(Map<String, Long> stats) {
        for (Expression exp : list) {
            if (!exp.interpret(stats)) {
                return false;
            }
        }
        return true;
    }
}
