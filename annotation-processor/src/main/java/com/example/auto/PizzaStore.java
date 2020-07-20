package com.example.auto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 16:15 on 2020/4/29
 * @version V0.1
 * @classNmae PizzaStore
 */
public class PizzaStore {
    //compiler generator code
    private MealFactory factory = new MealFactory();
//
    public Meal order(String mealName) {
        return factory.create(mealName);
//        return mealName;
    }

    public static void main(String[] args) throws IOException {
        PizzaStore pizzaStore = new PizzaStore();
        Meal meal = pizzaStore.order(readConsole());
//        String meal = pizzaStore.order(readConsole());
        System.out.println("Bill: $" + meal.getPrice());
    }

    private static String readConsole() throws IOException {
        System.out.println("What do you like?");
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferRead.readLine();
        return input;
    }
}
