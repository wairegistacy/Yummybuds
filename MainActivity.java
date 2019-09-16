package com.example.yummybuds;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.yummybuds.model.Categories;
import com.example.yummybuds.model.Meals;
import com.example.yummybuds.view.home.HomeView;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements HomeView {

    @BindView(R.id.viewPageHeader) ViewPager viewPagerMeal;
    @BindView(R.id.recyclerCategory) RecyclerView recyclerViewCategory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void setMeal(List<Meals.Meal> meal) {

    }

    @Override
    public void setCategory(List<Categories.Category> category) {

    }

    @Override
    public void onErrorLoading(String message) {

    }
}
