package com.example.issues;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 9:35 on 2020/3/30
 * @version V0.1
 * @classNmae PrecisionIssues
 */
public class PrecisionIssuesTest {


    @Test
    public void double_test(){

        System.out.println(0.1+0.2);
        System.out.println(1.0-0.8);
        System.out.println(4.015*100);
        System.out.println(123.3/100);

        double amount1 = 2.15;
        double amount2 = 1.10;
        if (amount1 - amount2 == 1.05)
            System.out.println("OK");
    }
    @Test
    public void bigDecimal_test(){
       //使用 BigDecimal 表示和计算浮点数，且务必使用字符串的构造方法来初始化 BigDecimal
        System.out.println(new BigDecimal(0.1).add(new BigDecimal(0.02)));
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.02")));
        System.out.println(new BigDecimal(1.0).subtract(new BigDecimal(0.8)));
        System.out.println(new BigDecimal(4.015).multiply(new BigDecimal(100)));
        System.out.println(new BigDecimal(123.3).divide(new BigDecimal(100)));


        System.out.println(new BigDecimal("4.015").multiply(new BigDecimal(Double.toString(100))));

        System.out.println(new BigDecimal("4.015").multiply(new BigDecimal(Double.valueOf(100))));
    }

    @Test
    public void format_test(){

//        double num1 = 3.35;
//        float num2 = 3.35f;
//        System.out.println(num1);
//        System.out.println(num2);
//        System.out.println(String.format("%.1f", num1));//四舍五入
//        System.out.println(String.format("%.1f", num2));

        //浮点数的字符串格式化也要通过 BigDecimal 进行。
        BigDecimal num1 = new BigDecimal("3.35");
        BigDecimal num2 = num1.setScale(1, BigDecimal.ROUND_DOWN);
        System.out.println(num2);
        BigDecimal num3 = num1.setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(num3);
    }
    @Test
    public void equal_test(){

        System.out.println(new BigDecimal("1.0").equals(new BigDecimal("1")));

        System.out.println(new BigDecimal("1.0").compareTo(new BigDecimal("1"))==0);
    }
    @Test
    public void overFlow_test(){

        long l = Long.MAX_VALUE;
        System.out.println(l + 1);
        System.out.println(l + 1 == Long.MIN_VALUE);


        try {
            long lo = Long.MAX_VALUE;
            System.out.println(Math.addExact(lo, 1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
