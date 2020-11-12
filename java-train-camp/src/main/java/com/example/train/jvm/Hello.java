package com.example.train.jvm;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:31 on 2020/10/16
 * @version V0.1
 * @classNmae Hello
 */
public class Hello {
    public static void main(String[] args) {
        Hello h = new Hello();
        int m =2;
        int n =3;
        double a =1;
        double b =6;
        double c =5;
        if(c<b){
            h.add(a,b);
        }else{
            h.sub(a,b);
        }
        int time =10;
        b =1.0;a=1.0;
        for (int i=0;i<time;i++) {
           h.multi(a,b);
        }


    }

    public double add(double a,double b){
        Hello h = this;
        double num1 =a;
        double num2 =b;
        double num3 = num1+num2;
        return num3;
    }

    public double sub(double a,double b){
        double num1 =a;
        double num2 =b;
        double num3 = num1-num2;
        return num3;
    }
    public double multi(double a,double b){
        double num1 =a;
        double num2 =b;
        double num3 = num1*num2;
        return num3;
    }
    public double divide(double a,double b){
        double num1 =a;
        double num2 =b;
        double num3 = num1/num2;
        return num3;
    }
}
