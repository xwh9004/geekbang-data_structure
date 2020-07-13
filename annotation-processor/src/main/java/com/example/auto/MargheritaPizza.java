package com.example.auto;

import com.meal.factory.Factory;

/**
 * <p><b>Description:</b>
 * TODO
 * <p><b>Company:</b>
 *
 * @author created by Jesse Hsu at 14:35 on 2020/4/29
 * @version V0.1
 * @classNmae MargheritaPizza
 */
@Factory(
        id = "Margherita",
        type = Meal.class
)
public class MargheritaPizza implements Meal {

    @Override public float getPrice() {
        return 6f;
    }
}