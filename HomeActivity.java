/*-----------------------------------------------------------------------------
 - Developed by Haerul Muttaqin                                               -
 - Last modified 3/17/19 5:24 AM                                              -
 - Subscribe : https://www.youtube.com/haerulmuttaqin                         -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.example.yummybuds.view.home;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.yummybuds.R;
import com.example.yummybuds.Utils;
import com.example.yummybuds.adapter.RecyclerViewHomeAdapter;
import com.example.yummybuds.adapter.ViewPagerHeaderAdapter;
import com.example.yummybuds.model.Categories;
import com.example.yummybuds.model.Meals;

import java.util.List;

import butterknife.BindView;

// TODO 31 implement the HomeView interface at the end
public class HomeActivity extends AppCompatActivity implements HomeView {

    /*
     * TODO 32 Add @BindView Annotation (1)
     *
     * 1. viewPageHeader
     * 2. recyclerCategory
     *
     */
    @BindView(R.id.viewPageHeader) ViewPager viewPagerMeal;
    @BindView(R.id.recyclerCategory) RecyclerView recyclerViewCategory;

    /*
     *  TODO 33 Create variable for presenter;
     */
    HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        /*
         *  TODO 34 bind the ButterKnife (2)
         */

        /*
         *  TODO 35 Declare the presenter
         *  new HomePresenter(this)
         */
        presenter = new HomePresenter(this);
        presenter.getMeals();
        presenter.getCategories();
    }

    @Override
    public void showLoading() {
       findViewById(R.id.shimmerMeal). setVisibility(View.VISIBLE);
       findViewById(R.id.shimmerCategory). setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        findViewById(R.id.shimmerMeal).setVisibility(View.GONE);
        findViewById(R.id.shimmerCategory). setVisibility(View.GONE);
    }

    @Override
    public void setMeal(List<Meals.Meal> meal) {
     //check meal result
        ViewPagerHeaderAdapter headerAdapter= new ViewPagerHeaderAdapter(meal, this);
        viewPagerMeal.setAdapter(headerAdapter);
        viewPagerMeal.setPadding(20,0,150,0);
        headerAdapter.notifyDataSetChanged();
        //ok

    }

    @Override
    public void setCategory(List<Categories.Category> category) {
        RecyclerViewHomeAdapter homeAdapter= new RecyclerViewHomeAdapter(category,this);
        recyclerViewCategory.setAdapter(homeAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3,GridLayoutManager.VERTICAL,false);
        recyclerViewCategory.setLayoutManager(layoutManager);
        recyclerViewCategory.setNestedScrollingEnabled(true);
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showDialogMessage(this,"Title",message);
    }

    // TODO 36 Overriding the interface

}
