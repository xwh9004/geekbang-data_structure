package com.example.auto;

import com.meal.factory.Factory;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:37 on 2020/4/29
 * @version V0.1
 * @classNmae CalzonePizza
 */

@Factory(
        id = "Calzone",
        type = Meal.class
)
public class CalzonePizza implements Meal {

    @Override public float getPrice() {
        return 8.5f;
    }
}
