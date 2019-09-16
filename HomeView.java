/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/17/19 5:24 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.example.yummybuds.view.home;

import com.example.yummybuds.model.Categories;
import com.example.yummybuds.model.Meals;

import java.util.List;

public interface HomeView {
    /*
     * TODO 13 Create void method
     *
     * The interface of this method will behave bridging between presenters to activities
     * then activity Overriding the interface
     *
     * 1. behavior, when loading must appear || showLoading();
     * 2. Loading must be removed || hideLoading()
     * 3. Display Meal data (with List <Meal> meals) parameters || setMeals();
     * 4. Displays Category data (with List parameters <Category> category) setCategories();
     * 5. and, Behavior when an error occurs when requesting data to the API
     */
    // TODO 14 showLoading()

    void showLoading();
    void hideLoading();
    void setMeal(List<Meals.Meal> meal);
    void setCategory(List<Categories.Category> category);
    void onErrorLoading(String message);
}
